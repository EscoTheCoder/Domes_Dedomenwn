package notes;

class ΙntStack
{
    private int[] s;
    private int N; // Number of elements in the stack

    // Constructor to initialize the stack with a given maximum size
    ΙntStack(int maxN)
    {
        s = new int[maxN];
        N = 0;
    }

    // Check if the stack is empty
    boolean isEmpty()
    {
        return (N == 0);
    }

    // Push an item onto the stack
    void push(int item)
    {
        s[N++] = item;
    }

    // Pop an item from the stack
    int pop()
    {
        return s[--N];
    }	
}
