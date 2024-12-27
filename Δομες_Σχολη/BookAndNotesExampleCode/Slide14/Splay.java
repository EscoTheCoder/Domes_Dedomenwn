import notes1.ITEM;
import notes1.KEY;
import notes13.*;
import notes13.ST.Node;
public class Splay
{
	private Node head; // Pointer to the root of the tree
	ST st = new ST(0);//το εχω βαλει εγω γιατι χρησιμοποιειει τις μεθοδους της 13ης διαφανειας
	
	void insert(ITEM x) 
	{
	    head = splay(head, x);
	}
	
	private Node splay(Node h, ITEM x) 
	{
	    // Base case: If the current node is null, create a new node and return it
	    if (h == null) 
	    {
	        return  st.new Node(x); // End of recursion
	    }

	    // If the key of the given item is less than the key of the current node's item
	    if (less(x.key(), h.item.key())) 
	    {
	        // If the left child is null, create a new node and perform a right rotation
	        if (h.l == null) 
	        {
	            h.l = st.new Node(x);
	            return ST.rotR(h);
	        }

	        // If the key of the given item is less than the key of the left child's item
	        if (less(x.key(), h.l.item.key())) 
	        {
	            h.l.l = splay(h.l.l, x);
	            h = ST.rotR(h); // Perform a right rotation at the root
	        } 
	        else 
	        {
	            h.l.r = splay(h.l.r, x);
	            h.l = ST.rotL(h.l);
	        }

	        return ST.rotR(h); // Second rotation is always at the root
	    } 
	    else 
	    {
	        // If the right child is null, create a new node and perform a left rotation
	        if (h.r == null) 
	        {
	            h.r = st.new Node(x);
	            return ST.rotL(h);
	        }

	        // If the key of the right child's item is less than the key of the given item
	        if (less(h.r.item.key(), x.key())) 
	        {
	            h.r.r = splay(h.r.r, x);
	            h = ST.rotL(h);
	        } 
	        else 
	        {
	            h.r.l = splay(h.r.l, x);
	            h.r = ST.rotR(h.r);
	        }

	        return ST.rotL(h); // Second rotation is always at the root
	    }
	}

	private boolean less(KEY key, KEY key2)
	{
		return false;
	}

}
