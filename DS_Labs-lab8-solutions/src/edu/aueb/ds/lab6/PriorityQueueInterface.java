package edu.aueb.ds.lab6;


/**
 * Priority Queue interface
 *
 * @param <T>
 */
public interface PriorityQueueInterface<T> {

    /**
     * Inserts the specified element into this priority queue.
     *
     * @param item
     */
    void add(T item);


    /**
     * Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
     *
     * @return the head of the queue
     */
    T peek();


    /**
     * Retrieves and removes the head of this queue, or returns null if this queue is empty.
     *
     * @return the head of the queue
     */
    T getMax();
}
