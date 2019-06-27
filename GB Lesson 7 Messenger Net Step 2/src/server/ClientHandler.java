package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


public class ClientHandler {

    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private Main server;
    private String nick;


    public ClientHandler(Socket socket, Main server) {

        try {
            this.socket = socket;
            this.server = server;
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());


            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {  // цикл для авторизации клиентов
                            String str = in.readUTF();
                            if (str.startsWith("/auth")) {
                                String[] tokens = str.split(" ");
                                String newNick = AuthService.getNickByLoginAndPass(tokens[1], tokens[2]);

                                if ((newNick != null) && (!server.nickIsBusy(newNick))) { //// проверка правильности пары логин/пароль и того, что с таким ником пользователя нет в чате

                                    nick = newNick;
                                    server.subscribe(ClientHandler.this);
                                    System.out.println("Клиент подключился");
                                    sendMsg("/authok");
                                    break;
                                } else {
                                    sendMsg("Неверный логин/пароль или \n пользователь с этим именем уже подключён");
                                }
                            }

                            server.broadCastMsg(str);
                        }
                        /////

                        while (true) {  //цикл для персонифицированной отправки сообщений
                            String str = in.readUTF();
                            if (str.startsWith("/w ")) {
                                String[] elements = str.split(" ");

                                server.channelMsg(nick + ">>>" + elements[1] + " " + elements[2], nick, elements[1]);
                                break;
                            } else {
                                server.broadCastMsg(nick + " : " + str);
                            }
                        }

                        ///

                        while (true) {  // цикл для основной работы мессенжера
                            String str = in.readUTF();
                            if (str.equals("/end")) {
                                break;
                            }
                            server.broadCastMsg(nick + " : " + str);
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                    try {
                        out.writeUTF("Подтверждение выхода");///
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            in.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            out.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    server.unsubscribe(ClientHandler.this);
                    server.broadCastMsg("Пользователь: " + nick + " покинул чат");
                    System.out.println("Клиент отключился");


                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void sendMsg(String msg) {

        try {
            out.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public String getName() {
        return nick;

    }
}
