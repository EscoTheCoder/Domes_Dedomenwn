package notes;

import java.util.Arrays;

public class QuickUWHalf 
{
	public static void main(String[] args)
    {
        // Parse the integer value from the command-line argument
        int N = Integer.parseInt(args[0]);

        // Initialize two arrays: id[] and sz[]
        int id[] = new int[N];
        int sz[] = new int[N];

        /* =======s======= */
        String s="Parent nodes based on children count";
        /* =======s======= */
        
        // Initialize id[] with initial values and sz[] with 1
        for (int i = 0; i < N; i++)
        {
            id[i] = i;
            sz[i] = 1;
        }
        
        /* =======s======= */
        int[] previousId = Arrays.copyOf(id, id.length); // Make a copy of the current id array
        Out.displayRed(s,id, previousId,sz);// Display current id array
        /* =======e======= */
        
        // Loop to read pairs of integers from standard input
        while (true) // Continue while there is input
        {
        	/* =======s======= */
        	previousId = Arrays.copyOf(id, id.length); // Make a copy of the current id array in order to compare it
        	
			Out.print("\nEnter two numbers with space between them, for the vertices that you want to connect: ");
			int input=In.getInt();
			
			if(input==-1)
			{
				break;
			}
			/* =======e======= */
			
			int i, j, p = input, q = In.getInt();
            
			//Weighted Union halving variation
            for (i = p; i != id[i]; i = id[i]) 
            {
            	id[i] = id[id[i]]; /* Halving and path compression by changing every second node to connect with its grandad
            							while finding the root of p*/
            }

            for (j = q; j != id[j]; j = id[j]) 
            {
            	id[j] = id[id[j]]; /* Halving and path compression by changing every second node to connect with its grandad
				while finding the root of q*/
            }
            ///Weighted Union halving
            
            if (i == j) 
            {      
            	/* =======s======= */
            	Out.displayRed(s,id, previousId,sz);
            	System.out.println("p: "+p+", q: "+q+" have already the same tree root ->"+i);
            	/* =======e======= */
            	
                continue; // They are already connected
            }
            /* =======s======= */
            int currentRoot;//δικο μου για εμφανιση της ριζας
            /* =======e======= */
            
         // Check the size of components to decide which one becomes the parent
            if (sz[i] < sz[j])
            {
            	/* =======s======= */
            	currentRoot=j;
            	/* =======e======= */
            	
                id[i] = j;      // Make the root of i's component the root of j's component
                sz[j] += sz[i]; // Update the size of j's component
            }
            else
            {
            	/* =======s======= */
            	currentRoot=i;
            	/* =======e======= */
            	
                id[j] = i;      // Make the root of j's component the root of i's component
                sz[i] += sz[j]; // Update the size of i's component
            }
            
            /* =======s======= */
            Out.displayRed(s,id, previousId,sz);
            Out.println(" vertices " + p + " and " + q +" have now the same root:"+currentRoot); // Print the connection (p, q)
            /* =======e======= */
        }
    }  
}
