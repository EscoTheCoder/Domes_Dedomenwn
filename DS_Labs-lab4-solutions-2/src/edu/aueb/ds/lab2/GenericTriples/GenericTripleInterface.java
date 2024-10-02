package edu.aueb.ds.lab2.GenericTriples;

import edu.aueb.ds.exceptions.OutOfRangeException;

/**
 * A Generic interface that contains the definitions for a three-value class
 * Values are accessed via get() and set() methods using 0-based indexes.
 */
public interface GenericTripleInterface<T> {
    /**
     * @param index The index of value to return
     * @return The value at the specific index
     * @throws OutOfRangeException If index is not between 0 and 2
     */
    T get(int index) throws OutOfRangeException;

    /**
     * @param index The index of value to change
     * @param value The new value
     * @throws OutOfRangeException If index is not between 0 and 2
     */
    void set(int index, T value) throws OutOfRangeException;
}

