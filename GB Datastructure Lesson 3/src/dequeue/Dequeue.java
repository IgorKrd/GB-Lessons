package dequeue;

import queue.Queue;

public interface Dequeue<E> extends Queue<E> {

    boolean insertLeft(E value);
    boolean insertRight(E value);

    E removeLeft();
    E removeRight();



}
