package edu.aueb.ds.lab2.GenericTriples;

import edu.aueb.ds.exceptions.OutOfRangeException;

public class GenericTripletsMain {
    public static void main(String[] args) {
        GenericTripleInterface<Float> values;

        values = new GenericTripleVariables<Float>();
        useInterface(values);

        System.out.println();

        values = new GenericTripleArray<>();
        useInterface(values);
    }

    private static void useInterface(GenericTripleInterface<Float> triple) {
        System.out.println("useGenericInterface with " + triple.getClass().getName());

        for (int i = 0; i < 4; ++i) {
            try {
                triple.set(i, (0.2f * i));
                System.out.println("Value at GenericTripleInterface.get(" + i + "): " + triple.get(i));
            } catch (OutOfRangeException ex) {
                System.err.println(ex.toString());
            }
        }
    }
}
