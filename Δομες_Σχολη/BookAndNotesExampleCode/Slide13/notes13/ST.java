package notes13;

import notes1.*;

public class ST 
{
    public class Node 
    {
        public int N = 0;//δικια μου
		public ITEM item;
        public Node l; // Reference to the left subtree
		public Node r;// Reference to the right subtree

        // Node constructor
        public Node(notes1.ITEM x) 
        {
            item = x;
            l = null;
            r = null;
        }
    }

    private Node head; // Pointer to the root of the tree

    // Symbol table constructor
    public ST(int maxN) 
    {
        head = null;
    }
    
//    ==================================================
    
    private Node insertR(Node h, ITEM x) 
    {
        // If the current node is null, create a new node with the given item
        if (h == null) 
        {
            return new Node(x);
        }

        // Compare keys to decide whether to insert in the left or right subtree
        if (less(x.key(), h.item.key())) 
        {
            h.l = insertR(h.l, x);
        } 
        else 
        {
            h.r = insertR(h.r, x);
        }

        return h;
    }

    // Method to insert a new item into the tree
    void insert_xrisiRecursive(ITEM x) //meta tin _ exoo valei diko moy onoma gia na min iparxei conflict idiou onomatos
    {
        head = insertR(head, x);
    }

    private ITEM searchR(Node h, KEY v) //R=recursive
    {
        // If the current node is null, the item is not found
        if (h == null) 
        {
            return null;
        }

        // Compare keys to decide whether to search in the left or right subtree
        if (equals(v, h.item.key())) 
        {
            return h.item;
        } 
        else if (less(v, h.item.key())) 
        {
            return searchR(h.l, v);
        } 
        else 
        {
            return searchR(h.r, v);
        }
    }

	// Public method to search for an item with a given key
    ITEM search(KEY key) 
    {
        return searchR(head, key);
    }
    
    private boolean less(KEY v, KEY key)
   	{
   		// TODO Auto-generated method stub
   		return false;
   	}

   	private boolean equals(KEY v, KEY key)
   	{
   		// TODO Auto-generated method stub
   		return false;
   	}
    
//    ==============================================================
    
    private int countR(Node h) 
    {
        // If the current node is null, return 0
        if (h == null) 
        {
            return 0;
        }

        // Recursively count nodes in the left and right subtrees
        return 1 + countR(h.l) + countR(h.r);
    }

    // Public method to get the count of elements in the tree
    int count() 
    {
        return countR(head);
    }
    
//  ==============================================================
    

    private String toStringR(Node h) 
    {
        // If the current node is null, return an empty string
        if (h == null) 
        {
            return "";
        }

        // Recursively build the string representation by visiting left, current, and right nodes
        String s = toStringR(h.l);
        s += h.item.toString() + "\n"; // It plays the role of the visit()
        s += toStringR(h.r);

        return s;
    }

    // Public method to get the string representation of the tree
    public String toString() 
    {
        return toStringR(head);
    }
    
//  ==============================================================
    
    
//    =============xrisi vroxou xoris anadromi==================
    public void insert_vroxos(ITEM x) 
    {
        KEY key = x.key();
        // If the tree is empty, create a new node and set it as the head
        if (head == null) 
        {
            head = new Node(x);
            return;
        }

        Node currentParent = head, currentChild = currentParent;// στις σημειωσεις ειναι p, q

        // Traverse the tree to find the appropriate position for the new node
        while (currentChild != null) 
        {
            if (less(key, currentChild.item.key())) 
            {
                currentParent = currentChild;
                currentChild = currentChild.l;
            } 
            else // Here, currentChild is one level below currentParent
            {
                currentParent = currentChild;
                currentChild = currentChild.r;
            }           
        }

        // Insert the new node in the appropriate position
        if (less(key, currentParent.item.key())) 
        {
            currentParent.l = new Node(x);
        } 
        else 
        {
            currentParent.r = new Node(x);
        }
    }

//    ======================================================================
    
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

//  =====================================================================
    //πρωτα γινεται εισαγωφη ως φυλλο και μετα με rotations ερχεται στη ριζα
    private Node insertT(Node h, ITEM x) 
    {
        // Recursive method to insert an item into the tree root
        if (h == null) 
        {
            return new Node(x);
        }

        if (less(x.key(), h.item.key())) 
        {
            // Insert into the left subtree and perform a right rotation
            h.l = insertT(h.l, x);
            h = rotR(h);
        } 
        else 
        {
            // Insert into the right subtree and perform a left rotation
            h.r = insertT(h.r, x);
            h = rotL(h);
        }

        return h;
    }

    // Public method to insert an item into the tree
    public void insert(ITEM x) 
    {
        head = insertT(head, x);
    }

//    ======================Επιλογή k-οστού μικρότερου κόμβου================
    
  //για το k-οστό μικρότερο, το όρισμα πρέπει να είναι k-1
    private ITEM selectR(Node h, int k) 
    {
        // Recursive method to find the k-th smallest item
        if (h == null) 
        {
            return null;
        }

        int t = (h.l == null) ? 0 : h.l.N; // N represents the size of the subtree rooted at the node

        if (t > k) 
        {
            // If k is smaller, search in the left subtree
            return selectR(h.l, k);
        } 
        else if (t < k) 
        {
            // If k is larger, search in the right subtree
            return selectR(h.r, k - t - 1);
        }

        // If t is equal to k, return the item at the current node
        return h.item;
    }

    // Public method to select the k-th smallest item
    ITEM select(int k) 
    {
        return selectR(head, k);
    }

//    ========================================================================
    
    private Node partR(Node h, int k) 
    {
        // Recursive method to perform partial right rotation
        // The argument k represents the (k+1)-th smallest, making it the root
        int t = (h.l == null) ? 0 : h.l.N;

        if (t > k) 
        {
            h.l = partR(h.l, k);
            h = rotR(h);
        } 
        else if (t < k) 
        {
            h.r = partR(h.r, k - t - 1);
            h = rotL(h);
        }

        return h;
    }
    
//  ========================================================================

    void remove(KEY v) 
    {
        head = removeR(head, v);
    }

    private Node removeR(Node h, KEY v) 
    {
        // Recursive method to remove a node with a given key
        if (h == null) 
        {
            return null;
        }

        KEY w = h.item.key();

        if (less(v, w)) 
        {
            h.l = removeR(h.l, v);
        } 
        else if (less(w, v)) 
        {
            h.r = removeR(h.r, v);
        } 
        else if (equals(v, w)) 
        {
            h = joinLR(h.l, h.r);
        }

        return h;
    }

    private Node joinLR(Node a, Node b) 
    {
        // Join operation for removing a node
        if (b == null) 
        {
            return a;
        }

        b = partR(b, 0); // Partition with k=0, making the smallest element the root of b
        b.l = a; // Set a as the left subtree of b
        return b;
    }

    private Node joinR(Node a, Node b) 
    {
        // Recursive method to join two trees
        if (b == null) 
        {
            return a;
        }

        if (a == null) 
        {
            return b;
        }

        b=insertT(b, a.item);
        b.l = joinR(a.l, b.l);
        b.r = joinR(a.r, b.r);
        return b;
    }

    public void join(ST b) 
    {
        // Public method to join the current tree with another tree
        head = joinR(head, b.head);
    }

}

