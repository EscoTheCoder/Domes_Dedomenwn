package edu.aueb.ds.lab5.SimpleQueue;

import edu.aueb.ds.exceptions.EmptyQueueException;
import edu.aueb.ds.lab5.SimpleQueue.QueueInterface;

public class ArrayQueue implements QueueInterface{

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


    @Override
    public void enqueue(Object item) {

        if(queueContents.length==n){
            growQueue();
        }
        queueContents[back] = item;
        back = (back+1)%n;
        size++;
    }

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

    @Override
    public boolean isEmpty() {
        return size==0;
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