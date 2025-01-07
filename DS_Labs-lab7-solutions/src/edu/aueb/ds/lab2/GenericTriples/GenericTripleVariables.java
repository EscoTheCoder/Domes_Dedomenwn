package edu.aueb.ds.lab2.GenericTriples;

import edu.aueb.ds.exceptions.OutOfRangeException;

public class GenericTripleVariables<T> implements GenericTripleInterface<T> {
    private T x1;
    private T x2;
    private T x3;

    /**
     * Returns the variable indexed through index.
     * index: the index of value to be returned.
     */
    @Override
    public T get(int index) throws OutOfRangeException {
        switch (index) {
            case 0:
                return x1;
            case 1:
                return x2;
            case 2:
                return x3;
            default:
                throw new OutOfRangeException(index, 0, 2);
        }
    }

    @Override
    public void set(int index, T value) throws OutOfRangeException {
        switch (index) {
            case 0:
                x1 = value;
                break;			//break suspends the switch's execution
            case 1:
                x2 = value;
                break;
            case 2:
                x3 = value;
                break;
            default:
                throw new OutOfRangeException(index, 0, 2);
        }
    }
}
