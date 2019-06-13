
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ArrayOfString {

    public static void main(String[] args) {

        String[] kubanRivers = {"Кубань", "Белая", "Псекупс", "Тешебс", "Абин", "Ея", "Абин", "Бейсуг", "Псекупс", "Абин", "Тешебс", "Кочеты", "Кирпили", "Псоу", "Мзымта"};

        Map<String, Integer> kubanRiversMap = new HashMap<>();

        int count = 0;

        for (int i = 0; i < kubanRivers.length; i++) {

            String s = kubanRivers[i];

            for (int j = 0; j < kubanRivers.length; j++) {

                if (s.equals(kubanRivers[j])) {
                    ++count;
                }
            }
            kubanRiversMap.put(s, count);
            count = 0;
        }

        Iterator<Map.Entry<String, Integer>> iterator = kubanRiversMap.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, Integer> pair = iterator.next();
            String key = pair.getKey();
            Integer value = pair.getValue();

            System.out.println("Наименование: " + key + " / " + "Количество повторений: " + value);
        }
    }
}
