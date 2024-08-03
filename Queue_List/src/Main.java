public class Main {
    public static void main(String[] args) {

        Queue queue = new Queue(5);

        queue.enqueue(5);
        queue.enqueue(2);
        queue.enqueue(7);
        queue.enqueue(3);
        queue.enqueue(4);


        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());


    }
}