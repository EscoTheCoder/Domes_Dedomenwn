import java.util.NoSuchElementException;

public class Circular_Singly_Linked_List {
    Node last;
    int length;
    
    public class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public Circular_Singly_Linked_List(){
        last=null;
        length=0;
    }

    public boolean isEmpty(){
        return length==0 && last==null;
    }

    public int getLength(){
        return length;
    }

    public void insertFirst(int data){
        Node temp = new Node(data);
        if(isEmpty()){
            last=temp;
        }
        else{
            temp.next=last.next;
        }
        last.next=temp;
        length++;
    }
    public void insertLast(int data){
        Node temp = new Node(data);
        if(isEmpty()){
            last=temp;
            last.next=last;
        }
        else{
            temp.next=last.next;
            last.next=temp;
            last=temp;
        }
        length++;
    }


    public Node deleteFirst(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        Node temp=last.next;
        if(last.next==last){ //only one node
            last=null;
        }
        else {
            last.next = temp.next;
        }
        temp.next=null;
        length--;
        return temp;
    }

    public Node deleteLast() {
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        Node temp = last;

        if(last.next==last){ // only one node
            last=null;
        }
        else{
            Node current=last.next;
            while (current.next != last) {
                current = current.next;
            }
            current.next = last.next;
            last = current;
        }
        return temp;
    }

    public void show() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        Node first = last.next;
        Node current = first;
        do {
            System.out.print(current.data+"-->");
            current = current.next;
        } while (current != first);
        System.out.println("null");
    }
}
