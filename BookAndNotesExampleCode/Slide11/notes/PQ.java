package notes;


public class PQ 
{
	
    private ITEM[] pq;  // Priority queue array
    private int N;      // Number of elements in the priority queue

    // Constructor to initialize the priority queue with a given maximum size
    PQ(int maxN) 
    {
        pq = new ITEM[maxN + 1];  // Index 0 is not used, so allocate maxN + 1
        N = 0;  // Initially, the priority queue is empty
    }

    // Method to check if element at index i is less than element at index j
    private boolean less(int i, int j) 
    {
        return pq[i].less(pq[j]);
    }

    // Method to exchange elements at indices i and j
    public void exch(int i, int j) 
    {
        ITEM t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    // Method to move the element at index k up to maintain heap order
    public void swim(int k) // Method for "swimming" up the heap from a given index k
    {
        while (k > 1 && less(k / 2, k)) // Continue swimming if the current node is greater than its parent (at index k/2)
        {
            exch(k / 2, k); // Exchange the current node with its parent
            k = k / 2; // Move up to the parent index
        }
    }


    // Method to move the element at index k down to maintain heap order
    public void sink(int k, int N) // Method for "sinking" down the heap from a given index k with a heap size N
    {
        while (2 * k <= N) // Continue sinking while the current node has at least one child
        {
            int j = 2 * k; // Set j to the index of the left child of the current node
            if (j < N && less(j, j + 1)) // If there is a right child and it is greater than the left child
            {
                j++; // Move j to the index of the right child
            }
            if (!less(k, j)) // If the current node is not less than its greater child
            {
                break; // Break out of the loop, as the heap property is satisfied
            }
            exch(k, j); // Exchange the current node with its greater child
            k = j; // Move down to the child index
        }
    }


    // Method to check if the priority queue is empty
    boolean empty() 
    {
        return N == 0;
    }

    // Method to insert an element into the priority queue
    void insert(ITEM v) 
    {
        pq[++N] = v;
        swim(N);
    }

    // Method to get and remove the maximum element from the priority queue
    ITEM getmax() 
    {
        exch(1, N);
        sink(1, --N);
        return pq[N + 1];
    }
	

	// Method to sort an array 'a' using a priority queue (PQ)
	static void sort(ITEM[] a, int p, int r) //me pinaka
	{
	    int k;

	    // Create a priority queue with a capacity equal to the range size
	    PQ pq = new PQ(r - p + 1);

	    // Insert each element from the array into the priority queue
	    for (k = p; k <= r; k++) 
	    {
	        pq.insert(a[k]);
	    }

	    // Retrieve the maximum element from the priority queue and put it back into the array
	    // This effectively sorts the array in descending order
	    for (k = r; k >= p; k--) 
	    {
	        a[k] = pq.getmax();
	    }
	}

	static void heapsort(ITEM[] a) 
	{
	    int N = a.length - 1; // Adjust N to the array size

	    // Create a priority queue with a capacity equal to the range size
	    PQ pq = new PQ(N);
	    // Convert 'a' into a heap using the sink operation
	    for (int k = N / 2; k >= 1; k--) 
	    {
	    	pq.sink( k, N);
	    }

	    // Retrieve the maximum element from the heap and put it back into the array
	    // This effectively sorts the array in descending order
	    while (N > 1) 
	    {
	    	pq.exch(1, N);
	    	pq.sink(1, --N);
	    }
	}

}


////extra code and test class

//Item class implementing ITEM interface
class Item2 implements ITEM 
{
 private int value;

 public Item2(int value) {
     this.value = value;
 }

 public int getValue() {
     return value;
 }

 @Override
 public boolean less(ITEM other) {
     if (!(other instanceof Item2)) {
         throw new IllegalArgumentException("Cannot compare with a different type.");
     }
     Item2 otherItem = (Item2) other;
     return this.value < otherItem.value;
 }

 // Add other methods if needed
}

class TestPQ 
{
 public static void main(String[] args) {
     // Create an array of items for testing
     ITEM[] items = {
         new Item2(5),
         new Item2(3),
         new Item2(8),
         new Item2(2),
         new Item2(7)
         // Add more items as needed
     };

     // Display original array
     System.out.println("Original Array:");
     displayItems(items);

     // Test sort method
     PQ.sort(items, 0, items.length - 1);
     System.out.println("\nAfter Sorting with PQ.sort:");
     displayItems(items);

     // Create a new array of items for testing heapsort
     ITEM[] itemsForHeapsort = 
    {
         new Item2(5),
         new Item2(3),
         new Item2(8),
         new Item2(2),
         new Item2(7)
         // Add more items as needed
     };

     // Display original array for heapsort
     System.out.println("\nOriginal Array for Heapsort:");
     displayItems(itemsForHeapsort);

     // Test heapsort method
     PQ.heapsort(itemsForHeapsort);
     System.out.println("\nAfter Sorting with Heapsort:");
     displayItems(itemsForHeapsort);
 }

 // Helper method to display items in an array
 private static void displayItems(ITEM[] items) {
     for (ITEM item : items) {
         System.out.print(((Item2) item).getValue() + " ");
     }
     System.out.println();
 }
}


