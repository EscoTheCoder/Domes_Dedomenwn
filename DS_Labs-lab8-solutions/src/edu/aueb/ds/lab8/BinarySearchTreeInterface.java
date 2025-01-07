package edu.aueb.ds.lab8;

import edu.aueb.ds.lab7.TreeNode;

/**
 * Binary Search Tree Interface that supports the basic BST operations
 * https://en.wikipedia.org/wiki/Binary_search_tree
 *
 * @param <T> The type of data to hold
 */
public interface BinarySearchTreeInterface<T> {
    /**
     * Inserts a new item to the tree
     *
     * @param item the item to insert
     */
    void insert(T item);

    /**
     * Checks if the item exists in the tree
     *
     * @param item the item to look for
     * @return true if found, false otherwise
     */
    boolean find(T item);

    /**
     * Deletes the item from the tree
     *
     * @param item to delete
     */
    void delete(T item);

    /**
     * Prints the tree in pre-order form
     * https://en.wikipedia.org/wiki/Tree_traversal#Pre-order_(NLR)
     */
    void printPreOrder();

    /**
     * Prints the tree in in-order form
     * https://en.wikipedia.org/wiki/Tree_traversal#In-order_(LNR)
     */
    void printInOrder();

    /**
     * Prints the tree in post-order form
     * https://en.wikipedia.org/wiki/Tree_traversal#Post-order_(LRN)
     */
    void printPostOrder();
}
