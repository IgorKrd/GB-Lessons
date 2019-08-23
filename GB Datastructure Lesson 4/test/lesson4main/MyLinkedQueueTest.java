package lesson4main;

import linkedlist.MyLinkedQueue;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyLinkedQueueTest {

    @Test
    public void insert() {

        Queue<Integer> queue = new MyLinkedQueue<>();

        queue.insert(3);
        queue.insert(5);
        queue.insert(1);
        queue.insert(4);
        queue.insert(2);

        Assert.assertFalse(queue.isEmpty());

        System.out.println("После добавления элементов очередь имеет вид: " );
        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
        }

    }

    @Test
    public void remove() {
        Queue<Integer> queue = new MyLinkedQueue<>();

        queue.insert(3);
        queue.insert(5);
        queue.insert(1);
        queue.insert(4);
        queue.insert(2);

        Assert.assertFalse(queue.isEmpty());

        System.out.println("После добавления элементов очередь имеет вид: " );
        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
        }

        Assert.assertTrue(queue.isEmpty());
        System.out.println("После удаления элементов из очереди она пустая? : " + queue.isEmpty());
    }

    @Test
    public void peek() {
        Queue<Integer> queue = new MyLinkedQueue<>();

        queue.insert(3);
        queue.insert(5);
        queue.insert(1);
        queue.insert(4);
        queue.insert(2);

        Assert.assertEquals(3, (int) queue.peek());
        System.out.println("В вершине очереди находится элемент (3) ? " + queue.peek());
    }

    @Test
    public void size() {

        Queue<Integer> queue = new MyLinkedQueue<>();
        queue.insert(3);
        queue.insert(5);
        queue.insert(1);
        queue.insert(4);
        queue.insert(2);

        Assert.assertEquals(4, (int) queue.size());
        System.out.println("Размер очереди составляет 4  (0; 1; 2; 3; 4)? " + queue.size());
    }
}