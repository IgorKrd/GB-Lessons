package Java3Lesson1;
/*
1. Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);
2. Написать метод, который преобразует массив в ArrayList;
3. Большая задача:
Есть классы Java3Lesson1.Fruit -> Java3Lesson1.Apple, Java3Lesson1.Orange (больше фруктов не надо);
Класс Java3Lesson1.Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
Для хранения фруктов внутри коробки можно использовать ArrayList;
Сделать метод getWeight(), который высчитывает вес коробки, зная количество фруктов и вес одного фрукта (вес яблока – 1.0f, апельсина – 1.5f. Не важно, в каких это единицах);
Внутри класса Коробка сделать метод compare, который позволяет сравнить текущую коробку с той, которую подадут в compare в качестве параметра, true – если она равны по весу, false – в противном случае (коробки с яблоками мы можем сравнивать с коробками с апельсинами);
Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую (помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами). Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в этой коробке;
Не забываем про метод добавления фрукта в коробку.
 */


import java.util.ArrayList;
import java.util.Arrays;



public class Main {


    public static void main(String[] args) {

        // решение по п.1 задания

        int posFirst = 0;
        int posSecond = 3;


        String[] arrayStr = {"один", "два", "три", "четыре", "пять"};

        Integer[] arrayInt = {1, 2, 3, 4, 5};

        Object[] arrayObjects = new Object[5];

        for (int i = 0; i < arrayObjects.length ; i++) {
            arrayObjects[i] = new Object();

        }

        System.out.println("Меняем местами элементы на позициях: " + posFirst + " и " + posSecond );

        changePosition(arrayStr, posFirst,posSecond);
        System.out.println();
        changePosition(arrayInt, posFirst,posSecond);
        System.out.println();
        changePosition(arrayObjects, posFirst,posSecond);

        System.out.println();


        // решение по п.2 задания

        arrayAsArrayList(arrayStr);
        System.out.println();

        arrayAsArrayList(arrayInt);
        System.out.println();

        arrayAsArrayList(arrayObjects);
        System.out.println();

        // решеение по п.3 задания


        Box<Apple> box1a = new Box<>();
        Box<Apple> box2a = new Box<>();

        Box<Orange> box1o = new Box<>();
        Box<Orange> box2o = new Box<>();

        box1a.addFruit(new Apple(), 100);
        box2a.addFruit(new Apple(), 50);

        box1o.addFruit(new Orange(),20);
        box2o.addFruit(new Orange(),60);



        System.out.println("Вес первой коробки (с яблоками): " + box1a.getWeight());
        System.out.println("Вес второй коробки (с яблоками): " + box2a.getWeight());
        System.out.println();

        System.out.println("Вес третьей коробки (с апельсинами): " + box1o.getWeight());
        System.out.println("Вес четвёртой коробки (с апельсинами): " + box2o.getWeight());
        System.out.println();

        System.out.println("Сравнение первой коробки (c яблоками) и третьей коробки (с апельсинами): " + box1a.boxCompare(box1o));
        System.out.println("Сравнение второй коробки (c яблоками) и четвёртой коробки (с апельсинами): " + box2a.boxCompare(box1o));
        System.out.println();

        System.out.println("Пересыпем яблоки в одну коробку.");
        box1a.pouringToBox(box2a);
        System.out.println();

        System.out.println("Вес первой коробки c яблоками: " + box1a.getWeight());
        System.out.println("Вес второй коробки c яблоками: " + box2a.getWeight());
        System.out.println();

        System.out.println("Пересыпем апельсины в одну коробку.");
        box1o.pouringToBox(box2o);
        System.out.println();

        System.out.println("Вес третьей коробки (c апельсинами): " + box1o.getWeight());
        System.out.println("Вес четвёртой коробки (c апельсинами): " + box2o.getWeight());

    }


    private static void changePosition (Object[] array, int posFirst, int posSecond) {

        System.out.println("Массив на входе в метод: " + Arrays.toString(array));

        Object o = array[posFirst];
        array[posFirst] = array[posSecond];
        array[posSecond] = o;

        System.out.println("Массив на выходе из метода: " + Arrays.toString(array));

    }


    private static <T> void  arrayAsArrayList (T[] array) {

        System.out.println("Массив на входе в метод: " + Arrays.toString(array));

        ArrayList<T> list = new ArrayList<>(Arrays.asList(array));

        System.out.println("Список на выходе из метода: " + list);

    }

}
