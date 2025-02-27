package edu.aueb.ds.lab4.SimpleList;

import java.util.Comparator;

import edu.aueb.ds.exceptions.EmptyListException;

public interface ListInterface {
    /**
     * Inserts an data at the front of the list
     * @param data the inserted data
     */
    void insertAtFront(Video data);

    /**
     * Inserts an data at the end of the list
     *
     * @param data the inserted item
     */
    void insertAtBack(Video data);

    /**
     * Returns and removes the data from the list head
     *
     * @return the data contained in the list head
     * @throws EmptyListException if the list is empty
     */
    Video removeFromFront() throws EmptyListException;

    /**
     * Returns and removes the data from the list tail
     *
     * @return the data contained in the list tail
     * @throws EmptyListException if the list is empty
     */
    Video removeFromBack() throws EmptyListException;

    /**
     * Determine whether list is empty
     * @return true if list is empty
     */
    boolean isEmpty();

    /**
     * Sorts the list
     */
    void sort();
}
