package server;


import com.sun.security.ntlm.Client;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;


public class Main {


    private Vector<ClientHandler> clients;


    public Main() {
        clients = new Vector<>();
        ServerSocket server = null;
        Socket socket = null;


        try {
            server = new ServerSocket(8191);
            System.out.println("Сервер запущен");

            while (true) {
                socket = server.accept();  // здесь создаётся socket
                System.out.println("Клиент подключился");
                clients.add(new ClientHandler(socket, this));


                /*   к сожалению не смог разобраться со способом получения информации о завершении сессии со стороны "клиента"
                для удаления его из списка...
                if (????????????) {
                    clients.remove(new ClientHandler(socket, this));
                    System.out.println("Клиент отключился");
                }
               */
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

        }
    }

    public void broadCastMsg(String msg) {
        for (ClientHandler o : clients) {
            o.sendMsg(msg);
        }

    }


}
