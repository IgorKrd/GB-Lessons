package server;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.Vector;



public class Main {

    private Vector<ClientHandler> clients;

    public Main() throws SQLException {
        ServerSocket server = null;
        Socket socket = null;
        clients = new Vector<>();

        try {
            AuthService.connect();

            server = new ServerSocket(8190);
            System.out.println("Сервер запущен");

            while (true) {
                socket = server.accept();
                System.out.println("Канал к клиенту установлен.Этап авторизации клиента.");
                new ClientHandler(socket, this);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            AuthService.disconnect();
            System.out.println("Клиент отключился");
        }
    }

    // подписываем клиента на рассылку
    public void subscribe(ClientHandler client) {

        clients.add(client);
        broadcastClientList();
    }

    // отписываем клиента от рассылки сообщений
    public void unsubscribe(ClientHandler client) {

        clients.remove(client);
        broadcastClientList();
    }

    // метод широковещательной рассылки

    public void broadCastMsg(ClientHandler from, String msg) {
        for (ClientHandler o : clients) {
            if (!o.checkBlackList(from.getNick())) {
                o.sendMsg(msg);
            }
        }
    }

    // метод проверки, что запрашиваемый nick занят/свободен

    public boolean nickIsBusy(String nick) {

        for (ClientHandler c : clients) {
            if (c.getNick().equals(nick)) {
                return true;
            }
        }
        return false;
    }
    /////
    // метод персонифицированной отправки сообщений

    public void personalMsg(ClientHandler from, String nickTo, String msg) {
        for (ClientHandler o : clients) {
            if (o.getNick().equals(nickTo)) {
                o.sendMsg("from " + from.getNick() + ": " + msg);
                from.sendMsg("to " + nickTo + ": " + msg);
                return;
            }
        }
        from.sendMsg("Клиент с ником " + nickTo + " не найден в чате");
    }

    public void broadcastClientList() {

        StringBuilder sb = new StringBuilder();
        sb.append("/clientlist ");
        for (ClientHandler c : clients) {
            sb.append(c.getNick() + " ");
        }
        String out = sb.toString();
        for (ClientHandler c : clients) {
            c.sendMsg(out);

        }
    }
}




