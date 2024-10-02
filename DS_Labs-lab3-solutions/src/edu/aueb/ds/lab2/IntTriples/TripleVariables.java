package edu.aueb.ds.lab2.IntTriples;

import edu.aueb.ds.exceptions.OutOfRangeException;

public class TripleVariables implements TripleInterface {
    private int x1;
    private int x2;
    private int x3;

    @Override
    public int get(int index) throws OutOfRangeException {
        if (index == 0) {
            return x1;
        } else if (index == 1) {
            return x2;
        } else if (index == 2) {
            return x3;
        }
        throw new OutOfRangeException(index, 0, 2);
    }

    @Override
    public void set(int index, int value) throws OutOfRangeException {
        if (index == 0) {
            x1 = value;
        } else if (index == 1) {
            x2 = value;
        } else if (index == 2) {
            x3 = value;
        } else {
            throw new OutOfRangeException(index, 0, 2);
        }
    }
}
