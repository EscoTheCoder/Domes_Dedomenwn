public class Main {
    public static void main(String[] args) {

        LinkedList list = new LinkedList();
        list.insertAtEnd(18);
        list.insertAtEnd(45);
        list.insertAtEnd(12);
//        list.insertAtStart(25);
//        list.insertAt(0,55);
//        list.deleteAt(2);


        list.show();

        //list.deleteLastNode();

        System.out.println();

        list.reverse();

        list.show();



    }
}