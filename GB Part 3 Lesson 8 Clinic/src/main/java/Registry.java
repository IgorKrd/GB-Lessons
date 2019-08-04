
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public class Registry {

private static int roomNumber;
private static String doctorType;
private static String doctorsName;


    public static void askToPatient() throws IOException, SQLException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException, IllegalAccessException, InstantiationException {

        System.out.println("Добрый день! Как Вас зовут?");

        Patient.speak();

        while (true) {
            System.out.println("На что жалуетесь? Уважаемый " + Patient.getName() + "!");
            Patient.requestToTreatment();
            String req = Patient.request;

            if (!req.equals("")) {
                getDoctorsRoomNumber(req);
                getDoctorsType(roomNumber);
                referralPatientToDoctor();
                break;
            } else {System.out.println("Прошу Вас сообщить причину обращения к нам!"); }
        }
    }



    public static int getDoctorsRoomNumber(String request) throws SQLException, IOException {

        if (request.contains("зуб") || request.contains("зубы") || request.contains("десна") || request.contains("дёсны")) {
            roomNumber = DbService.getRoomNumberByCause("Dantist");


        } else if (request.contains("глаз") || request.contains("глаза")) {
            roomNumber = DbService.getRoomNumberByCause("Ophthalmologist");


        } else if (request.contains("ухо") || request.contains("нос") || request.contains("уши") || request.contains("горло")) {
            roomNumber = DbService.getRoomNumberByCause("ENT");


        } else if (request.contains("нога") || request.contains("рука") || request.contains("спина") || request.contains("шея") || request.contains("поясница")) {
            roomNumber = DbService.getRoomNumberByCause("Surgeon");


        } else {System.out.println("У нас нет такого специалиста");}


        return roomNumber;
    }

    public static String getDoctorsType(int roomNumber) throws SQLException {

        doctorType   = DbService.getDoctorsTypeByRoomNumber(roomNumber);
        return doctorType;
    }

    public static String getDoctorsName(int roomNumber, String doctorType) throws SQLException {

        doctorsName   = DbService.getDoctorsNameByRoomNumberAndDoctorType(roomNumber,doctorType);
        return doctorsName;
    }


    public static void referralPatientToDoctor() throws SQLException, IOException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException, IllegalAccessException, InstantiationException {

        roomNumber = getDoctorsRoomNumber(Patient.request);
        doctorType = getDoctorsType(roomNumber);
        doctorsName = getDoctorsName(roomNumber,doctorType);

        System.out.println("Уважаемый " + Patient.getName() + ", Вам необходимо пройти в кабинет № " + roomNumber +
                " на приём к врачу " + doctorsName);


        Patient.goToDoctor(roomNumber, doctorType, doctorsName);

    }
}
