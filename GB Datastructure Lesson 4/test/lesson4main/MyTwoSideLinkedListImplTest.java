package lesson4main;

import linkedlist.MyTwoSideLinkedList;
import linkedlist.MyTwoSideLinkedListImpl;
import org.junit.Assert;
import org.junit.Test;


public class MyTwoSideLinkedListImplTest {

    @Test
    public void insertLast() {

        MyTwoSideLinkedList<Integer> linkedList = new MyTwoSideLinkedListImpl<>();

        linkedList.insertFirst(1);
        linkedList.insertLast(2);
        linkedList.insertFirst(3);
        linkedList.insertLast(4);

        Assert.assertTrue(linkedList.contains(1));
        Assert.assertTrue(linkedList.contains(2));
        Assert.assertTrue(linkedList.contains(3));
        Assert.assertTrue(linkedList.contains(4));

        System.out.println("Список имеет вид представленный ниже с размером:  " + linkedList.size());
        linkedList.display();

    }

    @Test
    public void insertFirst() {
        MyTwoSideLinkedList<Integer> linkedList = new MyTwoSideLinkedListImpl<>();

        linkedList.insertFirst(1);
        linkedList.insertLast(2);
        linkedList.insertFirst(3);
        linkedList.insertLast(4);

        Assert.assertTrue(linkedList.contains(1));
        Assert.assertTrue(linkedList.contains(2));
        Assert.assertTrue(linkedList.contains(3));
        Assert.assertTrue(linkedList.contains(4));

        System.out.println("Список имеет вид представленный ниже с размером:  " + linkedList.size());
        linkedList.display();
    }

    @Test
    public void remove() {
        MyTwoSideLinkedList<Integer> linkedList = new MyTwoSideLinkedListImpl<>();

        linkedList.insertFirst(1);
        linkedList.insertLast(2);
        linkedList.insertFirst(3);
        linkedList.insertLast(4);

        System.out.println("Первоначально список имеет вид представленный ниже с размером:  " + linkedList.size());
        linkedList.display();

        linkedList.remove(3);
        linkedList.remove(2);

        Assert.assertFalse(linkedList.contains(3));
        Assert.assertFalse(linkedList.contains(2));

        System.out.println("После удаления элементов со значением (3) и (2) список имеет вид представленный ниже с размером:  " + linkedList.size());
        linkedList.display();

    }

}
