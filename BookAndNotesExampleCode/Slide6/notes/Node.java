package notes;


class Node
{
	Object data;  // Data stored in the node (can be any object type)
    Node next;    // Reference to the next node in the linked list
	ITEM item;

    // Constructor to initialize a new node with the given data
	public Node(Object data) 
    {
        this.data = data;  // Assign the provided data to the node's data
        this.next = null;  // Initialize the next reference to null (end of the list)
    }

	public Node(int i, Node h) 
	{
		// TODO Auto-generated constructor stub
	}
	
	public Node(ITEM item) 
	{
		this.item=item;
	}
}
