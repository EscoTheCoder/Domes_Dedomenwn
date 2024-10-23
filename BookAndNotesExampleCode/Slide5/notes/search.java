package notes;

class Search
{
	static int sequentialSearch(int a[], int v, int p, int r) 
	{
	    int i;
	    for (i = p; i <= r; i++)
	    {
	        // Check if the current element a[i] is equal to the value v.
	        if (v == a[i])
	        {
	            // If found, return the index i.
	            return i;
	        }
	    }
	    // If the value v is not found in the array, return -1.
	    return -1;
	}
    /*The function search takes an integer array a, a value v to search for, and two integer indices p and r to define the range of the array to search within.
    We declare an integer variable i to use as a loop counter.
    The for loop iterates through the array a from index p to index r.
    Inside the loop, it checks if the current element a[i] is equal to the value v. If a match is found, it returns the index i.
    If the loop completes without finding a match, it returns -1 to indicate that the value v was not found in the array.*/
	
	
	static int binarySearch(int a[], int v, int p, int r)
	{
	    // Non-recursive implementation
	    while (r >= p)
	    {
	        int m = (p + r) / 2;
	        if (v == a[m])
	        {
	            // If the value is found, return the index m.
	            return m;
	        }
	        else if (v < a[m])
	        {
	            // If the value is smaller, update the right bound.
	            r = m - 1;
	        }
	        else
	        {
	            // If the value is larger, update the left bound.
	            p = m + 1;
	        }
	    }
	    // If the value v is not found in the array, return -1.
	    return -1;
	}
	
    /*The search function is a non-recursive implementation of a binary search algorithm.
    It takes an integer array a, a value v to search for, and two integer indices p and r to define the range of the array to search within.
    The function uses a while loop to iteratively narrow down the search range by adjusting the p and r indices.
    Inside the loop, it calculates the middle index m and compares the value v with a[m].
    If the value is found, it returns the index m.
    If the value is smaller than a[m], it updates the right bound r to m - 1.
    If the value is larger than a[m], it updates the left bound p to m + 1.
    If the loop completes without finding a match, it returns -1 to indicate that the value v was not found in the array.*/

}


