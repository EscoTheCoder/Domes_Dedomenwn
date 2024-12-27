package notes;

import java.util.Arrays;

/*οσα περικλειονται σε ==== ειναι δικα μου για να φαινονται οι αλλαγες.
Χρειαζεται arguments για run, αλλιως Exception*/
public class QuickF
{
	public static void main(String[] args)
	{
		int N = Integer.parseInt(args[0]); // Read the number of elements from the command line
		int id[] = new int[N]; // Create an array to represent connections

		/* =======s======= */
		String s = "Set Id";// δικο μου για καλυτερο Print
		/* =======e======= */

		// Initialize the connections; each element is initially connected to itself
		for (int i = 0; i < N; i++)
		{
			id[i] = i; // Initially, no connections
		}

		/* =======S======= */
		int[] previousId = Arrays.copyOf(id, id.length); // Make a copy of the current id array
		Out.displayRed(s, id, previousId);// Display current id array
		/* =======E======= */

		while (true) // Continue while there is input
		{
			/*=======S=======*/
			previousId = Arrays.copyOf(id, id.length);

			Out.print("\nEnter two numbers with space between them, for the vertices that you want to connect: ");
			int input = In.getInt();

			if (input == -1)
			{
				break;
			}
			/*=======E=======*/
			
			int p = input; // Read the first integer from input
			int q = In.getInt(); // Read the second integer from input

			int temp = id[p];

			if (temp == id[q])
			{
				/*=======S=======*/
				// Make a copy of the current id array
				Out.displayRed(s, id, previousId);
				/*=======E=======*/
				
				
				continue; // If p and q are already connected, move to the next pair
			}

			/* If p and q are not connected, connect all elements in the same group as p to
			 the group of q*/
			for (int i = 0; i < N; i++)
			{
				if (id[i] == temp)
				{
					id[i] = id[q];
				}
			}

			Out.displayRed(s, id, previousId);
			Out.println(" vertices " + p + " and " + q + " are now connected"); // Print the connection (p, q)
		}
	}
}
