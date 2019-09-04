public class Node<T extends Comparable<? super T>> {

    private final T value;

    private Node<T> leftChild;
    private Node<T> rightChild;



    public Node(T value){
        this.value = value;
    }

    public void setLeftChild(Node<T> leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(Node<T> rightChild) {
        this.rightChild = rightChild;
    }

    public T getValue() {
        return value;
    }

    public Node<T> getLeftChild() {
        return leftChild;
    }

    public Node<T> getRightChild() {
        return rightChild;
    }

    public boolean shouldBeLeft(T value) {
        return this.value.compareTo(value) > 0;
    }

    public boolean isLeaf() {

        return leftChild == null && rightChild == null;
    }

    public boolean hasOnlySingleChild() {

        // false false -> false
        // true false -> true
        // false true -> true
        // true true -> false

        return  leftChild != null ^ rightChild != null;
    }
}
