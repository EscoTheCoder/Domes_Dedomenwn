package edu.aueb.ds.lab8;

import edu.aueb.ds.lab6.IntegerComparator;

public class BinarySearchTreeMain {
    public static void main(String[] args) {
        //             36
        //           /    \
        //         13      61
        //           \    /  \
        //           34  59  74
        //           /       /
        //          22      62
        //         /  \
        //        19  23
        BinarySearchTreeInterface<Integer> bst = new BinarySearchTree<>(new IntegerComparator());

        System.out.println("Trying to find '10' in empty BST (false): " + bst.find(10));

        // try to delete from empty tree
        bst.delete(10);

        bst.insert(36);
        bst.insert(13);
        bst.insert(34);
        bst.insert(61);
        bst.insert(22);
        bst.insert(59);
        bst.insert(74);
        bst.insert(19);
        bst.insert(23);
        bst.insert(62);

        // try to delete non existence tree
        bst.delete(10);

        System.out.println("Trying to find '10' in BST (false): " + bst.find(10));
        System.out.println("Trying to find '74' in BST (true): " + bst.find(74));

        System.out.println("\nPrint Pre-Order (36 13 34 22 19 23 61 59 74 62):");
        bst.printPreOrder();

        System.out.println("\n\nPrint In-Order(13 19 22 23 34 36 59 61 62 74):");
        bst.printInOrder();

        System.out.println("\n\nPrint Post-Order(19 23 22 34 13 59 62 74 61 36):");
        bst.printPostOrder();

        bst.delete(36);

        System.out.println("\n\nPrint In-Order(13 19 22 23 34 59 61 62 74):");
        bst.printInOrder();

        bst.delete(13);
        bst.delete(34);
        bst.delete(61);
        bst.delete(22);
        bst.delete(59);
        bst.delete(74);
        bst.delete(19);
        bst.delete(23);
        bst.delete(62);

        System.out.println("\n\nPrint In-Order ( ):");
        bst.printInOrder();

        bst.insert(59);
        bst.insert(59);
        bst.insert(32);
        bst.insert(64);

        System.out.println("\n\nPrint In-Order (32 59 64):");
        bst.printInOrder();
    }
}
