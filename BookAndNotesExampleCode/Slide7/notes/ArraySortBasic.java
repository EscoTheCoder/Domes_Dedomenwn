package notes;

class ArraySortBasic 
{
    // Sorting elements a[p] to a[r]
    static boolean less(double v, double w) 
    {
        // Check if v is less than w
        return v < w;
    }

    static void exch(double[] a, int i, int j) 
    {
        // Exchange the values at positions i and j in the array
        double t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    static void compExch(double[] a, int i, int j) 
    {
        // Compare and exchange values, assuming i < j
        if (less(a[j], a[i])) 
        {
            exch(a, i, j);
        }
    }

    static void sort(double[] a, int p, int r) 
    {
        // Implementation of Insertion Sort (non-optimized)
        for (int i = p + 1; i <= r; i++) /*This is because the first element (at index p) 
        									is considered already sorted, as there are no elements to its left to compare with*/
        {
            for (int j = i; j > p; j--) 
            {
                // Compare and exchange with the previous element
                compExch(a, j - 1, j);
            }
        }
    }
}


