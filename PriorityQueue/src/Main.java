public class Main {
    public static void main(String[] args) {
        MaxPQ pq = new MaxPQ(6);

        pq.insert(20);
        pq.insert(12);
        pq.insert(10);
        pq.insert(6);
        pq.insert(9);
        pq.insert(25);

        System.out.println("Size: " + pq.size());
        System.out.println("Is empty: " + pq.isEmpty());

        while (!pq.isEmpty()) {
            System.out.print(pq.deleteMax() + " ");
        }
        System.out.println();

        // Uncomment to view the heap (should be empty after deletions)
        // pq.printMaxHeap();
    }
}