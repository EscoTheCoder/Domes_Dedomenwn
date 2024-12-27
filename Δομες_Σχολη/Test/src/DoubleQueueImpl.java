import java.io.PrintStream;
import java.util.NoSuchElementException;

public class DoubleQueueImpl<T> implements DoubleQueue<T>{

    Node<T> head;
    Node<T> tail;
    int length;


    @Override
    public boolean isEmpty() {
        return head==null;
    }

    @Override
    public void put(T item) {
        Node<T> temp=new Node<>(item);
        if(isEmpty()){
            head=temp;
        }
        else{
            tail.setNext(temp);
        }
        tail=temp;
        length++;
    }

    @Override
    public T get() throws NoSuchElementException {
        if(isEmpty()){
            throw new NoSuchElementException("PAS NA AFAIRESEIS APO ADEIA QUEUE");
        }
        T value=head.getData();
        head=head.getNext();
        if(head==null){
            tail=null;
        }
        length--;
        return value;
    }

    @Override
    public T peek() throws NoSuchElementException {
        if(isEmpty()){
            throw new NoSuchElementException("PAS NA AFAIRESEIS APO ADEIA QUEUE");
        }
        return head.getData();
    }

    @Override
    public void printQueue(PrintStream stream) {
        Node<T> node = head;

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
