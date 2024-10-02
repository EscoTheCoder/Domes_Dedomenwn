package edu.aueb.ds.lab3.Genericlist;

import edu.aueb.ds.exceptions.EmptyListException;

public class ListMain {
    public static void main(String[] args) {
        // Create an empty list
        ListInterface<Video> list = new List<>(); //List is implicitly declared as Video

        try {
            // Print empty list
            System.out.println(list.toString());

            // Add two elements at front
            list.insertAtFront(new Video("Η οικονομία της προσοχής", "https://www.youtube.com/watch?v=sQXubDsT9zs", 126223));
            System.out.println(list.toString());

            list.insertAtFront(new Video("\"You do NOT understand weddings. AT ALL.\"", "https://www.youtube.com/watch?v=p6ZojleXMn4", 3995738));
            System.out.println(list.toString());

            // Add two elements at back
            list.insertAtBack(new Video("Golden Retriever can't get enough of Australian Open tennis", "https://www.youtube.com/watch?v=kZm6RwukFCc", 1235033));
            System.out.println(list.toString());

            list.insertAtBack(new Video("Dog on a Roomba - Easter Edition!!!", "https://www.youtube.com/watch?v=MLS0ExHWbiA", 618801));
            System.out.println(list.toString());

            // Remove from front
            Video removed = list.removeFromFront();
            System.out.println(removed.getTitle() + " just got removed");

            // Remove from back
            removed = list.removeFromBack();
            System.out.println(removed.getTitle() + " just got removed");

            System.out.println(list.toString());

            // keep removing until an exception is thrown
            System.out.println("Keep removing from list!");
            // 100 in case something goes wrong, to prevent endless loop
            for (int i = 0; i < 100; ++i) {
                removed = list.removeFromFront();
                System.out.println(removed.getTitle() + " just got removed");

                removed = list.removeFromBack();
                System.out.println(removed.getTitle() + " just got removed");
            }
        } catch (EmptyListException ex) {
            System.out.println("Tried to remove from an empty list!");
        }
    }
}
