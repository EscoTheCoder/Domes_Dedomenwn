package edu.aueb.ds.lab7;

/**
 * Interface for binary tree
 *
 * @param <T>
 */
public interface BinaryTreeInterface<T> {
    /**
     * @return the root of the tree
     */
    TreeNode<T> getRoot();

    /**
     * @param node The node to get left subtree
     * @return left child as binary tree
     */
    BinaryTreeInterface<T> getLeftSubTree(TreeNode<T> node);

    /**
     * @param node The node to get right subtree
     * @return right child as binary tree
     */
    BinaryTreeInterface<T> getRightSubTree(TreeNode<T> node);

    /**
     * @return The height of the tree
     */
    int getTreeHeight();

    /**
     * @param node The node to get level
     * @return The level of the node or null if node is not in tree
     */
    int getNodeLevel(TreeNode<T> node);

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

    /**
     * Prints the tree using Breadth first form
     * https://en.wikipedia.org/wiki/Tree_traversal#Breadth-first_search_/_level_order
     */
    void printBreadthFirst();
}
