public class Main {
    public static void main(String[] args) {

        Queue queue = new Queue(5);

        System.out.println(queue.isEmpty());

        queue.enqueue(5);
        queue.enqueue(2);
        queue.enqueue(7);
        queue.enqueue(3);
        queue.enqueue(4);


    }
}