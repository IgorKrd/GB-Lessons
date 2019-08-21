package dequeue;

import queue.MyQueueImpl;

public class MyDequeueImpl<E> extends MyQueueImpl<E> implements Dequeue<E> {

    @SuppressWarnings("unchecked")
    public MyDequeueImpl(int maxCapacity) {
        super(maxCapacity);
    }

    @Override
    public boolean insertLeft(E value) {
        if (isFull()) {
            return false;
        }
        if (head == 0)
            head = data.length;
            data[--head] = value;
        System.out.println(value);
            size++;
            return true;
        }


    @Override
    public boolean insertRight(E value) {
        return super.insert(value);
    }

    @Override
    public E removeLeft() {
        return super.remove();
    }

    @Override
    public E removeRight() {
        if (isEmpty())
            return null;

            if (tail < 0)
                tail = data.length - 1;
            size--;
            return data[tail--];

    }
}


