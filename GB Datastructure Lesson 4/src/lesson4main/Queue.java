package lesson4main;

    public interface Queue<E> extends ICollection {

        boolean insert(E value);

        E remove();

        E peek();

    }
