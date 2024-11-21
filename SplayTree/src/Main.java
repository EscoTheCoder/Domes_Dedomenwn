class Main {
    public static void main(String[] args) {

//        SplayTree st = new SplayTree();

        Node root = null;
        root = SplayTree.insert(root, 15);
        root = SplayTree.insert(root, 10);
        root = SplayTree.insert(root, 17);
        root = SplayTree.insert(root, 7);
//        root = SplayTree.insert(root, 13);
        System.out.println("Preorder traversal of the modified Splay tree:");
        SplayTree.preOrder(root);
    }
}
