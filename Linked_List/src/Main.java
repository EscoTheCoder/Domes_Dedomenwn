
public class Main {
    public static void main(String[] args) {
        // Create an empty list
        LinkedList list = new LinkedList();

        list.insert(5);
        list.insert(3);
        list.insert(1);
        list.insert(7);
        list.insert(2);

        list.show();

        System.out.println(list.findmax());

        list.show();

//        list.delete(5);
//        list.delete(3);

//        System.out.println(list);
    }
}
