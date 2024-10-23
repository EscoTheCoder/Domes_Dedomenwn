package notes;

import java.util.Arrays;

public class CountingSortExample
{
    private static final int M = 10; // Assuming M as the maximum range of input values

    // Function to perform counting sort
    public static void distCount(int a[], int p, int r)
    {
        int i, j;
        int cnt[] = new int[M]; // Array to store counts of occurrences of each element
        int b[] = new int[a.length]; // Temporary array to store sorted elements

        // Initialize the counting array
        for (j = 0; j < M; j++)
        {
            cnt[j] = 0;
        }

        // Count the occurrences of each element in the input array
        for (i = p; i <= r; i++)
        {
            cnt[a[i] + 1]++;
            /*ουσιαστικα αν το περιεχομενο ειναι ιδιο, το Index θα ειναι ιδιο και αρα κανουμε ++ σε 
            αυτο το index. To +1 ειναι για να αντιστοιχει στο σωστο Index επειδη ξεκιναμε απο το 0 */     					
        }

        // Calculate cumulative counts
        for (j = 1; j < M; j++)
        {
            cnt[j] += cnt[j - 1];
        }

        // Reconstruct the sorted array using the counting array
        for (i = p; i <= r; i++)
        {
            b[cnt[a[i]]++] = a[i];
            /*ουσιαστικα βαζουμε την τιμη της αρχικης λιστας στην νεα sorted στο index που προκυπτει
             απο το περιεχομενο της count στο Index a[i] και μετα αυξανουμε αυτο το περιεχομενο της count κατα 1. Αυτο γινεται
             γιατι αν εχουμε καποιον ιδιο αριθμο στην a θα μας παει στο ιδιο Index. Για να μην γινεται αντικατασταση κανουμε αυτο το Increment, 
             ωστε να τον βαλουμε στη επομενη θεση της  sorted  */ 
        }

        // Copy the sorted elements back to the original array
        for (i = p; i <= r; i++)
        {
            a[i] = b[i - p];
        }
    }

    public static void main(String[] args)
    {
        // Example usage
        int[] array = {4, 2, 2, 8, 3, 3, 1};
        System.out.println("Original Array: " + Arrays.toString(array));

        // Perform counting sort on the array
        distCount(array, 0, array.length - 1);

        System.out.println("Sorted Array:   " + Arrays.toString(array));
    }
}

