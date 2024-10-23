
public class RandomisedBST
{
	// Node class represents a node in the tree
	private class Node
	{
		MyItem item; // The data stored in the node
		Node l; // Reference to the left child
		Node r; // Reference to the right child
		int N; // Number of nodes in the subtree rooted at this node

		// Constructor for creating a new Node
		Node(MyItem item)
		{
			this.item = item;
			this.N = 1; // Initializing N to 1 for the new node
			this.l = this.r = null;
		}
	}

	private Node head;

	// Recursive method to insert a node into the tree
	private Node insertR(Node h, MyItem x)
	{
		// If the current node is null, create a new node with item x
		if (h == null)
		{
			return new Node(x);
		}

		// Randomly choose whether to insert at the root of the subtree
		if (Math.random() * (h.N + 1) < 1.0)
		{
			return insertT(h, x); // Insert at the root of the subtree
		}

		// Compare the keys to decide whether to go left or right
		if (less(x.key(), h.item.key()))
		{
			h.l = insertR(h.l, x); // Recursively insert into the left subtree
		} else
		{
			h.r = insertR(h.r, x); // Recursively insert into the right subtree
		}

		h.N++; // Increment the number of nodes in the subtree
		return h;
	}

	// Method to insert a node into the tree
	void insert(MyItem x)
	{
		head = insertR(head, x); // Start the recursive insertion from the root
	}

	private Node insertT(Node h, MyItem x)
	{
		// Recursive method to insert an item into the tree
		if (h == null)
		{
			return new Node(x);
		}

		if (less(x.key(), h.item.key()))
		{
			// Insert into the left subtree and perform a right rotation
			h.l = insertT(h.l, x);
			h = rotR(h);
		} else
		{
			// Insert into the right subtree and perform a left rotation
			h.r = insertT(h.r, x);
			h = rotL(h);
		}

		return h;
	}

	public static Node rotR(Node h)
	{
		// Right rotation operation
		Node x = h.l;
		h.l = x.r;
		x.r = h;
		return x;
	}

	public static Node rotL(Node h)
	{
		// Left rotation operation
		Node x = h.r;
		h.r = x.l;
		x.l = h;
		return x;
	}

	// Method to join two subtrees a and b into a single tree
	private Node joinLR(Node a, Node b)
	{
		// Total number of nodes in the combined subtrees
		int N = a.N + b.N;

		// If a is null, return b
		if (a == null)
		{
			return b;
		}

		// If b is null, return a
		if (b == null)
		{
			return a;
		}

		// Randomly decide whether to join a.r and b or a and b.l
		if (Math.random() * N < 1.0 * a.N)
		{
			a.r = joinLR(a.r, b);
			return a; // Place b under a
		} else
		{
			b.l = joinLR(a, b.l);
			return b; // Place a under b
		}
	}

	private boolean less(int i, int j)
	{
		return i < j;
	}

}
