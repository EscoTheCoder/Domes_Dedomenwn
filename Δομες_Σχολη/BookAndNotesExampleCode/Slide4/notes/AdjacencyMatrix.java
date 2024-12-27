package notes;



class AdjacencyMatrix 
{
    // Reads edges from input and creates the adjacency matrix for the graph
    public static void main(String[] args) 
    {
        int N = Integer.parseInt(args[0]);
        boolean adj[][] = new boolean[N][N];

        // Initialize the adjacency matrix with all false values (false=0)
        for (int i = 0; i < N; i++) 
        {
            for (int j = 0; j < N; j++) 
            {
                adj[i][j] = false;
            }
        }

        // Set diagonal elements to true (indicating self-connections)
        for (int i = 0; i < N; i++) 
        {
            adj[i][i] = true;
        }

        // Read input edges and update the adjacency matrix
        for (In.init(); !In.empty();) 
        { 
            int i = In.getInt();
            int j = In.getInt();
            adj[i][j] = true;
            adj[j][i] = true;
        }
    }
}
