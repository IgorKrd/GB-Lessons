

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PassVerification {
    private static Pattern pattern;
    private static Matcher matcher;
    private static int passWordLength = 8;

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String s = reader.readLine();

        if (s.length() < passWordLength)
            // проверяем требование по количеству символов в пароле
            System.out.println("Пароль должен быть не менее 8 символов");
        else
            // проверяем наличие "маленьких" латинских букв.
            pattern = Pattern.compile("[a-z]");
        matcher = pattern.matcher(s);

        if (!matcher.find())
            System.out.println("#1 Пароль должен содержать латинские буквы нижнего регистра");

        else
            // проверяем наличие "больших" латинских букв.
            pattern = Pattern.compile("[A-Z]");
        matcher = pattern.matcher(s);

        if (!matcher.find())
            System.out.println("#2 Пароль должен содержать латинские буквы верхнего регистра");

        else
            // проверяем наличие цифр.
            pattern = Pattern.compile("\\d");  //("[0-9]");
        matcher = pattern.matcher(s);

        if (!matcher.find())
            System.out.println("#3 Пароль должен содержать цифры");

        else
            // проверяем наличие спец.символов.
            pattern = Pattern.compile("\\W");  //("[@#$%^&*~]")
        matcher = pattern.matcher(s);

        if (!matcher.find())
            System.out.println("#4 Пароль должен содержать спец.символы");
        else
            /*// проверяем на отсутствие "qwerty". Не удалось реализовать полностью!!
            pattern = Pattern.compile(".*q(?!werty)*");   //(".*q(?!werty).*");
        matcher = pattern.matcher(s);

        if (!matcher.matches()) {
            System.out.println("#5 Пароль не должен содержать последовательность 'qwerty'");
        } else
            //actiontarget.setId("actiontarget");
            //actiontarget.setText("Good!");
            pattern = Pattern.compile("q");   //(".*q(?!werty).*");
        matcher = pattern.matcher(s);
        if (matcher.matches()) {
            System.out.println("есть");
        } else
        */

            System.out.println("ok");
    }

}
