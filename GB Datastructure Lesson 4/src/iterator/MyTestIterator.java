package iterator;

import linkedlist.LinkedList;
import linkedlist.MySimpleLinkedListImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyTestIterator {

    public static void main(String[] args) {

        int [] array = {1, 2, 3};

//        for (int i = 0; i < array.length; i++) {
//            int value = array[i];
//            doAction(value);
//        }

        int index = 0;
        while(index < array.length) {
            int value = array[index++];
            doAction(value);
        }
        System.out.println("+++++++++++++++++++++++++++++++");
        System.out.println("+++++++++++++++++++++++++++++++");

        LinkedList<Integer> linkedList = createLinkedList();

        for (Integer o : linkedList) {
            doAction(o);
        }
        System.out.println("+++++++++++++++++++++++++++++++");
        System.out.println("+++++++++++++++++++++++++++++++");

        LinkedList.Node<Integer> current = linkedList.getFirst();
        while (current != null) {
            Integer value = current.value;
            doAction(value);
            current = current.next;
            }
        System.out.println("++++++++++++++++++++++++++++++++");

        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(4);
        arrayList.add(5);
        arrayList.add(6);

        Iterator<Integer> iterator = arrayList.iterator();
        while(iterator.hasNext()) {
            Integer value = iterator.next();
            doAction(value);
        }
        System.out.println("++++++++++++++++++++++++++++++++");

        List<Integer> jdkLinkedList = new java.util.LinkedList<>();
        jdkLinkedList.add(4);
        jdkLinkedList.add(5);
        jdkLinkedList.add(6);

        jdkLinkedList.removeIf(value -> value % 2 == 0);

        iterator = jdkLinkedList.iterator();
        while (iterator.hasNext()) {
            Integer value = iterator.next();
            if (value % 2 == 0) {
                iterator.remove();
            }
        //    doAction(value);
        }

        for (Integer value : arrayList) {
            doAction(value);
        }
    }

    private static  LinkedList<Integer> createLinkedList(){

        LinkedList<Integer> linkedList = new MySimpleLinkedListImpl<>();
        linkedList.insertFirst(4);
        linkedList.insertFirst(5);
        linkedList.insertFirst(6);
        return linkedList;
    }


    private static void  doAction(int value) {
        System.out.println(value);
    }
}
