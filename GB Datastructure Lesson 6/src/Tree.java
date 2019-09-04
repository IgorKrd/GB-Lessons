public interface Tree <E extends Comparable<? super E>> extends ICollection{

    enum TraverseMode {

        IN_ORDER,
        PRE_ORDER,
        POST_ORDER
    }

    boolean find(E value);

    boolean add(E value);

    boolean remove(E value);

    void display();

    boolean isBalanced(Node<E> node);

    int checkTheBalance();

    void traverse (TraverseMode mode);

    }

