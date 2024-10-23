import notes1.ITEM;
import notes1.KEY;
public class RedBlack
{
	public class Node
	{
		public ITEM item;
		public Node l; // References to the left and right subtrees
		public Node r;
		boolean cbit = false;//colorbit.True is red,black is false

		// Node constructor
		public Node(notes1.ITEM x, boolean rb)
		{
			item = x;
			l = null;
			r = null;
			cbit=rb;
		}

	}

	private Node head;
	private static final boolean R = true;
	private static final boolean B = false;

	private boolean red(Node x)
	{
		// If the node is null, return false; otherwise, return the color bit of the
		// node
		if (x == null)
		{
			return false;
		}
		return x.cbit;
	}

	void insert(ITEM x)
	{
		head = insertR(head, x, false);
		head.cbit = B;
	}
//sw=true means node =right subtree
	private Node insertR(Node h, ITEM x, boolean sw)
	{
		// Base case: If the current node is null, create a new red node
		if (h == null)
		{
			return new Node(x, R);
		}
		// We found a 4-node; perform splitting
		if (red(h.l) && red(h.r))
		{
			
			h.cbit = R;
			h.l.cbit = B;
			h.r.cbit = B;
		}

		/* If the key of the given item is less than the key of the current node's item
		go to left tree*/
		if (less(x.key(), h.item.key()))
		{
			h.l = insertR(h.l, x, false);

			// Perform right rotation if necessary
			if (red(h) && red(h.l) && sw)
			{
				h = rotR(h);
			}

			// If there are two consecutive red links below h, perform a right rotation
			if (red(h.l) && red(h.l.l))
			{
				h = rotR(h);
				h.cbit = B;
				h.r.cbit = R;
			}
		} 
		/*go to right tree*/
		else
		{
			h.r = insertR(h.r, x, true);

			// Perform left rotation if necessary
			if (red(h) && red(h.r) && !sw)
			{
				h = rotL(h);
			}

			// If there are two consecutive red links below h, perform a left rotation
			if (red(h.r) && red(h.r.r))
			{
				h = rotL(h);
				h.cbit = B;
				h.l.cbit = R;
			}
		}

		return h;
	}

	public Node rotR(Node h)
	{
		// Right rotation operation
		Node x = h.l;
		h.l = x.r;
		x.r = h;
		return x;
	}

	public Node rotL(Node h)
	{
		// Left rotation operation
		Node x = h.r;
		h.r = x.l;
		x.l = h;
		return x;
	}

	private boolean less(KEY key, KEY key2)
	{
		return false;
	}
}
