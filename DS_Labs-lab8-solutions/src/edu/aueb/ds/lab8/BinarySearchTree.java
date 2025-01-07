package edu.aueb.ds.lab8;

import edu.aueb.ds.lab7.TreeNode;

import java.util.Comparator;

/**
 * Binary Search Tree implementation
 *
 * @param <T>
 */
public class BinarySearchTree<T> implements BinarySearchTreeInterface<T> {
    // the root of the tree
    private TreeNode<T> root;

    // The comparator for the items
    private Comparator<T> comparator;

    /**
     * Binary Search Tree constructor
     *
     * @param comparator the Comparator<T> to use for comparing items
     */
    public BinarySearchTree(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    /**
     * Inserts a new item to the tree
     *
     * @param item the item to insert
     */
    @Override
    public void insert(T item) {
        if (root == null)
            root = new TreeNode<T>(item);

        TreeNode<T> current = root;

        while (true) {
            if (current.getData() == item)
                return;

            if (comparator.compare(current.getData(), item) < 0) {
                if (current.getRight() == null) {
                    current.setRight(new TreeNode<T>(item));
                    return;
                } else {
                    current = current.getRight();
                }
            } else {
                if (current.getLeft() == null) {
                    current.setLeft(new TreeNode<T>(item));
                    return;
                } else {
                    current = current.getLeft();
                }
            }
        }
    }

    /**
     * Checks if the item exists in the tree
     *
     * @param item the item to look for
     * @return true if found, false otherwise
     */
    @Override
    public boolean find(T item) {
        TreeNode<T> current = root;
        while (true) {
            if (current == null)
                return false;

            if (current.getData().equals(item))
                return true;

            if (comparator.compare(current.getData(), item) < 0)
                current = current.getRight();
            else
                current = current.getLeft();
        }
    }

    /**
     * Deletes the item from the tree
     *
     * @param item to delete
     */
    @Override
    public void delete(T item) {
        // find node to delete and its parent
        TreeNode<T> current = root;
        TreeNode<T> parent = null;

        while (true) {
            if (current == null)
                return;

            if (current.getData().equals(item))
                break;

            parent = current;

            if (comparator.compare(current.getData(), item) < 0)
                current = current.getRight();
            else
                current = current.getLeft();
        }

        // node to replace with
        TreeNode<T> replace = null;

        // only right
        if (current.getLeft() == null)
            replace = current.getRight();
        else if (current.getRight() == null)
            replace = current.getLeft();
        else {
            // find left most child of current right subtree!
            TreeNode<T> findCurrent = current.getRight();

            while (true) {
                if (findCurrent.getLeft() != null)
                    findCurrent = findCurrent.getLeft();
                else
                    break;
            }

            // only has zero or one child (there is no left child!!!)
            delete(findCurrent.getData());

            findCurrent.setLeft(current.getLeft());
            findCurrent.setRight(current.getRight());

            replace = findCurrent;
        }
        // replace parents reference

        if (parent == null) { //root
            root = replace;
        } else {
            if (parent.getLeft() == current)
                parent.setLeft(replace);

            if (parent.getRight() == current)
                parent.setRight(replace);
        }
    }

    /**
     * Prints the tree in pre-order form
     * https://en.wikipedia.org/wiki/Tree_traversal#Pre-order_(NLR)
     */
    @Override
    public void printPreOrder() {
        preOrder(root);
    }

    private void preOrder(TreeNode<T> n) {
        if (n == null)
            return;

        System.out.print(n.getData() + " ");
        preOrder(n.getLeft());
        preOrder(n.getRight());
    }

    /**
     * Prints the tree in in-order form
     * https://en.wikipedia.org/wiki/Tree_traversal#In-order_(LNR)
     */
    @Override
    public void printInOrder() {
        inOrder(root);
    }

    private void inOrder(TreeNode<T> n) {
        if (n == null) return;

        inOrder(n.getLeft());
        System.out.print(n.getData() + " ");
        inOrder(n.getRight());
    }

    /**
     * Prints the tree in post-order form
     * https://en.wikipedia.org/wiki/Tree_traversal#Post-order_(LRN)
     */
    @Override
    public void printPostOrder() {
        postOrder(root);
    }

    private void postOrder(TreeNode<T> n) {
        if (n == null)
            return;

        postOrder(n.getLeft());
        postOrder(n.getRight());
        System.out.print(n.getData() + " ");
    }
}
