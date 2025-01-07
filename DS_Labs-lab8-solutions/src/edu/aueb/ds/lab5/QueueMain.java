package edu.aueb.ds.lab5;

import edu.aueb.ds.exceptions.EmptyQueueException;

public class QueueMain {
    public static void main(String[] args) {
        QueueInterface<Integer> queue = new ArrayQueue<>();
        int testElements = 5;

        System.out.println("Queue must be empty. queue.isEmpty() = " + queue.isEmpty());

        try {
            queue.dequeue();
            System.out.println("You managed to dequeue an empty queue... Nice!!!");
        } catch (EmptyQueueException ex) {
            System.out.println("Cannot dequeue from empty queue. Correct!!!");
        }

        try {
            for (int i = 0; i < testElements; ++i)
                queue.enqueue(i + 1);

            System.out.println("Queue must not be empty after " + testElements + " enqueues. queue.isEmpty() = " + queue.isEmpty());

            System.out.print("Queue contents (1.." + testElements + "): ");
            for (int i = 0; i < testElements + 1; ++i)
                System.out.print(queue.dequeue() + " ");

            System.out.println();
        } catch (EmptyQueueException ex) {
            System.out.println("Cannot dequeue any more...");
        } finally {
            System.out.println("Queue must now be empty. queue.isEmpty() = " + queue.isEmpty());
        }

        try {
            queue.enqueue(10);
            System.out.println("Added one item. queue.isEmpty() = " + queue.isEmpty());

            queue.dequeue();
            System.out.println("Queue must now be empty. queue.isEmpty() = " + queue.isEmpty());
        }catch(EmptyQueueException ex){
            System.out.println("Something went wrong and dequeued an empty queue.");
        }
    }
}
