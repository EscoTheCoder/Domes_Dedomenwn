public class Main {
    public static void main(String[] args) {

        MaxPQ pq = new MaxPQ(5);

        pq.insert(20);
        pq.insert(12);
        pq.insert(10);
        pq.insert(6);
        pq.insert(9);
        pq.insert(25);

        System.out.println(pq.size());
        System.out.println(pq.isEmpty());

//        for(int i=0; i<pq.n; i++){
//            System.out.print(pq.deleteMax()+" ");
//        }
        System.out.println();

        pq.printMaxHeap();
    }
}