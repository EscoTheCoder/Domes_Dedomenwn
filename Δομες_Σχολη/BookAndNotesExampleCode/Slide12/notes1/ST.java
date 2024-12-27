package notes1;

class ST 
{
    // Private inner class representing a node in the linked list
    private class Node 
    {
        ITEM item;
        Node next;

        // Node constructor
        Node(ITEM x, Node t) 
        {
            item = x;
            next = t;
        }
    }

    private Node head; // Reference to the first node in the linked list
    private int N;     // Number of elements in the symbol table

    // Symbol table constructor
    ST(int maxN) 
    {
        head = null;
        N = 0;
    }

    // Method to get the count of elements in the symbol table
    int count() 
    {
        return N;
    }

    // Method to insert a new item into the symbol table
    void insert(ITEM x) 
    {
        head = new Node(x, head);
        N++;
    }

    // Private recursive method to search for an item with a given key
    private ITEM searchR(Node t, KEY key) 
    {
        if (t == null) 
        {
            return null;
        }
        if (equals(t.item.key(), key)) 
        {
            return t.item;
        }
        return searchR(t.next, key);
    }

    private boolean equals(KEY key, KEY key2)
	{
		// TODO Auto-generated method stub
		return false;
	}

	// Public method to search for an item with a given key
    ITEM search(KEY key) 
    {
        return searchR(head, key);
    }
    
    
}

