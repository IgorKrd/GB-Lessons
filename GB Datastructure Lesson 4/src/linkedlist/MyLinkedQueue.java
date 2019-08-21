package linkedlist;


import lesson4main.Queue;

public class MyLinkedQueue<E> implements Queue<E> {

    private  MyTwoSideLinkedList<E> data;

    public MyLinkedQueue() {
        this.data = new MyTwoSideLinkedListImpl<>();
    }


    @Override
    public boolean insert(E value) {
       data.insertLast(value);
       return true;
    }

    @Override
    public E remove() {
       return  data.removeFirst();
    }

    @Override
    public E peek() {
        return data.getFirstValue();
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public boolean isFull() {
        return data.isFull();
    }
}
