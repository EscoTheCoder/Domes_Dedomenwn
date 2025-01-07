package edu.aueb.ds.lab7.SimpleBinaryTree;

import edu.aueb.ds.exceptions.EmptyQueueException;
import edu.aueb.ds.lab5.ArrayQueue;
import edu.aueb.ds.lab5.QueueInterface;

public class BinaryTree implements BinaryTreeInterface {
    // the root of the tree
    private TreeNode root;

    public BinaryTree(TreeNode root) {
        this.root = root;
    }

    /**
     * @return the root of the tree
     */
    @Override
    public TreeNode getRoot() {
        return root;
    }

    /**
     * @param node The node to get left subtree
     * @return left child as binary tree
     */
    @Override
    public BinaryTreeInterface getLeftSubTree(TreeNode node) {
        if (root == null)
            return null;

        return new BinaryTree(node.getLeft());
    }

    /**
     * @param node The node to get right subtree
     * @return right child as binary tree
     */
    @Override
    public BinaryTreeInterface getRightSubTree(TreeNode node) {
        if (root == null)
            return null;

        return new BinaryTree(node.getRight());
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
    private int getNodeDepth(TreeNode node) {
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
    public int getNodeLevel(TreeNode node) {
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

    private void recursivePreOrder(TreeNode node) {
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

    private void recursiveInOrder(TreeNode node) {
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

    private void recursivePostOrder(TreeNode node) {
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
        QueueInterface queue = new ArrayQueue();

        if (root == null)
            return;

        queue.enqueue(root);

        try {
            while (!queue.isEmpty()) {
                TreeNode current = (TreeNode) queue.dequeue();

                if (current.getLeft() != null)
                    queue.enqueue(current.getLeft());

                if (current.getRight() != null)
                    queue.enqueue(current.getRight());

                System.out.print(current.getData() + " ");
            }
        } catch (EmptyQueueException ex) {
            return;
        }
    }
}
