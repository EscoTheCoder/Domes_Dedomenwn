package edu.aueb.ds.lab7.GenericBinaryTree;

/**
 * Represents a Tree Node
 *
 * @param <T> the type of data to hold
 */
public class TreeNode<T> {
    // The data it holds
    private T data;

    // Left subtree (child)
    private TreeNode<T> left;

    // Right subtree (child)
    private TreeNode<T> right;


    /**
     * Default TreeNode constructor
     */
    public TreeNode(){
    }

    /**
     * TreeNode constructor accepting data
     * @param data
     */
    public TreeNode(T data){
        this.data = data;
    }

    /**
     * @return The data it holds
     */
    public T getData() {
        return data;
    }

    /**
     * @param data the data to store
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * @return left subtree
     */
    public TreeNode<T> getLeft() {
        return left;
    }

    /**
     * @param left Set left subtree
     */
    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    /**
     * @return right subtree
     */
    public TreeNode<T> getRight() {
        return right;
    }

    /**
     * @param right Set right subtree
     */
    public void setRight(TreeNode<T> right) {
        this.right = right;
    }
    
    public void visit() {
        System.out.print(this.data + " ");
    }    
}
