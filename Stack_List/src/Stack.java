import java.util.EmptyStackException;

public class Stack {
    Node head;

    class Node{
        int value;
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public Stack(){
        head=null;
    }

    public void push(int value){
        Node extraNode = head;
        head=new Node(value,extraNode);
    }

    public int pop(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        Node temp=head;
        head=temp.next;
        return temp.value;
    }

    public boolean isEmpty(){
        return head==null;
    }


}
