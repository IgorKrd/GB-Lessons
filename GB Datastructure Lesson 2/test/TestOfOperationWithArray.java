import org.junit.Test;

public class TestOfOperationWithArray {

    private Array<Integer> array = new MyArray<>(5);


    @Test
    public void addNewElementsAndResize() {

        //array.display();
        System.out.println("Первоначальный размер массива: " + array.size());
        System.out.println("Добавляем элементы в массив...");

        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);


        array.display();
        System.out.println(" Размер массива после добавления элементов: " + array.size());

        System.out.println("Добавляем дополнительные элементы сверх исходного размера: ");
        array.add(6);
        array.add(7);

        array.display();
        System.out.println("Размер массива после добавление элемента: " + array.size());
    }

    @Test
    public void findTheElements() {

        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);

        array.display();


        System.out.println("Find 4: " + array.indexOf(4));
        System.out.println("Find 24: " + array.indexOf(24));

    }

    @Test
    public void removeTheElements() {

        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);

        array.display();
        System.out.println("Удаляем элемент массива со значением '4' ");

        array.remove(4);
        System.out.println("Find 4: " + array.indexOf(4));

        array.display();
    }

}
