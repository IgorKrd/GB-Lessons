package linkedlist;

import lesson4main.Stack;

public class MyLinkedStack<E> implements Stack<E> {

    private LinkedList<E> data;

    public MyLinkedStack() {

        this.data = new MySimpleLinkedListImpl<>();
    }


    @Override
    public boolean push(E value) {
        data.insertFirst(value);
        return true;
    }

    @Override
    public E pop() {
        return data.removeFirst();
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
