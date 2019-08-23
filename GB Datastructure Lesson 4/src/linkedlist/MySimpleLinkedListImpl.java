package linkedlist;

import java.util.Iterator;


public class MySimpleLinkedListImpl<E> implements LinkedList<E> {

    protected Node<E> firstElement;
    protected int size;


    @Override
    public void insertFirst(E value) {
        Node<E> node = new Node<>(value);
        node.next = firstElement;
        firstElement = node;
        size++;
    }

    @Override
    public E removeFirst() {
        if (isEmpty())
            return null;
        E value = firstElement.value;
        firstElement = firstElement.next;
        size--;
        return value;
    }

    @Override
    public boolean remove(E value) {
        Node<E> previous = null;
        Node<E> current = firstElement;
        while (current != null) {
            if (current.value.equals(value)) {
                break;
            }

            previous = current;
            current = current.next;
        }
        if (current == null) {
            return false;
        } else if (current == firstElement) {
            firstElement = current.next;
        } else {
            previous.next = current.next;
        }
        size--;
        return true;
    }

    @Override
    public boolean contains(E value) {
        Node<E> current = firstElement;
        while (current != null) {
            if (current.value.equals(value)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }


    @Override
    public void display() {
        System.out.println("+++++++++++++++++++++++++++");

        Node<E> current = firstElement;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }

        System.out.println("+++++++++++++++++++++++++++");

    }

    @Override
    public E getFirstValue() {
        return firstElement != null ? firstElement.value : null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return firstElement == null;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public Node<E> getFirst() {
        return firstElement;
    }


    public Iterator<E> iterator() {
        return new Iterator<E>() {

            Node<E> current = firstElement;


            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                if (hasNext()) {
                    E value = current.value;
                    current = current.next;
                    return value;
                }
                return null;
            }
        };
    }
}


