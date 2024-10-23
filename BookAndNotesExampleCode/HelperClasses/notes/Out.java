package notes;

public class Out
{
	public static void print(String s)
	{ 
		System.out.print(s); 
	}
	public static void println(String s)
	{ 
		System.out.println(s); 
	}
	
	public static void  displayRed(String s,int id[], int[] previousId) 
    {
        System.out.println("Vertices");

        for (int i = 0; i < id.length; i++) 
        {
            System.out.print(i + " ");
        }

        System.out.println("\n"+s);

        for (int i = 0; i < id.length; i++) 
        {
            if (id[i] != previousId[i]) 
            {
            	System.out.print("\u001B[31m" + id[i] + "\u001B[0m "); // Make the new change red
            } 
            else 
            {
                System.out.print(id[i] + " ");
            }
        }
    }
	
	public static void  displayRed(String s,int id[], int[] previousId,int size[]) 
    {
        System.out.println("Vertice");

        for (int i = 0; i < id.length; i++) 
        {
            System.out.print(i + " ");
        }

        System.out.println("\n"+s);

        for (int i = 0; i < id.length; i++) 
        {
            if (id[i] != previousId[i]) 
            {
            	System.out.print("\u001B[31m" + id[i] + "\u001B[0m "); // Make the new change red
            } 
            else 
            {
                System.out.print(id[i] + " ");
            }
        }
        System.out.println("\nChildren size");
        for (int i = 0; i < id.length; i++) 
        {
            System.out.print(size[i] + " ");
        }
    }
}
