import java.sql.*;

public class DbService {

    private static Connection connection;
    private static Statement stmt;

    public static void connect() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:ClinicDB.db");
            stmt = connection.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static int getRoomNumberByCause(String doctorType) throws SQLException {

        String sql = String.format("select roomNumber FROM doctors where doctorType = '%s' ", doctorType);

        ResultSet rs = stmt.executeQuery(sql);

        int roomNumber = rs.getInt(1);

        return roomNumber;
    }

    public static String getDoctorsTypeByRoomNumber(int roomNumber) throws SQLException {

        String sql = String.format("select doctorType FROM doctors where roomNumber = '%s' ", roomNumber);

        ResultSet rs = stmt.executeQuery(sql);

        String doctorType = rs.getString(1);


        return doctorType;
    }

    public static String getDoctorsNameByRoomNumberAndDoctorType(int roomNumber, String doctorType) throws SQLException {

        String sql = String.format("select doctorName FROM doctors where roomNumber = '%s' and doctorType = '%s' " , roomNumber, doctorType);

        ResultSet rs = stmt.executeQuery(sql);

        String doctorsName = rs.getString(1);


        return doctorsName;
    }



    public static void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
