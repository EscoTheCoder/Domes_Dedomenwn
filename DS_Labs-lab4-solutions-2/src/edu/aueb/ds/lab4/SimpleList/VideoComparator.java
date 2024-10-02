package edu.aueb.ds.lab4.SimpleList;

import java.util.Comparator;

/**
 * A class to compare Videos
 * It implements Comparator interface to provide "compare" function.
 */
public class VideoComparator implements Comparator {
    /**
     * Compares its two arguments for order.
     *
     * @param first
     * @param second
     * @return a negative integer, zero, or a positive integer as the first argument
     * is less than, equal to, or greater than the second.
     */
	@Override
	public int compare(Object first, Object second) {
		return ((Video)first).getViews() - ((Video)second).getViews();
	}
}
