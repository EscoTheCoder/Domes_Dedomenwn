package edu.aueb.ds.lab2.IntTriples;

import edu.aueb.ds.exceptions.OutOfRangeException;

public class TripleArray implements TripleInterface {
    private int data[];

    public TripleArray() {
        data = new int[3];
    }

    @Override
    public int get(int index) throws OutOfRangeException {
        if (index < 0 || index > 2)
            throw new OutOfRangeException(index, 0, 2);

        return data[index];
    }

    @Override
    public void set(int index, int value) throws OutOfRangeException {
        if (index < 0 || index > 2)
            throw new OutOfRangeException(index, 0, 2);

        data[index] = value;
    }
}
