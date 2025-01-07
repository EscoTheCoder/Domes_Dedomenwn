package edu.aueb.ds.lab7;

public class BinaryTreeMain {
    public static void main(String[] args) {
        // Create following tree
        //           10
        //          /  \
        //       05    32
        //      /  \     \
        //     88   1     -5
        //    / \
        //   8  99
        //        \
        //         7

        TreeNode<Integer> root = new TreeNode<>(10);
        BinaryTreeInterface<Integer> tree = new BinaryTree<>(root);

        TreeNode<Integer> left = new TreeNode<>(5);
        TreeNode<Integer> left1 = new TreeNode<>(88);
        TreeNode<Integer> left2 = new TreeNode<>(1);

        TreeNode<Integer> left11 = new TreeNode<>(8);
        TreeNode<Integer> left12 = new TreeNode<>(99);

        TreeNode<Integer> left122 = new TreeNode<>(7);

        TreeNode<Integer> right = new TreeNode<>(32);
        TreeNode<Integer> right2 = new TreeNode<>(-5);

        root.setLeft(left);
        root.setRight(right);

        left.setLeft(left1);
        left.setRight(left2);

        right.setRight(right2);

        left1.setLeft(left11);
        left1.setRight(left12);

        left12.setRight(left122);

        System.out.println("Main tree height (5): " + tree.getTreeHeight());

        BinaryTreeInterface<Integer> sub = tree.getRightSubTree(left1);
        System.out.println("left12 height (2): " + sub.getTreeHeight());

        sub = tree.getLeftSubTree(right);
        System.out.println("null height (0): " + sub.getTreeHeight());

        System.out.println("Root level (0): " + tree.getNodeLevel(root));
        System.out.println("left12 level (3): " + tree.getNodeLevel(left12));
        System.out.println("left122 level (4): " + tree.getNodeLevel(left122));

        System.out.println("\nPre-order form (10 5 88 8 99 7 1 32 -5):");
        tree.printPreOrder();

        System.out.println("\nIn-order form (8 88 99 7 5 1 10 32 -5):");
        tree.printInOrder();

        System.out.println("\nPost-order form (8 7 99 88 1 5 -5 32 10):");
        tree.printPostOrder();

        System.out.println("\nBreadth first form (10 5 32 88 1 -5 8 99 7):");
        tree.printBreadthFirst();
    }
}
