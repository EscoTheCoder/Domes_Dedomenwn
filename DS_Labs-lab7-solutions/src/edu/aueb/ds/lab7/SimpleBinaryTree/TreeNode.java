package edu.aueb.ds.lab7.SimpleBinaryTree;

/**
 * Represents a Tree Node
 *
 */
public class TreeNode{
    // The data it holds
    private Object data;

    // Left subtree (child)
    private TreeNode left;

    // Right subtree (child)
    private TreeNode right;


    /**
     * Default TreeNode constructor
     */
    public TreeNode(){
    }

    /**
     * TreeNode constructor accepting data
     * @param data
     */
    public TreeNode(Object data){
        this.data = data;
    }

    /**
     * @return The data it holds
     */
    public Object getData() {
        return data;
    }

    /**
     * @param data the data to store
     */
    public void setData(Object data) {
        this.data = data;
    }

    /**
     * @return left subtree
     */
    public TreeNode getLeft() {
        return left;
    }

    /**
     * @param left Set left subtree
     */
    public void setLeft(TreeNode left) {
        this.left = left;
    }

    /**
     * @return right subtree
     */
    public TreeNode getRight() {
        return right;
    }

    /**
     * @param right Set right subtree
     */
    public void setRight(TreeNode right) {
        this.right = right;
    }
    
    public void visit() {
        System.out.print(this.data + " ");
    }      
}
