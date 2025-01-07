package edu.aueb.ds.lab7.GenericBinaryTree;

import edu.aueb.ds.exceptions.EmptyQueueException;
import edu.aueb.ds.lab5.ArrayQueue;
import edu.aueb.ds.lab5.QueueInterface;

public class BinaryTree<T> implements BinaryTreeInterface<T> {
    // the root of the tree
    private TreeNode<T> root;

    public BinaryTree(TreeNode<T> root) {
        this.root = root;
    }

    /**
     * @return the root of the tree
     */
    @Override
    public TreeNode<T> getRoot() {
        return root;
    }

    /**
     * @param node The node to get left subtree
     * @return left child as binary tree
     */
    @Override
    public BinaryTreeInterface<T> getLeftSubTree(TreeNode<T> node) {
        if (root == null)
            return null;

        return new BinaryTree<>(node.getLeft());
    }

    /**
     * @param node The node to get right subtree
     * @return right child as binary tree
     */
    @Override
    public BinaryTreeInterface<T> getRightSubTree(TreeNode<T> node) {
        if (root == null)
            return null;

        return new BinaryTree<>(node.getRight());
    }

    /**
     * @return The height of the tree
     */
    @Override
    public int getTreeHeight() {
        if (root == null)
            return 0;

        return getNodeDepth(root);
    }

    /**
     * Recursive function to get nodes depth
     *
     * @param node The node to get depth
     * @return The depth of the node
     */
    private int getNodeDepth(TreeNode<T> node) {
        if (node == null)
            return 0;

        // get left and right depth
        int leftDepth = getNodeDepth(node.getLeft());
        int rightDepth = getNodeDepth(node.getRight());

        // return max depth + 1 for current node
        return Math.max(leftDepth, rightDepth) + 1;
    }

    /**
     * @param node The node to get level
     * @return The level of the node or null if node is not in tree
     */
    @Override
    public int getNodeLevel(TreeNode<T> node) {
        if (node == null)
            return 0;

        // tree height - node height = node level
        return getTreeHeight() - getNodeDepth(node);
    }

    /**
     * Prints the tree in pre-order form
     * https://en.wikipedia.org/wiki/Tree_traversal#Pre-order_(NLR)
     */
    @Override
    public void printPreOrder() {
        recursivePreOrder(root);
        System.out.println();
    }

    private void recursivePreOrder(TreeNode<T> node) {
        if (node == null)
            return;

        node.visit();
        recursivePreOrder(node.getLeft());
        recursivePreOrder(node.getRight());
    }

    /**
     * Prints the tree in in-order form
     * https://en.wikipedia.org/wiki/Tree_traversal#In-order_(LNR)
     */
    @Override
    public void printInOrder() {
        recursiveInOrder(root);
        System.out.println();
    }

    private void recursiveInOrder(TreeNode<T> node) {
        if (node == null)
            return;

        recursiveInOrder(node.getLeft());
        node.visit();
        recursiveInOrder(node.getRight());
    }

    /**
     * Prints the tree in post-order form
     * https://en.wikipedia.org/wiki/Tree_traversal#Post-order_(LRN)
     */
    @Override
    public void printPostOrder() {
        recursivePostOrder(root);
        System.out.println();
    }

    private void recursivePostOrder(TreeNode<T> node) {
        if (node == null)
            return;

        recursivePostOrder(node.getLeft());
        recursivePostOrder(node.getRight());
        node.visit();
    }

    /**
     * Prints the tree using Breadth first form
     * https://en.wikipedia.org/wiki/Tree_traversal#Breadth-first_search_/_level_order
     */
    @Override
    public void printBreadthFirst() {
        QueueInterface<TreeNode<T>> queue = new ArrayQueue<>();

        if (root == null)
            return;

        queue.enqueue(root);

        try {
            while (!queue.isEmpty()) {
                TreeNode<T> current = queue.dequeue();

                if (current.getLeft() != null)
                    queue.enqueue(current.getLeft());

                if (current.getRight() != null)
                    queue.enqueue(current.getRight());

                current.visit();
            }
        } catch (EmptyQueueException ex) {
            return;
        }
    }
}
