package notes;



class JosephusY 
{
    public static void main(String[] args) 
    {
        int N = Integer.parseInt(args[0]); // Total number of people
        int M = Integer.parseInt(args[1]); // Elimination interval
        CircularList L = new CircularList();
        CircularList.Node x = null;

        // Insert N people into the circular list
        for (int i = 1; i <= N; i++) 
        {
            x = L.insert(x, i); // x points to the last inserted node
        }

        while (x != L.next(x)) 
        {
            for (int i = 1; i < M; i++) 
            {
                x = L.next(x);
            }

            L.remove(x);
        }

        // Print the value (the number) of the survivor
        Out.println("Survivor is " + L.val(x));
    }
}
