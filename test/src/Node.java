class Node {
    int key;
    Node next;

    Node(int x) {
        key = x;
    }

    public Node Fib(int k) {
        if (k <= 0) {
            return null;
        }

        // Δημιουργία του πρώτου κόμβου
        Node head = new Node(1);
        if (k == 1) {
            head.next = head; // Κυκλική λίστα με μόνο έναν κόμβο
            return head;
        }

        // Δημιουργία του δεύτερου κόμβου
        Node second = new Node(1);
        head.next = second;

        // Αν η λίστα έχει μόνο 2 κόμβους, ολοκλήρωση της κυκλικής λίστας
        if (k == 2) {
            second.next = head;
            return head;
        }

        // Χρήση δύο βοηθητικών μεταβλητών για τους αριθμούς Fibonacci
        Node prev = head;
        Node curr = second;
        int f1 = 1, f2 = 1;

        // Δημιουργία των υπόλοιπων κόμβων
        for (int i = 3; i <= k; i++) {
            int fn = f1 + f2;
            Node newNode = new Node(fn);
            curr.next = newNode;

            // Ενημέρωση των τιμών για την επόμενη επανάληψη
            prev = curr;
            curr = newNode;
            f1 = f2;
            f2 = fn;
        }

        // Ολοκλήρωση της κυκλικής λίστας
        curr.next = head;

        return head;
    }
    // Μέθοδος για την εκτύπωση της λίστας
    public static void printList(Node head, int k) {
        Node current = head;
        for (int i = 0; i < k; i++) {
            System.out.print(current.key + " ");
            current = current.next;
        }
        System.out.println();
    }
}