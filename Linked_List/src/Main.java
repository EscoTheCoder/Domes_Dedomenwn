import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        LinkedList list = new LinkedList();

        list.insertAtEnd(1);
        list.insertAtEnd(2);
        list.insertAtEnd(3);
        list.insertAtEnd(4);

        ArrayList<Integer> arr = new ArrayList<>();

        LinkedList.Node temp = list.head;
        while(temp!=null){
            arr.add((Integer) temp.data);
            temp = temp.next;
        }

        System.out.println(arr);

        ArrayList<Integer> rearranged = new ArrayList<>();

        int i = 0;
        int j = arr.size() - 1;
        while (i <= j) {
            if (i == j) {
                rearranged.add(arr.get(i)); // Add middle element once
            } else {
                rearranged.add(arr.get(i));
                rearranged.add(arr.get(j));
            }
            i++;
            j--;
        }

        System.out.println(rearranged);
    }
}
