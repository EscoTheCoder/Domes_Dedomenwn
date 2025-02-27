package edu.aueb.ds.lab6;

import java.util.Comparator;

/**
 * Priority Queue implementation based in Heap
 */
public class HeapPriorityQueue<T> implements PriorityQueueInterface<T> {
    /**
     * Heap based implementation of PriorityQueue
     * To implement it you need to implement the following helper functions as well
     * swim, sing, swap, grow
     */

    private T[] heap; // the heap to store data in
    private int size; // current size of the queue
    private Comparator<T> comparator; // the comparator to use between the objects

    private static final int DEFAULT_CAPACITY = 4; // default capacity
    private static final int AUTOGROW_SIZE = 4; // default auto grow

    /**
     * Queue constructor
     *
     * @param comparator
     */
    public HeapPriorityQueue(Comparator<T> comparator) {
        this.heap = (T[]) new Object[DEFAULT_CAPACITY + 1];
        this.size = 0;
        this.comparator = comparator;
    }

    /**
     * Inserts the specified element into this priority queue.
     *
     * @param item
     */
    @Override
    public void add(T item) {
        // Check available space
        if (size == heap.length - 1)
            grow();

        // Place item at the next available position
        heap[++size] = item;

        // Let the newly added item swim
        swim(size);
    }

    /**
     * Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
     *
     * @return the head of the queue
     */
    @Override
    public T peek() {
        // Ensure not empty
        if (size == 0)
            return null;

        // return root without removing
        return heap[1];
    }

    /**
     * Retrieves and removes the head of this queue, or returns null if this queue is empty.
     *
     * @return the head of the queue
     */
    @Override
    public T getMax() {
        // Ensure not empty
        if (size == 0)
            return null;

        // Keep a reference to the root item
        T root = heap[1];

        // Replace root item with the one at rightmost leaf
        heap[1] = heap[size];
        size--;

        // Dispose the rightmost leaf
        // Sink the new root element
        sink(1);

        // Return the int removed
        return root;
    }

    /**
     * Helper function to swim items to the top
     *
     * @param i the index of the item to swim
     */
    private void swim(int i) {
        // if i is root (i==1) return
        if (i == 1)
            return;

        // find parent
        int parent = i / 2;

        // compare parent with child i
        while (i != 1 && comparator.compare(heap[i], heap[parent]) > 0) {
            swap(i, parent);
            i = parent;
            parent = i / 2;
        }

        // recursive function
        // if (heap[i] > heap[parent]) {
        //     swap(i, parent);
        //     swim(parent);
        // }
    }

    /**
     * Helper function to swim items to the bottom
     *
     * @param i the index of the item to sink
     */
    private void sink(int i) {
        // determine left, right child
        int left = 2 * i;
        int right = left + 1;

        // if 2*i > size, node i is a leaf return
        if (left > size)
            return;

        // while haven't reached the leafs
        while (left <= size) {
            // Determine the largest child of node i
            int max = left;
            if (right <= size) {
                if (comparator.compare(heap[left], heap[right]) < 0)
                    max = right;
            }

            // If the heap condition holds, stop. Else swap and go on.
            // child smaller than parent
            if (comparator.compare(heap[i], heap[max]) >= 0)
                return;
            else {
                swap(i, max);
                i = max;
                left = i * 2;
                right = left + 1;
            }
        }
    }

    /**
     * Helper function to swap two elements in the heap
     *
     * @param i the first element's index
     * @param j the second element's index
     */
    private void swap(int i, int j) {
        T tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }

    /**
     * Helper function to grow the size of the heap
     */
    private void grow() {
        T[] newHeap = (T[]) new Object[heap.length + AUTOGROW_SIZE];

        // copy array
        System.arraycopy(heap, 1, newHeap, 1, size);

        heap = newHeap;
    }
}
