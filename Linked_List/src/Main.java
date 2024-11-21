
public class Main {
    public static void main(String[] args) {
        // Create an empty list
        LinkedList list = new LinkedList();

        list.insert(1);
        list.insert(7);
        list.insert(3);
        list.insert(4);
        list.insert(5);

        System.out.println(list);

        list.delete(6);

        System.out.println(list);
    }
}
