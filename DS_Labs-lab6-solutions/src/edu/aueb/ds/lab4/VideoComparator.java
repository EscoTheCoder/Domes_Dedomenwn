package edu.aueb.ds.lab4;

import java.util.Comparator;

/**
 * A class to compare Videos
 * It implements Comparator interface to provide "compare" function.
 */
public class VideoComparator implements Comparator<Video> {
    /**
     * Compares its two arguments for order.
     *
     * @param first
     * @param second
     * @return a negative integer, zero, or a positive integer as the first argument
     * is less than, equal to, or greater than the second.
     */
    @Override
    public int compare(Video first, Video second) {
        return first.getViews() - second.getViews();
    }
}
