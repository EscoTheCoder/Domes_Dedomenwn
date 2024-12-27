package notes;
import java.util.Arrays;


public class Slides9 
{
	static void quicksort(ITEM[] a, int p, int r)
	{
	    // Base case: If the array has 0 or 1 elements, it is already sorted
	    if (r <= p)
	        return;

	    // Partition the array and place the pivot element in its correct position (a[i])
	    int i = partition(a, p, r);

	    // Recursively sort the subarray to the left of the pivot
	    quicksort(a, p, i - 1);

	    // Recursively sort the subarray to the right of the pivot
	    quicksort(a, i + 1, r);
	}

	static int partition(ITEM a[], int p, int r)
	{
	    // Initialize variables for partitioning
	    int i = p - 1, j = r;
	    ITEM v = a[r]; // Pivot element

	    // Infinite loop for partitioning
	    for (;;)
	    {
	        // Find the first element greater than or equal to the pivot from the left
	        while (Sort.less(a[++i], v)) ; // i does not go beyond the array bounds

	        // Find the first element smaller than or equal to the pivot from the right
	        while (Sort.less(v, a[--j]))
	        {
	            if (j == p) // Break if j reaches the start of the array
	                break;
	        }

	        // Break the loop if indices i and j cross each other
	        if (i >= j)
	            break;

	        // Swap elements at indices i and j
	        Sort.exch(a, i, j);
	    }

	    // Swap pivot element into its correct position
	    Sort.exch(a, i, r);

	    // Return the index of the pivot element
	    return i;
	}

	static void sort(ITEM a[], int p, int r)
	{
	    // Perform quicksort on the array
	    quicksort(a, p, r);

	    // The array is partially sorted at this point
	    // Perform insertionsort to finalize the sorting
	    Sort.insertion(a, p, r);
	}

	static void quicksort_Stack(ITEM[] a, int p, int r)
	{
	    // Create an integer stack for storing indices
		ΙntStack S = new ΙntStack(2 * (r - p + 1)); // N = r - p + 1

	    // Initialize the stack with the initial indices
	    S.push(p);
	    S.push(r);

	    // Continue until the stack is empty
	    while (!S.isEmpty())
	    {
	        // Pop the indices from the stack
	        r = S.pop();
	        p = S.pop();

	        // Check if the subarray has one or zero elements
	        if (r <= p)
	            continue;

	        // Partition the array and get the pivot index
	        int i = partition(a, p, r);

	        // Choose the smaller subarray and push its indices onto the stack
	        if (i - p > r - i)
	        {
	            S.push(p);
	            S.push(i - 1);
	        }

	        // Push the indices of the larger subarray onto the stack
	        S.push(i + 1);
	        S.push(r);

	        // Adjust stack for the remaining subarray
	        if (r - i >= i - p)
	        {
	            S.push(p);
	            S.push(i - 1);
	        }
	    }
	}


/////test 
	
	public static void main(String[] args) {
        // Test case 1: Array with random elements
        ITEM[] array1 = {new Item(5), new Item(2), new Item(9), new Item(1), new Item(5), new Item(6)};
        testQuickSort(array1);

        // Test case 2: Empty array
        ITEM[] array2 = {};
        testQuickSort(array2);

        // Test case 3: Array with one element
        ITEM[] array3 = {new Item(42)};
        testQuickSort(array3);

        // Test case 4: Array already sorted
        ITEM[] array4 = {new Item(1), new Item(2), new Item(3), new Item(4), new Item(5)};
        testQuickSort(array4);

        // Test case 5: Array in descending order
        ITEM[] array5 = {new Item(9), new Item(8), new Item(7), new Item(6), new Item(5)};
        testQuickSort(array5);
    }

	private static void testQuickSort(ITEM[] array) {
	    if (array.length == 0) 
	    {
	        System.out.println("Array is empty. Skipping test.");
	        System.out.println("-----------------------");
	        return;
	    }

	    System.out.println("Original Array: " + Arrays.toString(array));

	    // Test quicksort
	    quicksort(array, 0, array.length - 1);
	    System.out.println("Quicksort Result: " + Arrays.toString(array));
	    System.out.println("Is Sorted: " + isSorted(array));

	    // Reset array for quicksort_Stack
	    array = Arrays.copyOf(array, array.length);

	    // Test quicksort_Stack
	    quicksort_Stack(array, 0, array.length - 1);
	    System.out.println("Quicksort_Stack Result: " + Arrays.toString(array));
	    System.out.println("Is Sorted: " + isSorted(array));

	    System.out.println("-----------------------");
	}


	private static boolean isSorted(ITEM[] array) 
	{
		if(array.length==1)
			return true;
	    for (int i = 0; i < array.length - 1; i++)
	    {
	    	
	        // Change the condition to check if the current item is greater than the next item
	    	if (!array[i+1].less(array[i ])) 
	    	{
	            return true;
	        }
	    }
	    return false;
	}


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

	

}
