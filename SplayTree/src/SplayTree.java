class Node {
    public int data;
    public Node left, right;
}

class SplayTree {

    static Node newNode(int data) {
        Node node = new Node();
        node.data = data;
        node.left = node.right = null;
        return node;
    }

    static Node rightRotate(Node x) {
        Node y = x.left;
        x.left = y.right;
        y.right = x;
        return y;
    }

    static Node leftRotate(Node x) {
        Node y = x.right;
        x.right = y.left;
        y.left = x;
        return y;
    }

    static Node splay(Node root, int data) {
        if (root == null || root.data == data)
            return root;

        if (root.data > data) {
            if (root.left == null)
                return root;
            if (root.left.data > data) {
                root.left.left = splay(root.left.left, data);
                root = rightRotate(root);
            } else if (root.left.data < data) {
                root.left.right = splay(root.left.right, data);
                if (root.left.right != null)
                    root.left = leftRotate(root.left);
            }
            return (root.left == null) ? root : rightRotate(root);
        } else {
            if (root.right == null)
                return root;
            if (root.right.data > data) {
                root.right.left = splay(root.right.left, data);
                if (root.right.left != null)
                    root.right = rightRotate(root.right);
            } else if (root.right.data < data) {
                root.right.right = splay(root.right.right, data);
                root = leftRotate(root);
            }
            return (root.right == null) ? root : leftRotate(root);
        }
    }

    static Node insert(Node root, int data) {
        if (root == null)
            return newNode(data);

        root = splay(root, data);

        if (root.data == data)
            return root;

        Node node = newNode(data);
        if (root.data > data) {
            node.right = root;
            node.left = root.left;
            root.left = null;
        } else {
            node.left = root;
            node.right = root.right;
            root.right = null;
        }
        return node;
    }

    static void preOrder(Node node) {
        if (node != null) {
            System.out.println();
            System.out.print(node.data + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }
}