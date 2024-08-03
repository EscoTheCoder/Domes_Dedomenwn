import java.util.EmptyStackException;

class Stack {
    int n;
    Object[] array;
    int top;

    public Stack(int n) {
        if (n < 1) {
            throw new IllegalArgumentException();
        }
        this.n = n;
        array = new Object[n];
        top = 0;
    }

    public void push(Object data) {
        if (data == null)
            throw new IllegalArgumentException();
        if (top == n)
            throw new IllegalStateException();
        array[top++] = data;
    }

    public Object pop() {
        if (top == 0)
            throw new IllegalStateException();
        Object element = array[--top];
        array[top] = null;
        return element;
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public boolean isFull() {
        return top == n;
    }

    public void print(){
        for(int i=0; i<top; i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }
}