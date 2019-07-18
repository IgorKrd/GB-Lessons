// 1. Прочитать файл (около 50 байт) в байтовый массив и вывести этот массив в консоль;
// 2. Последовательно сшить 5 файлов в один (файлы примерно 100 байт). Может пригодиться следующая конструкция:
//     ArrayList<InputStream> al = new ArrayList<>(); ... Enumeration<InputStream> e = Collections.enumeration(al);
// 3. Написать консольное приложение, которое умеет постранично читать текстовые файлы (размером > 10 mb).
//    Вводим страницу (за страницу можно принять 1800 символов), программа выводит ее в консоль.
//    Контролируем время выполнения: программа не должна загружаться дольше 10 секунд, а чтение – занимать свыше 5 секунд.


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

public class MainHomeWork {

    private static String filePathOne = "resource/homework";
    private static String filePathTwo = "resource/homework/text for read.txt";


    private static String filePathThree = "resource/homework/test1.txt";
    private static String filePathFour = "resource/homework/test2.txt";
    private static String filePathFive = "resource/homework/test3.txt";
    private static String filePathSix = "resource/homework/test4.txt";
    private static String filePathSeven = "resource/homework/test5.txt";

    private static String filePathEight = "resource/homework/big text file.txt";
    private static String randomAccessMode = "r";


    public static void main(String[] args) throws IOException {
        // методы для решения задач по п.1 Домашней работы
        createFile();                        // создаём директорию и файл
        readTheFile();                       // читаем ранее созданный файл
        readByteArray();                     // читаем байтовый массив из файла

        // метод для решения задачи по п.2 Домашней работы

        unitedTheSequenceOfFile();           // Объединяем байты их пяти файлов и читаем их все

        // метод для решения задачи по п.3 Домашней работы

        readBookByPage();     // Читаем большой текстовый файл и выводим постранично в консоль


    }


    static void createFile() throws IOException {

        File file = new File(MainHomeWork.filePathOne);
        file.mkdirs();

        file = new File(MainHomeWork.filePathTwo);
        file.createNewFile();

        String path = MainHomeWork.filePathTwo;

    }

    static void readTheFile() throws IOException {

        FileInputStream inputStream = new FileInputStream(MainHomeWork.filePathTwo);
        int x;
        System.out.println("Читаем без учёта кодировки: ");
        while ((x = inputStream.read()) != -1) {
            System.out.print((char) x);
        }
        System.out.println();
        System.out.println();

        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(MainHomeWork.filePathTwo), "UTF-8");
        int y;
        System.out.println("Читаем с учётом кодировки: ");
        while ((y = inputStreamReader.read()) != -1) {
            System.out.print((char) y);
        }
        System.out.println();
        System.out.println();
    }


    static void readByteArray() throws IOException {

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(Files.readAllBytes(Paths.get(MainHomeWork.filePathTwo)));

        int z;
        System.out.println("Читаем байтовый массив из файла: ");
        while ((z = byteArrayInputStream.read()) != -1) {
            System.out.print((char) z);
        }
        System.out.println();
        System.out.println();
    }


    static void unitedTheSequenceOfFile() throws IOException {

        ArrayList<String> pathList = new ArrayList<String>();

        pathList.add(filePathThree);
        pathList.add(filePathFour);
        pathList.add(filePathFive);
        pathList.add(filePathSix);
        pathList.add(filePathSeven);


        ArrayList<InputStream> inputStreamArrayList = new ArrayList<>();

        for (int i = 0; i < pathList.size(); i++) {
            inputStreamArrayList.add(new FileInputStream(pathList.get(i)));
        }
        SequenceInputStream in = new SequenceInputStream(Collections.enumeration(inputStreamArrayList));

        int a;
        System.out.println("Объединяем байты их пяти файлов и читаем их все: ");
        System.out.println();

        while ((a = in.read()) != -1) {
            System.out.print((char) a);
        }
        System.out.println();
        System.out.println("====================================================================");
        System.out.println();
    }

    static void readBookByPage() {

        System.out.println("====================================================================");
        System.out.println();

        long timeForLoad = System.currentTimeMillis();

        try (RandomAccessFile randomAccessFile = new RandomAccessFile((MainHomeWork.filePathEight), randomAccessMode);
             BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            long bookFileSize = randomAccessFile.length();
            long bookPageSize = 1800;
            long countOfPage = bookFileSize / bookPageSize;

            byte[] bytesPortion = new byte[1800];

            System.out.println("Затрачено времени на чтение файла книги:  " + (System.currentTimeMillis() - timeForLoad));

            System.out.println("Количество страниц в книге: " + countOfPage);

            while (true) {
                System.out.println("Введите номер нужной страницы или '-1' для выхода из программы: ");

                long seekingPage = Long.parseLong(reader.readLine()); //считываем номер искомой страницы

                long timeOfRead = System.currentTimeMillis(); // фиксируем время начала поиска нужной страницы

                if (seekingPage <= countOfPage && seekingPage >= 0) {

                    randomAccessFile.seek(seekingPage * bookPageSize); // ищем нужную страницу в книге
                    randomAccessFile.read(bytesPortion, 0, bytesPortion.length); // читаем нужную страницу

                    for (byte bp : bytesPortion) {
                        System.out.print((char) bp);
                    }  // вывод выбранной страницы на экран
                    System.out.println();
                    System.out.println("Затрачено времени на поиск и вывод страницы:  " + (System.currentTimeMillis() - timeOfRead));

                } else if (seekingPage == -1) {
                    System.out.println("Выход из книги.");
                    System.exit(0);
                } else {
                    System.out.println("Введите правильный номер страницы в пределах: " + countOfPage + "или '-1' для выхода из программы.");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


