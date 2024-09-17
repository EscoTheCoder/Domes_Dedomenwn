import java.io.PrintStream;
import java.util.NoSuchElementException;

public class StringDoubleEndedQueueImpl implements StringDoubleEndedQueue{

    private Node head;
    private Node tail;
    private int length;

    public class Node{
        Node next;
        Node prev;
        String data;

        public Node(String data){
            this.data=data;
        }
    }


    @Override
    public boolean isEmpty() {
        return length==0;
    }

    @Override
    public void addFirst(String item) {
        Node newNode = new Node(item);
        if(isEmpty()){
            tail=newNode;
        }
        else{
            head.prev=newNode;
        }
        newNode.next=head;
        head=newNode;
        length++;
    }

    @Override
    public String removeFirst() throws NoSuchElementException {
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        Node temp=head;
        if(head==tail){
            tail=null;
        }
        else{
            head.next.prev=null;
        }
        head=head.next;
        temp.next=null;
        length--;
        return temp.data;
    }

    @Override
    public void addLast(String item) {
        Node newNode = new Node(item);
        if(isEmpty()){
            head=newNode;
        }
        else{
            tail.next=newNode;
            newNode.prev=tail;
        }
        tail=newNode;
        length++;
    }

    @Override
    public String removeLast() throws NoSuchElementException {
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        Node temp=tail;
        if(head==tail){
            head=null;
        }
        else {
            tail.prev.next = null;
        }
        tail=tail.prev;
        temp.prev=null;
        length--;
        return temp.data;
    }

    @Override
    public String getFirst() {
        return head.data;
    }

    @Override
    public String getLast() {
        return tail.data;
    }

    @Override
    public void printQueue() {
        Node current=head;
        while(current!=null){
            System.out.print(current.data+"-->");
            current=current.next;
        }
        System.out.println("null");
    }

    @Override
    public int size() {
        return length;
    }
}
