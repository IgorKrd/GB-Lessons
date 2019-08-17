package stack;

public class MyStackImpl<E> implements Stack<E> {

    private final E[] data;
    private int size;

    @SuppressWarnings("unchecked")
    public  MyStackImpl(int maxCapacity) {
        this.data = (E[]) new Object[maxCapacity];
    }

    @Override
    public boolean push(E value) {
        if (isFull())
            return false;
        data[size++] = value;
        //size++;
        return true;
    }

    @Override
    public E pop() {
        if (isEmpty()){
            return null;
        }
        return data[--size];
    }

    @Override
    public E peek() {
        if (isEmpty()){
            return null;
        }
        return data[size-1];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == data.length;
    }
}
