package notes;

class Stack 
{
    private Object[] s;
    private int N;

    // Constructor to initialize the stack with a given maximum size
    Stack(int maxN) 
    {
        s = new Object[maxN];
        N = 0;
    }

    // Check if the stack is empty
    boolean isEmpty() 
    {
        return (N == 0);
    }

    // Push an item onto the stack
    void push(Object item) 
    {
        s[N++] = item;
    }

    // Pop an item from the stack
    Object pop() 
    {
        Object t = s[--N];
        s[N] = null; // Clear the reference to the popped item
        return t;
    }
}

