package notes;


class Josephus 
{
    static class Node 
    {
        int val;
        Node next;

        // Constructor to initialize a new node with the given value
        Node(int v) 
        {
            val = v;
        }
    }

    public static void main(String[] args) 
    {
        int N = Integer.parseInt(args[0]); // Total number of people
        int M = Integer.parseInt(args[1]); // Elimination interval

        // Create the first node, which represents the first person
        Node first = new Node(1);
        Node x = first;

        // Create a circular linked list with N nodes, where N is the total number of people
        for (int i = 2; i <= N; i++) 
        {
            x.next = new Node(i);
            x = x.next;
        }
        
        // Make the last node point back to the first node to form a circle
        x.next = first;

        //while x not pointing to itself
        while (x != x.next) 
        {
            // Continue the elimination process until only one person remains
            for (int i = 1; i < M; i++) 
            {
                x = x.next; // Move M-1 steps to reach the M-th person for elimination
            }
            
            // Eliminate the M-th person by skipping them in the linked list
            x.next = x.next.next;
        }

        // Print the value (the number) of the survivor
        Out.println("Survivor is " + x.val);
    }
}
