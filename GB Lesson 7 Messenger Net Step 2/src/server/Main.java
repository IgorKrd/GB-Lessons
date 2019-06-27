package server;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.Vector;
import java.util.concurrent.Callable;


public class Main {

    private Vector<ClientHandler> clients;

    public Main() throws SQLException {
        ServerSocket server = null;
        Socket socket = null;
        clients = new Vector<>();

        try {
            AuthService.connect();

            server = new ServerSocket(8191);
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
    public  void subscribe(ClientHandler client) {
        clients.add(client);
    }

    // отписываем клиента от рассылки сообщений
    public  void unsubscribe(ClientHandler client) {
        clients.remove(client);
    }

    // метод широковещательной рассылки

    public void broadCastMsg(String msg) {
        for (ClientHandler o : clients) {
            o.sendMsg(msg);
        }
    }

    // метод проверки, что запрашиваемый nick занят/свободен

    public  boolean nickIsBusy (String nick) {

        for(ClientHandler c: clients) {
            if (c.getName().equals(nick)) {
                return true;
            }
        }
        return false;
    }
    /////
    // метод персонифицированной отправки сообщений

    public void channelMsg (String msg, String... nicks) {


        for (ClientHandler a : clients) {
            for (String nick : nicks) {

                if (a.getName().equals(nick)) {
                    a.sendMsg(msg);

                }
            }
        }
    }
    ////

}




