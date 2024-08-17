public class Main {
    public static void main(String[] args) {

        Doubly_Linked_List dll=new Doubly_Linked_List();

        dll.insertFirst(5);
        dll.insertLast(10);
        dll.insertLast(15);
        dll.insertLast(20);

        dll.displayListForward();
        dll.deleteFirst();
        dll.displayListForward();
        //dll.displayListBackward();

    }
}