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

        for(int i=0; i<pq.n; i++){
            System.out.print(pq.deleteMax()+" ");
        }
        System.out.println();

        pq.printMaxHeap();
    }
}