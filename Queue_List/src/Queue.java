import java.util.NoSuchElementException;

public class Queue {
    Node head;
    Node tail;

    class Node{
        int item;
        Node next;
        public Node(int item) {
            this.item = item;
            next=null;
        }
    }
    public Queue(int n) {
        head = null;
        tail = null;
    }
    public boolean isEmpty(){
        return head==null;
    }
    public void enqueue(int item){
        Node temp=new Node(item);
        if(isEmpty()){
            head=temp;
        }
        else{
            tail.next=temp;
        }
        tail=temp;
    }
    public int dequeue(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        int value=head.item;
        head=head.next;
        if(head==null){
            tail=null;
        }
        return value;
    }
}
