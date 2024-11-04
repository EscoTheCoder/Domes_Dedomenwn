import java.util.EmptyStackException;

public class Stack {
    private Node top;
    private int length;

    class Node{
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public Stack(){
        top=null;
        length=0;
    }

    public void push(int data){
        Node newNode = new Node(data);
        newNode.next=top;
        top=newNode;
        length++;
    }

    public int pop(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        int result = top.data;
        top = top.next;
        length--;
        return result;
    }

    public boolean isEmpty(){
        return length==0;
    }
}
