public class Main {
    public static void main(String[] args) {

        Circular_Singly_Linked_List csll = new Circular_Singly_Linked_List();

        csll.insertLast(5);
        csll.insertLast(10);
        csll.insertLast(15);
        csll.insertLast(20);
        csll.insertLast(25);

        csll.show();

        csll.deleteLast();
        csll.deleteLast();

        csll.show();
    }
}