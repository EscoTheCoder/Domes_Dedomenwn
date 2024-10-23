package notes;

//implementation od 6-35 page
public class IntStackNode 
{
	private Node head;

	// Inner class Node for creating linked list nodes
	private class Node 
	{
	    int item;
	    Node next;

	    Node(int item, Node next) 
	    {
	        this.item = item;
	        this.next = next;
	    }
	}

	IntStackNode(int maxN) 
	{
	    head = null;
	}

	// Check if the stack is empty
	boolean isEmpty() 
	{
	    return (head == null);
	}

	// Push an item onto the stack
	void push(int item) 
	{
	    head = new Node(item, head);
	}

	// Pop an item from the stack
	int pop() 
	{
	    int v = head.item;
	    Node t = head.next;
	    head = t; // head points to the next node
	    return v;
	}


}
