
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DayOfWeekMain {

    public static void main(final String[] args) throws IOException {
        System.out.println("Количество рабочих часов до конца недели: " + getWorkingHours());
    }

    enum DayOfWeek {
        SUNDAY(1, 0), //начало недели с Воскресенья по Английской традиции.
        MONDAY(2, 8),
        TUESDAY(3, 8),
        WEDNESDAY(4, 8),
        THURSDAY(5, 8),
        FRIDAY(6, 8),
        SATURDAY(7, 0);


        private final int dayNumber;
        private int workingHoursPerDay;


        DayOfWeek(int dayNumber, int workingHoursPerDay) {
            this.dayNumber = dayNumber;
            this.workingHoursPerDay = workingHoursPerDay;
        }

        public int getDayNumber() {
            return dayNumber;
        }

        public int getWorkingHoursPerDay() {
            return workingHoursPerDay;
        }
    }


    public static int getWorkingHours() throws IOException {
        int workingTime = 0;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите выбранный день недели (SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY): ");

        String day = reader.readLine();

        int a = DayOfWeek.valueOf(day).getDayNumber(); // получаем номер дня недели по его названию

        if (a == 1 || a == 7) {
            System.out.println("Сегодня выходной!");
        } else {
            for (DayOfWeek days : DayOfWeek.values()) {  // проходим по всем "дням" дням неделе следующими за указаным и складываем рабочее время в эти дни
                if (days.getDayNumber() >= a) {
                    workingTime += days.getWorkingHoursPerDay();
                }
            }

        }
        return workingTime;
    }
}
