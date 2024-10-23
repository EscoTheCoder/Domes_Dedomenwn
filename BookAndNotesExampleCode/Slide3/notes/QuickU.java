package notes;

import java.util.Arrays;

/*οσα περικλειονται σε ==== ειναι δικα μου για να φαινονται οι αλλαγες.
Χρειαζεται arguments για run, αλλιως Exception*/
public class QuickU
{
	public static void main(String[] args)
	{
		// το argument μπαινει με δεξι κλικ στο αρχειο της Κλασης->run as->run
		// configurations
		int N = Integer.parseInt(args[0]);
		int id[] = new int[N];

		/* =======s======= */
		String s = "Parent node";
		/* =======e======= */

		// αρχικοποιηση Καθε Node id[i] να ειναι parent του εαυτου του
		for (int i = 0; i < N; i++)
		{
			id[i] = i;
		}

		/* =======s======= */
		int[] previousId = Arrays.copyOf(id, id.length); // Make a copy of the current id array
		Out.displayRed(s, id, previousId);// Display current id array
		/* =======e======= */

		while (true) // Continue while there is input
		{
			/* =======s======= */
			previousId = Arrays.copyOf(id, id.length); // Make a copy of the current id array

			Out.print("\nEnter two numbers with space between them, for the vertices that you want to connect: ");
			int input = In.getInt();

			if (input == -1)
			{
				break;
			}
			/* =======e======= */

			int i, j, p = input, q = In.getInt();

			/*
			 * The loops don't need a body with specific code because the work of finding
			 * the root is done through the initialization, termination, and increment steps
			 * of the loop. This format is concise and suits the purpose of the algorithm.
			 */
			for (i = p; i != id[i]; i = id[i])
			{
				// Find the root of p
			}

			for (j = q; j != id[j]; j = id[j])
			{
				// Find the root of q
			}
			// if they have the same root
			if (i == j)
			{
				/* =======s======= */
				Out.displayRed(s, id, previousId);
				System.out.println("p: " + p + ", q: " + q + " have already the same tree root ->" + i);
				/* =======e======= */

				continue; // They are already connected
			}

			id[i] = j; // Union operation.

			/* =======s======= */
			Out.displayRed(s, id, previousId); // display the array with new connections
			Out.println(" vertices " + p + " and " + q + " have now the same root:" + j); // Print the connection (p, q)
			/* =======e======= */
		}
	}

}
