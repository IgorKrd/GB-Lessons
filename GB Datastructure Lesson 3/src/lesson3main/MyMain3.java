package lesson3main;

import dequeue.Dequeue;
import dequeue.MyDequeueImpl;
import queue.MyQueueImpl;
import queue.PriorityQueue;
import queue.Queue;
import stack.MyStackImpl;
import stack.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class MyMain3 {

    public static void main(String[] args) throws IOException {
        //testStack();
        //testQueue();
        //testPriorityQueue();
        testDequeue();
        testStringStack();
    }

    private static void testStringStack() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        char[] chArray = s.toCharArray();

        Stack<Character> charStack = new MyStackImpl<>(100);
        for (int i = 0; i < chArray.length; i++) {
            charStack.push(chArray[i]);
        }
        System.out.println();


        while (!charStack.isEmpty()) {
            System.out.print(charStack.pop() + " ");
        }
    }


    private static void testDequeue() {
        Dequeue<Integer> dequeue = new MyDequeueImpl<>(6);
        dequeue.insertRight(1);
        dequeue.insertRight(2);
        dequeue.insertRight(3);
        dequeue.insertRight(4);
        dequeue.insertRight(5);
        dequeue.insertRight(6);
        dequeue.insertRight(7);

//        dequeue.insertLeft(1);
//        dequeue.insertLeft(2);
//        dequeue.insertLeft(3);
//        dequeue.insertLeft(4);
//        dequeue.insertLeft(5);
//        dequeue.insertLeft(6);
//        dequeue.insertLeft(7);

        System.out.println("Top of DeQueue is: " + dequeue.peek());
        System.out.println("DeQueue size is: " + dequeue.size());

        while (!dequeue.isEmpty()) {

            System.out.println(dequeue.removeLeft());
            //System.out.println(dequeue.removeRight());
        }
    }

    private static void testPriorityQueue() {
        Queue<Integer> queue = new PriorityQueue<>(6);
        queue.insert(2);
        queue.insert(5);
        queue.insert(4);
        queue.insert(3);
        queue.insert(6);
        queue.insert(1);
        queue.insert(7);

        System.out.println("Top of PriorityQueue is: " + queue.peek());
        System.out.println("PriorityQueue size is: " + queue.size());

        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
        }
    }


    private static void testQueue() {
        Queue<Integer> queue = new MyQueueImpl<>(5);
        queue.insert(4);
        queue.insert(2);
        queue.insert(3);
        queue.insert(5);
        queue.insert(1);
        queue.insert(6);

        System.out.println("Top of queue is: " + queue.peek());
        System.out.println("Queue size is: " + queue.size());

        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
        }
    }

    private static void testStack() throws IOException {
        Stack<Integer> stack = new MyStackImpl<>(5);

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);


        System.out.println("Top of stack is: " + stack.peek());
        System.out.println("Stack size is: " + stack.size());

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
