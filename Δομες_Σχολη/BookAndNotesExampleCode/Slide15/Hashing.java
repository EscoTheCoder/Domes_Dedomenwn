import notes1.ITEM;
import notes1.KEY;

public class Hashing
{
	// This function calculates the hash code for a given string using a basic hash algorithm.
	// It takes the string 's' and a modulo value 'M' as parameters.
	static int hashU(String s, int M)
	{
	    // Initialize variables for hash computation
	    int h = 0;       // hash code
	    int a = 31415;   // constant multiplier
	    int b = 27183;   // constant multiplier

	    // Iterate through each character in the input string
	    for (int i = 0; i < s.length(); i++) 
	    {
	        // Update the hash code using the current character and constants 'a' and 'b'
	        h = (a * h + s.charAt(i)) % M;
	        
	        // Update constant 'a' for the next iteration
	        a = a * b % (M - 1);
	    }

	    // Return the final calculated hash code
	    return h;
	}

	/*=====================separate chaining===============================*/
	// Class representing a symbol table (ST) with separate chaining using an unordered linked list.
	private class ST 
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
	    
	    private Node[] heads; // Array of linked list heads
	    private int N, M;     // Number of elements and size of the array

	    // Constructor initializes the symbol table with a given maximum size estimate.
	    ST(int maxN) 
	    {
	        N = 0;
	        M = maxN / 5;  // M is set to one-fifth of the estimated maximum size
	        heads = new Node[M];  // Initialize array of linked list heads
	    }

	    // Search for an item with a given key in the symbol table.
	    ITEM search(KEY key) 
	    {
	        return searchR(heads[hash(key, M)], key);
	    }
	    
		// Recursive search in an unordered linked list (Chapter 12).
	    ITEM searchR(Node node, KEY key) 
	    {
	    	if (node == null) 
	        {
	            return null;
	        }
	        if (Hashing.equals(node.item.key(), key)) 
	        {
	            return node.item;
	        }
	        return searchR(node.next, key);
	    }

	    

		// Insert an item into the symbol table.
	    void insert(ITEM x) 
	    {
	        int i = hash(x.key(), M);  // Compute hash index for the item
	        heads[i] = new Node(x, heads[i]);  // Insert the item at the beginning of the linked list
	        N++;  // Increment the total number of elements in the symbol table
	    }
	}
	
	/*=====================separate chaining END===============================*/
	
	/*============================linear probing===============================*/
	// Class representing a symbol table (ST) with linear probing for collision resolution.
	private class ST1 
	{
	    private ITEM[] st;  // Array to store items
	    private int N, M;    // Number of elements and size of the array

	    // Constructor initializes the symbol table with a given maximum size estimate.
	    ST1(int maxN) 
	    {
	        N = 0;
	        M = 2 * maxN;  // M is set to twice the estimated maximum size
	        st = new ITEM[M];  // Initialize array to store items
	    }

	    // Insert an item into the symbol table using linear probing for collision resolution.
	    void insert(ITEM x)
	    {
	        int i = hash(x.key(), M);  // Compute the initial hash index for the item
	        while (st[i] != null) 
	        {
	            i = (i + 1) % M;  // Increment index with linear probing until an empty slot is found
	        }
	        st[i] = x;  // Insert the item into the found empty slot
	        N++;  // Increment the total number of elements in the symbol table
	    }

	    // Search for an item with a given key in the symbol table.
	    ITEM search(KEY key) 
	    {
	        int i = hash(key, M);  // Compute the initial hash index for the key
	        while (st[i] != null) 
	        {
	            if (Hashing.equals(key, st[i].key())) 
	            {
	                return st[i];  // Return the item if the key is found
	            } 
	            else 
	            {
	                i = (i + 1) % M;  // Increment index with linear probing until an empty slot or a matching key is found
	            }
	        }
	        return null;  // Return null if the key is not found in the symbol table
	    }
	    
	 // Method to remove an item from the symbol table.
	    public void remove(ITEM x) {
	        int i = hash(x.key(), M);  // Compute the initial hash index for the item x

	        while (st[i] != null) {
	            if (Hashing.equals(x.key(), st[i].key())) {
	                break;  // Exit the loop if the key of x matches the key in the current slot
	            } else {
	                i = (i + 1) % M;  // Increment index with linear probing until an empty slot or a matching key is found
	            }
	        }

	        if (st[i] == null) {
	            return;  // If the key of x is not found, return without removing anything
	        }

	        st[i] = null;  // Remove the item x from the current slot
	        N--;  // Decrement the total number of elements in the symbol table

	        // Perform rehashing for items following the removed item
	        for (int j = i + 1; st[j] != null; j = (j + 1) % M) {
	            x = st[j];  // Temporary storage of the item at index j
	            st[j] = null;  // Remove the item from the current slot
	            insert(x);  // Insert the item back into the symbol table
	            N--;  // Decrement the total number of elements in the symbol table
	        }
	        // Note: Be cautious about updating N in the comments as it mentions updating N, but N is already updated in the code.
	    }

	}
	public static int hash(KEY key, int m2)
	{
		// TODO Auto-generated method stub
		return 0;
	}
	
	public static boolean equals(KEY key, KEY key2)
	{
		// TODO Auto-generated method stub
		return false;
	}
	
	/*=============================================DoubleHashing===============================================*/
	private class DoubleHashing
	{
		 private ITEM[] st;
		 int M,N;
		// Insert an item into the symbol table using double hashing for collision resolution.
		void insert(ITEM x) 
		{
		    KEY key = x.key();  // Extract the key from the item x
		    int i = hash(key, M);  // Compute the initial hash index for the item x
		    int k = hashtwo(key);  // Compute the second hash value using a second hash function

		    // Perform double hashing with a step size of k until an empty slot is found
		    while (st[i] != null) 
		    {
		        i = (i + k) % M;  // Increment index with double hashing step size k
		    }

		    st[i] = x;  // Insert the item into the found empty slot
		    N++;  // Increment the total number of elements in the symbol table
		}

		private int hashtwo(KEY key)
		{

			return 0; //((int)key % 97)+1;
		}

		// Search for an item with a given key in the symbol table using double hashing.
		ITEM search(KEY key) 
		{
		    int i = hash(key, M);  // Compute the initial hash index for the key
		    int k = hashtwo(key);  // Compute the second hash value using a second hash function

		    // Perform double hashing with a step size of k until an empty slot or a matching key is found
		    while (st[i] != null) 
		    {
		        if (Hashing.equals(key, st[i].key())) 
		        {
		            return st[i];  // Return the item if the key is found
		        } 
		        else
		        {
		            i = (i + k) % M;  // Increment index with double hashing step size k
		        }
		    }

		    return null;  // Return null if the key is not found in the symbol table
		}

	}
	/*=============================================Dynamic Hashing===============================================*/
	// Class representing a symbol table (ST) with linear probing and dynamic resizing.
	private class ST2 
	{
	    private ITEM[] st;  // Array to store items
	    private int N, M;    // Number of elements and size of the array

	    // Constructor initializes the symbol table with an initial size of 4.
	    ST2(int maxN) 
	    {
	        N = 0;
	        M = 4;  // Initial size of the array
	        st = new ITEM[M];  // Initialize array to store items
	    }

	    // Method to expand the size of the array when the load factor exceeds 0.5.
	    private void expand() 
	    {
	        ITEM[] t = st;  // Store the current array for rehashing
	        N = 0;  // Reset the number of elements
	        M = M + M;  // Double the size of the array
	        st = new ITEM[M];  // Create a new array with the expanded size

	        // Rehash and insert each non-null item from the old array into the new array
	        for (int i = 0; i < M / 2; i++) 
	        {
	            if (t[i] != null) 
	            {
	                insert(t[i]);  // Insert the item into the new array
	            }
	        }
	    }

	    // Insert an item into the symbol table using linear probing.
	    void insert(ITEM x) {
	        int i = hash(x.key(), M);  // Compute the initial hash index for the item x

	        // Perform linear probing until an empty slot is found
	        while (st[i] != null) {
	            i = (i + 1) % M;  // Increment index with linear probing
	        }

	        st[i] = x;  // Insert the item into the found empty slot
	        if (N++ >= M / 2) {
	            expand();  // If the load factor exceeds 0.5, expand the array
	        }
	    }
	}
	
	// Class representing a symbol table (ST) with resizing using linear probing for collision resolution.
	private class ST3 {
	    private ITEM[] st;  // Array to store items
	    private int N, M;    // Number of elements and size of the array

	    // Constructor initializes the symbol table with a given initial size.
	    ST3(int maxN) {
	        N = 0;
	        M = 4;  // Initial size of the array
	        st = new ITEM[M];  // Initialize array to store items
	    }

	    // Method to expand the size of the array when the load factor becomes too high.
	    private void expand() {
	        ITEM[] t = st;  // Temporary array to hold the current items
	        N = 0;
	        M = M + M;  // Double the size of the array
	        st = new ITEM[M];  // Initialize the new array with the doubled size

	        // Rehash the items from the temporary array into the new array
	        for (int i = 0; i < M / 2; i++) {
	            if (t[i] != null) {
	                insert(t[i]);  // Insert each item back into the symbol table
	            }
	        }
	    }

	    // Method to insert an item into the symbol table using linear probing for collision resolution.
	    void insert(ITEM x) {
	        int i = hash(x.key(), M);  // Compute the initial hash index for the item x

	        // Perform linear probing until an empty slot is found
	        while (st[i] != null) {
	            i = (i + 1) % M;  // Increment index with linear probing
	        }

	        st[i] = x;  // Insert the item into the found empty slot

	        // Check if the load factor is greater than or equal to 0.5, and if so, expand the array
	        if (N++ >= M / 2) {
	            expand();
	        }
	    }
	}



}
