package notes;

class IntQueueList 
{
    private Node head, tail;

    // Inner class Node for creating linked list nodes
    

    // Constructor to initialize the queue
    IntQueueList(int max) 
    {
        head = null;
        tail = null;
    }

    // Check if the queue is empty
    boolean isEmpty() 
    {
        return (head == null);
    }

    // Put (enqueue) an item into the queue
    void put(int item) 
    {
        Node t = tail;
        tail = new Node(item);
        if (isEmpty()) 
        {
            head = tail;
        } 
        else 
        {
            t.next = tail;
        }
    }

    // Get (dequeue) an item from the queue
    int get() 
    {
        int v = (int)head.data;
        Node t = head.next;
        head = t;
        return v;
    }
}

