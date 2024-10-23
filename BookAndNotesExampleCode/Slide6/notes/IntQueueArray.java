package notes;

class IntQueueArray
{
    private int[] q; // Array to store elements of the queue
    private int N, head, tail; // Variables to manage the queue

    // Constructor to initialize the queue with a given maximum size
    IntQueueArray(int maxN) 
    {
        q = new int[maxN + 1]; // Create an array with one extra space to distinguish between full and empty conditions
        N = maxN + 1; // Assign maximum size + 1 to N
        head = N; // Initialize head to N, indicating an empty queue
        tail = 0; // Initialize tail to 0, indicating the first element will be inserted at index 0
    }

    // Check if the queue is empty
    boolean isEmpty() 
    {
        return (head % N == tail); // Queue is empty when head and tail meet
    }

    // Put (enqueue) an item into the queue
    void put(int item) 
    {
        q[tail++] = item; // Insert the item into the queue at tail and increment tail
        tail = tail % N; // Wrap around tail to 0 if it reaches N (to keep it within bounds)
    }

    // Get (dequeue) an item from the queue
    int get() 
    {
        head = head % N; // Wrap around head to 0 if it reaches N (to keep it within bounds)
        return q[head++]; // Retrieve the item from the queue at head and increment head
    }

    public static void main(String[] args) {
        // Create a queue with a maximum size of 5
        IntQueueArray queue = new IntQueueArray(5);

        // Enqueue some elements
        queue.put(10);
        queue.put(20);
        queue.put(30);

        // Dequeue elements and print them
        System.out.println("Dequeueing elements:");
        while (!queue.isEmpty())
        {
            int dequeued = queue.get();
            System.out.println("Dequeued: " + dequeued);
        }

        // Enqueue more elements
        queue.put(40);
        queue.put(50);

        // Dequeue elements again
        System.out.println("\nDequeueing elements again:");
        while (!queue.isEmpty()) {
            int dequeued = queue.get();
            System.out.println("Dequeued: " + dequeued);
        }

        // Test dequeueing from an empty queue
        System.out.println("\nDequeueing from an empty queue:");
        int emptyDequeue = queue.get(); // This should throw an exception
    }
}

