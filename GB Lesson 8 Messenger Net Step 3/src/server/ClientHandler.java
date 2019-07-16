package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class ClientHandler {

    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private Main server;
    private String nick;
    List<String> blackList;

    public boolean checkBlackList(String nick) {
        return blackList.contains(nick);
    }


    public ClientHandler(Socket socket, Main server) {

        try {
            this.blackList = new ArrayList<>();
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
                            if (str.startsWith("/auth ")) {
                                String[] tokens = str.split(" ");
                                String newNick = AuthService.getNickByLoginAndPass(tokens[1], tokens[2]);
                                //// проверка правильности пары логин/пароль и того, что с таким ником пользователя нет в чате
                                if (newNick != null) {
                                    if (!server.nickIsBusy(newNick)) {
                                        sendMsg("/authok " + newNick); ////
                                        nick = newNick;
                                        server.subscribe(ClientHandler.this);
                                        System.out.println("Клиент " + nick + " подключился");
                                        break;
                                    } else {
                                        sendMsg("Пользователь с этим именем уже подключён");
                                    }
                                } else {
                                    sendMsg("Неверный логин/пароль");
                                }
                            }
                            server.broadCastMsg(ClientHandler.this, nick + ": " + str);
                        }

                        /////

                        while (true) {  // цикл для работы со служебными сообщениями
                            String str = in.readUTF();
                            if (str.startsWith("/")) {
                                if (str.equals("/end")) {
                                    out.writeUTF("/serverclosed");
                                    break;
                                }
                                if (str.startsWith("/w ")) {
                                    String[] elements = str.split(" ", 3);

                                    server.personalMsg(ClientHandler.this, elements[1], elements[2]);
                                }
                                if (str.startsWith("/blacklist ")) {
                                    String[] elements = str.split(" ");
                                    blackList.add(elements[1]);
                                    sendMsg("Вы добавили пользователя " + elements[1] + " в чёрный список");
                                }
                            } else {
                                server.broadCastMsg(ClientHandler.this, nick + ": " + str);
                            }
                        }

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
                    server.broadCastMsg(ClientHandler.this, "Пользователь " + nick + " покинул чат"); ////
                    System.out.println("Клиент " + nick + " отключился");


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


    public String getNick() {
        return nick;

    }
}
