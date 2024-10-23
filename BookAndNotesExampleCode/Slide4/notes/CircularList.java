package notes;

class CircularList 
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

    // Get the next node after the given node 'x'
    Node next(Node x) 
    {
        return x.next;
    }

    // Get the value of the given node 'x'
    int val(Node x) 
    {
        return x.val;
    }

    // Insert a new node with value 'v' after node 'x'
    Node insert(Node x, int v) 
    {
        // Create a new node 't' with the given value
        Node t = new Node(v);
        if (x == null) 
        {
            // If 'x' is null, make 't' point to itself (empty list) 
            t.next = t;
        } 
        else 
        {
            // Insert 't' after 'x'
            t.next = x.next;
            x.next = t;
        }
        return t; // Return the last inserted node
    }

    // Remove the node after the given node 'x'
    void remove(Node x) 
    {
        x.next = x.next.next;
    }
}
