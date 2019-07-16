


//1. Создать таблицу работников и выполнить CRUD операции (Create, update, delete, select) и вывести результат в консоль.

import java.sql.*;


public class PersonnelDataBase {

    private static Connection conn;
    private static Statement stmt;

    public static void main(String[] args) throws SQLException {

        try {
            connection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // работа с БД

        // создаём таблицу БД

        stmt.executeUpdate("CREATE TABLE  personnelList (" + "id INTEGER PRIMARY KEY AUTOINCREMENT," + "name TEXT,"
                + "surname TEXT," + "position TEXT," + "salary INTEGER)");

        // вносим данные в поля созданной таблицы

        stmt.executeUpdate("INSERT INTO personnelList (name, surname, position, salary)\n" +
                "VALUES('Ivan', 'Pavlov', 'Director', 100000)");

        stmt.executeUpdate("INSERT INTO personnelList (name, surname, position, salary) \n" +
                "VALUES('Sergey', 'Kolesov', 'Senior Engineer', 80000)");

        stmt.executeUpdate("INSERT INTO personnelList (name, surname, position, salary) \n" +
                "VALUES('Igor', 'Kiselev', 'Java Junior Developer', 50000)");

        stmt.executeUpdate("INSERT INTO personnelList (name, surname, position, salary) \n" +
                "VALUES('Ballast', 'Ballast', 'MEGATRUE MANAGER', 300000)");

        // запрашиваем данные из таблицы

        ResultSet rs = stmt.executeQuery("SELECT * FROM personnelList");

//      ResultSetMetaData rsmd = rs.getMetaData();
//
//        for (int i = 1; i <= rsmd.getColumnCount(); i++) {
//            System.out.println(rsmd.getColumnName(i) + " " + rsmd.getColumnType(i));
//
//        }

        while (rs.next()) {
            System.out.println(rs.getInt("id") + " " + rs.getString("name") + " " + rs.getString("surname") + " " + rs.getString("position") + " " + rs.getInt("salary"));
        }
        System.out.println();

        // удаляем запись из таблицы

        stmt.executeUpdate("DELETE FROM personnelList WHERE position = 'MEGATRUE MANAGER'");

        System.out.println();

        rs = stmt.executeQuery("SELECT * FROM personnelList");


        while (rs.next()) {
            System.out.println(rs.getInt("id") + " " + rs.getString("name") + " " + rs.getString("surname") + " " + rs.getString("position") + " " + rs.getInt("salary"));
        }


        // вносим изменения в БД

        stmt.executeUpdate("UPDATE personnelList SET position = 'Middle Java Developer' where id = 3");

        stmt.executeUpdate("UPDATE personnelList SET salary = 80000 where id = 3");

        System.out.println();

        rs = stmt.executeQuery("SELECT * FROM personnelList");


        while (rs.next()) {
            System.out.println(rs.getInt("id") + " " + rs.getString("name") + " " + rs.getString("surname") + " " + rs.getString("position") + " " + rs.getInt("salary"));
        }

        //удаление таблицы из БД

       stmt.execute("DROP TABLE personnelList");



        disconnect();

    }

    public static void connection() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:personnelDB.db");
        stmt = conn.createStatement();
    }

    public static void disconnect() throws SQLException {
        conn.close();

    }
}
