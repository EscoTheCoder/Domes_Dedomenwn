package notes;

class CharStack 
{
    private char[] s;
    private int N;

    // Constructor to initialize the stack
    CharStack(int maxN) 
    {
        s = new char[maxN];
        N = 0;
    }

    // Check if the stack is empty
    boolean isEmpty() 
    {
        return (N == 0);
    }

    // Push a character onto the stack
    void push(char item) 
    {
        s[N++] = item;
    }

    // Pop a character from the stack
    char pop() 
    {
        return s[--N];
    }
}

