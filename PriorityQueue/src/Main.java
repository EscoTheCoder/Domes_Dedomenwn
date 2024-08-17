public class Main {
    public static void main(String[] args) {

        MaxPQ pq = new MaxPQ(5);

        pq.insert(4);
        pq.insert(5);
        pq.insert(2);
        pq.insert(6);
        pq.insert(1);
        pq.insert(3);

        System.out.println(pq.size());
        System.out.println(pq.isEmpty());

        pq.printMaxHeap();
        System.out.println();

        System.out.println(pq.deleteMax());

        System.out.println();
        pq.printMaxHeap();

    }
}