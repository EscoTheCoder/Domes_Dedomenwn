package notes;


public class SortingMethods 
{
		
	static void mergesort(ITEM[] a, int p, int r) 
	{
		//System.out.println(p+" "+r);
	    // Base case: If the subarray has 1 or fewer elements, it is already sorted
	    if (r <= p)
	        return;

	    // Calculate the middle index of the subarray
	    int m = (r + p) / 2;
	    
	    // Recursively sort the left and right halve
//	    System.out.println("mergesort1");
	    mergesort(a, p, m);
	    
//	    System.out.println("mergesort2");
	    mergesort(a, m + 1, r);
	    
//	    System.out.println("merge");
    
	    // Merge the sorted halves
	    merge(a, p, m, r); // Merging the sorted subarrays a[p..m] and a[m+1..r]	 
	}
	
	static void mergeAB(ITEM[] out, int p, ITEM[] a, int ap, int ar, ITEM[] b, int bp, int br)
	{
	    // Initialize pointers for scanning the two subarrays
	    int i = ap, j = bp;

	    // Iterate through the merged array
	    for (int k = p; k < p + ar - ap + br - bp + 2; k++) 
	    {
	        // Check if we have reached the end of array 'a'
	        if (i > ar) 
	        {
	            out[k] = b[j++];
	            continue;
	        }

	        // Check if we have reached the end of array 'b'
	        if (j > br) 
	        {
	            out[k] = a[i++];
	            continue;
	        }

	        // Compare elements at indices 'i' and 'j' and choose the smaller one
	        out[k] = a[i].less(b[j]) ? a[i++] : b[j++];
	    	}
	}
	
	static ITEM[] aux;
	static void merge(ITEM[] a, int p, int m, int r) 
	{
	    int i, j;
	    aux = new ITEM[a.length];
	    // Copy the elements of the first half to the auxiliary array in reverse order
	    //den antistrefetai o pinakas edo
	    for (i = m + 1; i > p; i--) 
	    {
	        aux[i - 1] = a[i - 1];//στο τέλος i=p
	    }

	    // Copy the elements of the second half to the auxiliary array in reverse order
	    for (j = m; j < r; j++) 
	    {
	        // Invert the second subarray → edo einai i antistrofi
	        aux[j + 1] = a[r + m - j];//στο τέλος j=r
	    }

	    // Merge the two halves back into the original array
	    for (int k = p; k <= r; k++) 
	    {
	        // Compare elements at indices 'j' and 'i' and choose the smaller one
	        if (aux[j].less(aux[i]) ) 
	        {
	            a[k] = aux[j--];
	        } 
	        else 
	        {
	            a[k] = aux[i++];
	        }
	    }
	}

	static int min(int A, int B) 
	{
	    // Return the minimum of two values
	    return (A < B) ? A : B;
	}

	static void mergesortBU(ITEM[] a, int p, int r) //BottomUp
	{
	    // Base case: If the subarray has 1 or fewer elements, it is already sorted
	    if (r <= p)
	        return;

	    // Create an auxiliary array to facilitate merging
	    aux = new ITEM[a.length];

	    // Perform iterative bottom-up mergesort
	    for (int m = 1; m <= r - p; m = m + m) /* m= 1, 2, 4,… για κάθε m, κάνουμε συγχωνεύσεις m x m, 
	    μέχρι να φτάσουμε στο δεξιό όριο r*/
	    {
	        // For each m, perform merges until reaching the right boundary 'r'
	        for (int i = p; i <= r - m; i += m + m) // Increase the index by 2m in each iteration
	        {
	            
	            merge(a, i, i + m - 1, min(i + m + m - 1, r));
	        }
	    }
	}


	static Node mergesort(Node c) {
	    // Base case: If the list is empty or has only one element, it is already sorted
	    if (c == null || c.next == null)
	        return c;

	    // Initialize pointers for finding the middle of the list
	    Node a = c, b = c.next;

	    // Find the middle of the list using the slow and fast pointer approach
	    while ((b != null) && (b.next != null)) 
	    {
	        c = c.next;
	        b = (b.next).next;
	    }

	    // Split the list into two halves
	    b = c.next;
	    c.next = null;

	    // Recursively sort the two halves and then merge them
	    return merge(mergesort(a), mergesort(b));
	}

	static Node merge(Node a, Node b) {  // Define a static method named merge which takes two Node objects as input parameters and returns a Node.
	    
	    Node dummy = new Node(null);  // Create a dummy Node with null value.
	    
	    Node head = dummy, current = head;  // Create two Node variables head and current, both pointing to the dummy Node initially.

	    while ((a != null) && (b != null))  // Iterate until both a and b are not null.
	    {
	        if (a.item.less(b.item) )  // Compare the values of items in nodes a and b. If the item in a is less than the item in b,
	        {
	            current.next = a;  // Assign the next pointer of current to node a.
	            current = a;  // Move current pointer to node a.
	            a = a.next;  // Move to the next node in list a.
	        } 
	        else  // If item in b is less than or equal to item in a,
	        {
	            current.next = b;  // Assign the next pointer of current to node b.
	            current = b;  // Move current pointer to node b.
	            b = b.next;  // Move to the next node in list b.
	        }
	    }

	    current.next = (a == null) ? b : a;  // If either list a or b has elements remaining, append them to the end of the merged list.

	    return head.next;  // Return the next node after the dummy node, which is the head of the merged list.
	}

	

	///testing
	public class Main 
	{

		static class Item implements ITEM 
	    {
	        private  int value;

	        public Item(int value) 
	        {
	            this.value = value;
	        }

	        @Override
	        public boolean less(ITEM v) 
	        {
	            return this.value < ((Item) v).value;
	        }

	        @Override
	        public String toString() 
	        {
	            return Integer.toString(value);
	        }
	    }

	    public static void main(String[] args) {
	        // Example usage with arrays
	        ITEM[] array1 = {new Item(38), new Item(27), new Item(43), new Item(3), new Item(9), new Item(82), new Item(10)};
	        ITEM[] array2 = {new Item(9), new Item(2), new Item(8), new Item(4)};

	        System.out.println("Before sorting:");
	        printArray(array1);
	        printArray(array2);

	        mergesort(array1, 0, array1.length - 1);
//	        mergesortBU(array2, 0, array2.length - 1);

//	        System.out.println("\nAfter sorting:");
//	        printArray(array1);
//	        printArray(array2);
//
//	        // Example usage with linked list
//	        Node list1 = createSampleLinkedList();
//	        Node list2 = createAnotherSampleLinkedList();
//
//	        System.out.println("\nBefore sorting:");
//	        printLinkedList(list1);
//	        printLinkedList(list2);
//
//	        Node sortedList1 = mergesort(list1);
//	        Node sortedList2 = mergesort(list2);
//
//	        System.out.println("\nAfter sorting:");
//	        printLinkedList(sortedList1);
//	        printLinkedList(sortedList2);
	    }

	    // Helper method to print an array
	    static void printArray(ITEM[] array) 
	    {
	        for (ITEM item : array) 
	        {
	            System.out.print(item + " ");
	        }
	        System.out.println();
	    }

	    // Helper method to print a linked list
	    static void printLinkedList(Node head) 
	    {
	        Node current = head;
	        while (current != null) 
	        {
	            System.out.print(current.item + " ");
	            current = current.next;
	        }
	        System.out.println();
	    }

	    // Helper method to create a sample linked list
	    static notes.Node createSampleLinkedList() 
	    {
	        Node head = new Node(new Item(6));
	        head.next = new Node(new Item(2));
	        head.next.next = new Node(new Item(9));
	        // Add more nodes as needed
	        return head;
	    }

	    // Helper method to create another sample linked list
	    static Node createAnotherSampleLinkedList() 
	    {
	        Node head = new Node(new Item(1));
	        head.next = new Node(new Item(8));
	        head.next.next = new Node(new Item(4));
	        // Add more nodes as needed
	        return head;
	    }
	}

}
