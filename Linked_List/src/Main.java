
public class Main {
    public static void main(String[] args) {
        // Create an empty list
        LinkedList list = new LinkedList();

        list.insertAtEnd(10);
        list.insertAtEnd(8);
        list.insertAtEnd(6);
        list.insertAtEnd(3);
        list.insertAtEnd(1);

        System.out.println(list);

        list.delete(6);

        System.out.println(list);
    }
}
