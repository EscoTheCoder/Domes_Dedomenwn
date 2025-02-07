import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        LinkedList list = new LinkedList();

        list.insertAtEnd(4);
        list.insertAtEnd(3);
        list.insertAtEnd(2);
        list.insertAtEnd(1);

        list.show();

        list.delete(5);

        list.show();


    }
}
