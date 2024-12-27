import java.io.PrintStream;
import java.util.NoSuchElementException;

public class StringStackImpl<T> implements StringStack<T>{

    private Node<T> top;
    private int length;

    

    public StringStackImpl(){
        top=null;
        length=0;
    }


    @Override
    public boolean isEmpty() {
        return length==0;
    }

    @Override
    public void push(T item) {
        
        
        Node<T> newNode = new Node<>(item);
        newNode.setNext(top);
        top=newNode;
        length++;
    }

    @Override
    public T pop() throws NoSuchElementException {
        if(isEmpty()){
            throw new NoSuchElementException("Stack is Empty.");
        }
        T result = top.getData();
        top = top.getNext();
        length--;
        return result;
    }

    @Override
    public T peek() throws NoSuchElementException {
        if(isEmpty()){
            throw new NoSuchElementException("No element stack is empt");
        }
        return top.getData();
    }

    @Override
    public void printStack(PrintStream stream) {
        Node<T> node = top;

        while(node != null){
            if(node.getNext() == null) {
                stream.print(node.getData());
            } else {
                stream.print(node.getData() + "->");
            }
            node = node.getNext();
        }
        stream.print("\n");
        
    }

    @Override
    public int size() {
        return length;
    }
}
