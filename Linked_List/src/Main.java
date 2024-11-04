
public class Main {
    public static void main(String[] args) {
        // Create an empty list
        LinkedList list = new LinkedList();

        try {

            // Print empty list
            System.out.println(list.toString());

            // Add two elements at front
            list.insertAtStart(1);
            System.out.println(list.toString());

            list.insertAtStart(2);
            System.out.println(list.toString());

            // Add two elements at back
            list.insertAtEnd(3);
            System.out.println(list.toString());

            list.insertAtEnd(4);
            System.out.println(list.toString());

            // Remove from front
            Object removed = list.deleteFirstNode();
            System.out.println(removed + " just got removed...");

            // Remove from back
            removed = list.deleteLastNode();
            System.out.println(removed + " just got removed...");

            System.out.println(list.toString());

            // Insert at front
            list.insertAtStart(5);

            // Insert ta back
            list.insertAtEnd(6);
            System.out.println(list.toString());


            // keep removing until an exception is thrown
            System.out.println("Keep removing from list!");
            // 100 in case something goes wrong, to prevent endless loop
            for (int i = 0; i < 100; ++i) {
                removed = list.deleteFirstNode();
                System.out.println(removed + " just got removed...");

                removed = list.deleteLastNode();
                System.out.println(removed + " just got removed...");
            }
        } catch (Exception ex) {
            System.out.println("Tried to remove from an empty list!");
        }
    }
}
