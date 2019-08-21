package lesson4main;

import junit.framework.TestCase;
import lesson4main.Stack;
import linkedlist.MyLinkedStack;
import org.junit.Assert;
import org.junit.Test;


public class MyLinkedStackTest {

    @Test
    public void push() {

        Stack<Integer> stack = new MyLinkedStack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        Assert.assertFalse(stack.isEmpty());

        System.out.println("После выполнения добавления элементов в стэк, пустой ли он? " + stack.isEmpty());

    }

    @Test
    public void peek() {
        Stack<Integer> stack = new MyLinkedStack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        Assert.assertEquals(4, (int) stack.peek());
        System.out.println("На верхине стэка находится значение (4)?  " + stack.peek());


    }

    @Test
    public void pop() {

        Stack<Integer> stack = new MyLinkedStack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        while (!stack.isEmpty()) {
            stack.pop();
        }

        Assert.assertTrue(stack.isEmpty());
        System.out.println("После удаления элементов стэка, пустой ли он? " + stack.isEmpty());


    }
}