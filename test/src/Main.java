public class Main {
    public static void main(String[] args) {
        int k = 6; // π.χ., k = 6
        Node n = new Node(k);
        Node head = n.Fib(k);
        if (head != null) {
            n.printList(head, k);
        }
        else {
            System.out.println("The list is empty.");
        }
    }
}