package notes;

//exei kai tiw upoloipes parakato
class Sort 
{
    // Method to check if item v is less than item w
    static boolean less(ITEM v, ITEM w) 
    { 
        return v.less(w); 
    }

    // Method to exchange items at positions i and j in array a
    static void exch(ITEM[] a, int i, int j) 
    { 
        ITEM t = a[i]; 
        a[i] = a[j]; 
        a[j] = t; 
    }

    // Method to compare and exchange items at positions i and j in array a
    static void compExch(ITEM[] a, int i, int j) 
    { 
        if (less(a[j], a[i])) 
        {
            exch(a, i, j); 
        }
    }

    // Method to sort items in array a from index p to index r using an example method
    static void sort(ITEM[] a, int p, int r) 
    { 
        example(a, p, r); 
    }

    // Example method implementing a sorting algorithm (Insertion Sort)
    static void example(ITEM[] a, int p, int r) 
    { 
        for (int i = p + 1; i <= r; i++) 
        {
            for (int j = i; j > p; j--) 
            {
                // Compare and exchange with the previous element
                compExch(a, j - 1, j); 
            }
        }
    }
    
    
    
    // This is a static method named 'bubble' that performs a bubble sort on an array of items.
    // It takes an array 'a' and two integers 'p' and 'r' as parameters.
    static void bubble(ITEM[] a, int p, int r)
    {
     // The outer loop iterates over the elements of the array from index 'p' to 'r-1'.
    	for (int i = p; i < r; i++)
    	{
    		 // The inner loop iterates in reverse order from 'r' to 'i+1'.
    		for (int j = r; j > i; j--)
    		{
    		     // Within the inner loop, a method 'compExch' is called to compare and exchange
    			// the elements at indices 'j-1' and 'j' if necessary.
    		     compExch(a, j-1, j);
    		}
    	}
    }
    
    static void selection(ITEM[] a, int p, int r) 
    {
        // Iterate through the array
        for (int i = p; i < r; i++) 
        { 
            int min = i; // Assume the current index is the minimum

            // Find the index of the minimum element in the remaining unsorted array
            for (int j = i+1; j <= r; j++)
            {
                if (less(a[j], a[min]))
                    min = j; // Update the index of the minimum element
            }

            // Swap the found minimum element with the element at the current index
            exch(a, i, min);
        }
    }
    
    static void insertion(ITEM[] a, int p, int r) 
    {
    	int i;

    	// Place the minimum at the first position (sentinel)
    	// The loop runs from the right end of the array towards the left
    	// It compares adjacent elements and swaps them if necessary to ensure that the minimum value is at index p
    	for (i = r; i > p; i--)
    	    compExch(a, i - 1, i);

    	// Iterate through the array starting from the third element
    	for (i = p + 2; i <= r; i++) 
    	{ 
    	    int j = i; // Initialize j to the current index i
    	    ITEM v = a[i]; // Store the value of a[i] in v

    	    // Move elements greater than v, one position to the right
    	    // This loop runs until v is greater than or equal to the element at a[j-1]
    	    // It moves elements to the right to make space for v in the correct sorted position
    	    while (less(v, a[j - 1])) 
    	    {
    	        a[j] = a[j - 1]; // Move a[j-1] to the right
    	        j--; // Move to the left
    	    }

    	    // Place v in the correct sorted position
    	    a[j] = v; 
    	}

    }
    
    /*=================sorted linked list======================*/
    private static Node findMax(Node h) 
    {
        // Iterate through the linked list to find the node with the maximum item value
        for (Node t = h; t.next != null; t = t.next)
        {
            if ((int) h.next.data < (int) t.next.data)
                h = t; // Update the reference to the previous node of the maximum
        }

        return h; // Return a pointer to the node before the maximum
    }

    static Node sort(Node h) 
    {
        Node head = new Node(-1, h), out = null;

        // Iterate until the input linked list is empty
        while (head.next != null) 
        {
            Node max = findMax(head); // Find the node before the maximum item value
            Node t = max.next;
            max.next = t.next; // Remove the node with the maximum item from the input list
            
            t.next = out; // Add the removed node to the head of the output list
            out = t; // Update the output list
        }

        return out; // Return the sorted linked list
    }
    /*=======================================*/

}

