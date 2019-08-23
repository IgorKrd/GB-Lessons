package lesson4main;

import linkedlist.LinkedList;
import linkedlist.MySimpleLinkedListImpl;
import org.junit.Assert;
import org.junit.Test;


public class MySimpleLinkedListImplTest {

    @Test
    public void insertFirst() {
        LinkedList<Integer> testLinkedList = new MySimpleLinkedListImpl<>();

        testLinkedList.insertFirst(1);
        testLinkedList.insertFirst(2);
        testLinkedList.insertFirst(3);
        testLinkedList.insertFirst(4);

        Assert.assertFalse(testLinkedList.isEmpty());
        Assert.assertTrue(testLinkedList.getFirstValue() == 4);

        System.out.println("Список имеет вид представленный ниже с размером:  " + testLinkedList.size());
        testLinkedList.display();
        System.out.println("Последним был добавлен элемент со значением: " + testLinkedList.getFirstValue() + " и теперь он стоит на первом месте слева.");
    }

    @Test
    public void removeLeft() {

        LinkedList<Integer> testLinkedList = new MySimpleLinkedListImpl<>();

        testLinkedList.insertFirst(1);
        testLinkedList.insertFirst(2);
        testLinkedList.insertFirst(3);
        testLinkedList.insertFirst(4);

        System.out.println("Список имеет вид: ");
        testLinkedList.display();

        testLinkedList.removeFirst();

        Assert.assertFalse(testLinkedList.getFirstValue() == 4);
        System.out.println("Удалён из списка элемент со значением 4 и теперь на первой позиции слева: " + testLinkedList.getFirstValue());
        System.out.println("После удаления элемента список имеет вид представленный ниже с размером:  " + testLinkedList.size());
        testLinkedList.display();
    }

    @Test
    public void remove() {
        LinkedList<Integer> testLinkedList = new MySimpleLinkedListImpl<>();

        testLinkedList.insertFirst(1);
        testLinkedList.insertFirst(2);
        testLinkedList.insertFirst(3);
        testLinkedList.insertFirst(4);

        System.out.println("Список имеет вид представленный ниже с размером:  " + testLinkedList.size());
        testLinkedList.display();

        System.out.println("Удаляем из списка элемент со значением (3) ");
        testLinkedList.remove(3);

        Assert.assertTrue(!testLinkedList.contains(3));

        System.out.println("Теперь список имеет вид представленный ниже с размером:  " + testLinkedList.size());
        testLinkedList.display();
    }

    @Test
    public void contains() {
        LinkedList<Integer> testLinkedList = new MySimpleLinkedListImpl<>();

        testLinkedList.insertFirst(1);
        testLinkedList.insertFirst(2);
        testLinkedList.insertFirst(3);
        testLinkedList.insertFirst(4);

        System.out.println("Список имеет вид представленный ниже с размером:  " + testLinkedList.size());
        testLinkedList.display();

        System.out.println("Есть ли в списке элемент со значением 3? " + testLinkedList.contains(3));

        Assert.assertTrue(testLinkedList.contains(3));


        testLinkedList.remove(2);

        Assert.assertFalse(testLinkedList.contains(2));


    }
}