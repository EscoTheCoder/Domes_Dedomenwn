public class Main {
    public static void main(String[] args) {

        LinkedList list = new LinkedList();
        list.insertAtEnd(18);
        list.insertAtEnd(45);
        list.insertAtEnd(12);



        list.show();

        System.out.println();

        System.out.println(list.deleteAt(2));
        //System.out.println(list.deleteAt(0));

        System.out.println();

        list.reverse();

        list.show();



    }
}