package edu.aueb.ds.lab5.SimpleQueue;

import edu.aueb.ds.exceptions.EmptyQueueException;


/**
 * Implementation of Queue using Array structure
 *
 */
public class ArrayQueue implements QueueInterface {
    /**
     * In order to implement a Queue using Arrays we will use Array Rotation and dynamic array grow
     *
     * Rotating an Array simply means shifting elements of array to left or
     * to right by n position without exhausting the “bound of array”.
     *
     * To use array rotation we implement positionAfter(int current) function to get the
     * next position after current. (e.x. if current is the last place of the array then
     * next is the first place of the array - rotating around array)
     *
     * When the array is full and we need to enqueue more items then we must grow the array.
     * To do so we will use growQueue() function to increase the capacity of existing array
     * by AUTOGROW_SIZE.
     *
     * When array grows we need to pay attention to where we replace items, so we won't lose
     * the order, and replace "front" and "back" pointers, as necessary.
     */

    private Object[] queueContents; // the array to hold the queue data

    private int size; // number of enqueued items

    private int n; // number of the queue capacity

    private int front; // array position of the front of the queue
    private int back; // array position of the back of the queue

    private static final int DEFAULT_CAPACITY = 2; // the default queue capacity
    private static final int AUTOGROW_SIZE = 2; // the autogrow size after reaching full capacity

    /**
     * Initialize the queue
     */
    public ArrayQueue(int n) {
        this.n=n;
        queueContents = new Object[n];
        front=0;
        back=0;
        size=0;
    }

    /**
     * Insert a new item into the queue.
     *
     * @param item the item to insert.
     */
    @Override
    public void enqueue(Object item) {
        if(size==queueContents.length){
            growQueue();
        }
        queueContents[back]=item;
        back = (back+1)%n; //circular increment otan (back+1)=n paei sthn thesh 0
        size++;
    }

    /**
     * Return and remove the least recently inserted item
     * from the queue.
     *
     * @return the least recently inserted item in the queue.
     * @throws EmptyQueueException if the queue is empty.
     */
    @Override
    public Object dequeue() throws EmptyQueueException {
        if(isEmpty()){
            throw new EmptyQueueException();
        }
        Object data = queueContents[front];
        front = (front + 1) % n;
        size--;
        return data;
    }

    /**
     * Test if the queue is logically empty.
     *
     * @return true if empty, false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return size==0;
    }

    /**
     * Returns the next position in queue, after "current"
     *
     * @param current The current position
     * @return the position in queue after current
     */
    private int positionAfter(int current) {
        if(current + 1 == queueContents.length) {
            return 0;
        }
        return current + 1;
    }

    /**
     * Increases the maximum capacity of the queue base on AUTOGROW_SIZE
     */
    private void growQueue() {
        Object[] temp = new Object[queueContents.length+AUTOGROW_SIZE];
        for(int i=0; i<queueContents.length; i++){
            temp[i]=queueContents[i];
        }
        queueContents= temp;
    }
}
