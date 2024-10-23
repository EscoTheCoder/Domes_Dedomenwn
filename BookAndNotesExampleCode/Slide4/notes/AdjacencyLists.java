package notes;


class AdjacencyLists 
{
    static class Node 
    {
        int v;
        Node next;

        Node(int v, Node t) 
        {
            this.v = v;
            next = t;
        }
    }

    public static void main(String[] args) 
    {
        int N = Integer.parseInt(args[0]);
        Node adj[] = new Node[N];

        // Initialize the adjacency list with all null values initially
        for (int i = 0; i < N; i++) 
        {
            adj[i] = null;
        }

        for (In.init(); !In.empty();) 
        { 
            int i = In.getInt();
            int j = In.getInt();

            // Insert vertex i into the adjacency list of vertex j
            adj[j] = new Node(i, adj[j]);

            // Insert vertex j into the adjacency list of vertex i
            adj[i] = new Node(j, adj[i]);
        }
    }
}

