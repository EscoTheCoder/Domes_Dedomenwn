package edu.aueb.ds.lab2.GenericTriples;

import edu.aueb.ds.exceptions.OutOfRangeException;

public class GenericTripleArray<T> implements GenericTripleInterface<T> {
    private T[] data;

    public GenericTripleArray() {
        data = (T[]) new Object[3];
    }

    @Override
    public T get(int index) throws OutOfRangeException {
        if (index < 0 || index > 2)
            throw new OutOfRangeException(index, 0, 2);

        return data[index];
    }

    @Override
    public void set(int index, T value) throws OutOfRangeException {
        if (index < 0 || index > 2)
            throw new OutOfRangeException(index, 0, 2);

        data[index] = value;
    }
}
