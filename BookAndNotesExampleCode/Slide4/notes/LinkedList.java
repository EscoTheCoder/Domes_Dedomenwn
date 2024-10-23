package notes;

class LinkedList
{
	Node head; // The head (first) node of the linked list

	// Constructor to initialize an empty linked list
	LinkedList()
	{
		this.head = null;
	}

	// Method to add a new node with the provided data to the end of the list
	public void add(Object data)
	{
		Node newNode = new Node(data);
		if (head == null)
		{
			head = newNode;
		} 
		else
		{
			Node current = head;
			while (current.next != null)
			{
				current = current.next;
			}
			current.next = newNode;
		}
	}

	// Method to delete the first occurrence of a node with the provided data
	public void delete(Object data)
	{

		if (head == null)
		{
			return; // The list is empty, nothing to delete
		}

		if (head.data.equals(data))
		{
			head = head.next; // Update the head to skip the first node
			return;
		}

		Node current = head;
		while (current.next != null)
		{
			if (current.next.data.equals(data))
			{

				current.next = current.next.next; // Update the next reference to skip the node to be deleted
				return;
			}
			current = current.next;
		}
	}

	// Method to insert a new node with the provided data at the specified position
	public void insertAtPosition(Object data, int position)
	{
		Node newNode = new Node(data);

		if (position == 0)
		{
			// Insert at the beginning of the list
			newNode.next = head;
			head = newNode;
		} 
		else
		{
			Node current = head;
			int currentPosition = 0;

			while (current != null && currentPosition < position - 1)
			{
				current = current.next;
				currentPosition++;
			}

			if (current == null)
			{
				// If the position is beyond the end of the list, add the new node at the end.
				add(data);
			} 
			else
			{
				// Insert the new node at the specified position
				newNode.next = current.next;
				current.next = newNode;
			}
		}
	}

	// Method to find the Nth node in the linked list
	public Node findNthNode(int n)
	{
		Node x = head;
		for (int i = 1; i < n; i++)
		{
			if (x == null)
			{
				return null; // Return null if N is out of bounds
			}
			x = x.next;
		}
		return x;
	}

	public void reverse()
	{
		head = reverse(head);
	}

	private Node reverse(Node x)
	{
		Node next, current = x;
		Node prev = null; // Initialize a reference to the previous node

		// Traverse the linked list
		while (current != null)
		{
			next = current.next; // Store a reference to the next node
			current.next = prev; // Reverse the link to the previous node
			prev = current; // Move the 'prev' reference to the current node
			current = next; // Move to the next node
		}

		return prev; // 'prev' now points to the new head of the reversed list
	}

	// Method to print the elements of the linked list
	public void print()
	{
		Node current = head;
		while (current != null)
		{
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}

	public static void main(String[] args)
	{
		LinkedList list = new LinkedList();

		list.add(1);
		list.add(2);
		list.add(3);

		System.out.println("Original List:");
		list.print();

		list.delete(2);

		System.out.println("List after deleting node with data 2:");
		list.print();
	}
}
