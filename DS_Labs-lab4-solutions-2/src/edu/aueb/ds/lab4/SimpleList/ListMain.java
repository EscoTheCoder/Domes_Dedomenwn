package edu.aueb.ds.lab4.SimpleList;

import edu.aueb.ds.exceptions.EmptyListException;


public class ListMain {
    public static void main(String[] args) {
        // Create an empty list
        ListInterface list = new List();
        VideoComparator videoComparator = new VideoComparator();

        try {
            // Print empty list
            System.out.println(list.toString());

            // Add two elements at front

            list.insertAtFront(new Video("You do NOT understand weddings. AT ALL.", "https://www.youtube.com/watch?v=p6ZojleXMn4", 3995738));
            System.out.println(list.toString());

            list.insertAtFront(new Video("Golden Retriever can't get enough of Australian Open tennis", "https://www.youtube.com/watch?v=kZm6RwukFCc", 1235033));
            System.out.println(list.toString());

            // Add two elements at back
            list.insertAtBack(new Video("A Chill Mix", "https://www.youtube.com/watch?v=wlsdMpnDBn8", 28869175));
            System.out.println(list.toString());

            list.insertAtBack(new Video("Dog on a Roomba - Easter Edition!!!", "https://www.youtube.com/watch?v=MLS0ExHWbiA", 618801));
            System.out.println(list.toString());

            System.out.println("\n\nSort list:");
            list.sort(videoComparator);
            System.out.println(list.toString());

            // Remove from front
            Video removed = list.removeFromFront();
            System.out.println(removed.getTitle() + " just got removed");

            // Remove from back
            removed = list.removeFromBack();
            System.out.println(removed.getTitle() + " just got removed");

            System.out.println("\n\nSort again:");
            list.sort(videoComparator);
            System.out.println(list.toString());


        } catch (EmptyListException ex) {
            System.out.println("Tried to remove from an empty list!");
        }
    }
}
