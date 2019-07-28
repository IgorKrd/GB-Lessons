package server;


import java.sql.*;
import java.util.ArrayList;


public class AuthService {

    private static Connection connection;
    private static Statement stmt;


    private static ArrayList<String> loginList = new ArrayList<>();
    private static ArrayList<String> userNicksList = new ArrayList<>();


    public static void connect() throws SQLException {
        try {
            // обращение к драйверу
            Class.forName("org.sqlite.JDBC");
            // установка подключения
            connection = DriverManager.getConnection("jdbc:sqlite:mainDB.db");
            // создание Statement для возможности оправки запросов
            stmt = connection.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static String getNickByLoginAndPass(String login, String pass)  {

        try {
        connect();

            // формирование запроса
            String sql = String.format("SELECT nickname FROM main where login = '%s' and password = '%s'", login, pass);

            // оправка запроса и получение ответа
            ResultSet rs = stmt.executeQuery(sql);

            // если есть строка возвращаем результат если нет то вернеться null
            if (rs.next()) {

                return rs.getString(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        //disconnect();
        return null;
    }


    public static boolean tryToRegNewUsers(String login, String password, String userNick) throws SQLException {

        //connect();

        boolean tryToRegs;

        try {
            String sqlReg = String.format("INSERT INTO main (login, password, nickname) VALUES (\"%s\", \"%s\", \"%s\")", login, password, userNick);
            stmt.executeUpdate(sqlReg);
            tryToRegs = true;

        } catch (SQLException e) {
            e.printStackTrace();
            tryToRegs = false;
        }
        disconnect();
        return tryToRegs;
    }

    public static boolean checkNewLogin(String login) throws SQLException {

        connect();
        boolean checkLogin = false;

        try {
            ResultSet result = stmt.executeQuery("SELECT login FROM main");

            while (result.next()) {
                String a = result.getString("login");
                loginList.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        for (int i = 0; i < loginList.size(); i++) {

            if (login.trim().equals("")) {

                checkLogin = false;
//                PassValidateController.actiontargetFirst.setFill(Color.FIREBRICK);
//                PassValidateController.actiontargetFirst.setText("Input your login.");

            } else if (loginList.get(i).equals(login)) {

                checkLogin = false;
//                PassValidateController.actiontargetFirst.setFill(Color.FIREBRICK);
//                PassValidateController.actiontargetFirst.setText("This Login is already taken by another user! Please think up another 'login'");
                break;

            } else {
                checkLogin = true;
//                PassValidateController.actiontargetFirst.setFill(Color.GREEN);
//                PassValidateController.actiontargetFirst.setText("Ok. This Login is suitable!");
            }

        }
        //disconnect();
        return checkLogin;
    }

    public static boolean checkNewNick(String userNick) throws SQLException {

        //connect();

        boolean checkNick = false;

        try {
            ResultSet rs = stmt.executeQuery("SELECT nickname FROM main");

            while (rs.next()) {
                String s = rs.getString("nickname");
                userNicksList.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        for (int i = 0; i < userNicksList.size(); i++) {

            if (userNick.trim().equals("")) {
                checkNick = false;
//                PassValidateController.actiontargetSecond.setFill(Color.FIREBRICK);
//                PassValidateController.actiontargetSecond.setText("Input your Nickname.");

            } else if (userNicksList.get(i).equals(userNick)) {
                checkNick = false;
//                PassValidateController.actiontargetSecond.setFill(Color.FIREBRICK);
//                PassValidateController.actiontargetSecond.setText("This Nick is already taken by another user! Please think up another 'Nick'");
                break;

            } else {
                checkNick = true;
//                PassValidateController.actiontargetSecond.setFill(Color.GREEN);
//                PassValidateController.actiontargetSecond.setText("Ok. This Nick is suitable!");
            }
        }
        disconnect();
        return checkNick;
    }


    public static void disconnect() {
        try {
            // закрываем соединение
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}