package notes;


class ListSortExample 
{
    static class Node 
    {
        int val;
        Node next;

        // Constructor to initialize a new node with the given value and reference to the next node
        Node(int v, Node t) 
        {
            val = v;
            next = t;
        }
    }

    // Create a linked list from user input
    static Node create() 
    {
        Node a = new Node(0, null); // Pseudo-node
        for (In.init(); !In.empty(); ) 
        {
            a.next = new Node(In.getInt(), a.next);// Insert a new node with user input. 
            										//To a.next=null, ara kathe node pou dimiourgeite exei to next os null, mexri na dimiourgithei neo node
        }
        return a; // Create a list with head 'a'
    }

    // Print the values of the linked list
    static void print(Node h) 
    {
        for (Node t = h.next; t != null; t = t.next) 
        {
            Out.println(t.val + "");
        }
    }

    static Node sort(Node a) 
    {
        Node b = new Node(0, null); // Pseudo-head node
        Node currNode, u, x;
        // currNode is the node leaving 'a' to join 'b'
        while (a.next != null) 
        {
            // First, remove the node from 'a'
            currNode = a.next;//currNode = removed node
            u = currNode.next;
            a.next = u;
            // Next, find the position in 'b' where currNode should be inserted
            for (x = b; x.next != null; x = x.next) 
            {
                if (x.next.val > currNode.val) 
                {
                    break;
                }
            }
            currNode.next = x.next; // Insert into 'b'
            x.next = currNode;
        }
        return b; // Return the sorted list in 'b'
    }
}
