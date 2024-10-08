package edu.aueb.ds.lab5.SimpleQueue;

import edu.aueb.ds.exceptions.EmptyQueueException;


/**
 * interface Queue declares the basic methods a queue must support, i.e.
 */
public interface QueueInterface{

    /**
     * Insert a new item into the queue.
     * @param item the item to insert.
     */
    void enqueue(Object item);


    /**
     * Return and remove the least recently inserted item
     * from the queue.
     * @return the least recently inserted item in the queue.
     * @throws EmptyQueueException if the queue is empty.
     */
    Object dequeue() throws EmptyQueueException;

    /**
     * Test if the queue is logically empty.
     * @return true if empty, false otherwise.
     */
    boolean isEmpty();
}
