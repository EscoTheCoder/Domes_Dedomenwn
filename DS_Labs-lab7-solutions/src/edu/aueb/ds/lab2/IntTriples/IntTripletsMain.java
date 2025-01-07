package edu.aueb.ds.lab2.IntTriples;

import edu.aueb.ds.exceptions.OutOfRangeException;

public class IntTripletsMain {
    public static void main(String[] args) {
        TripleInterface values;

        values = new TripleVariables();
        useInterface(values);

        System.out.println();

        values = new TripleArray();
        useInterface(values);
    }

    private static void useInterface(TripleInterface triple) {
        System.out.println("useSimpleInterface with " + triple.getClass().getName());

        for (int i = 0; i < 4; ++i) {
            try {
                triple.set(i, (2 * i));
                System.out.println("Value at TripleInterface.get(" + i + "): " + triple.get(i));
            } catch (OutOfRangeException ex) {
                System.err.println(ex.toString());
            }
        }
    }
}
