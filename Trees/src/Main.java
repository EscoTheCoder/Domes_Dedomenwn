public class Main {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println("Inorder traversal of the given tree");
        tree.display();

//        System.out.println("\n\nDelete 20");
//        tree.remove(20);
//        System.out.println("Inorder traversal of the modified tree");
//        tree.display();
//
//        System.out.println("\n\nDelete 30");
//        tree.remove(30);
//        System.out.println("Inorder traversal of the modified tree");
//        tree.display();
//
//        System.out.println("\n\nDelete 50");
//        tree.remove(50);
//        System.out.println("Inorder traversal of the modified tree");
//        tree.display();

        System.out.println();
        tree.counter();
        System.out.println(tree.counter);
    }
}