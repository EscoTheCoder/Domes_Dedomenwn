import java.util.NoSuchElementException;

public class Doubly_Linked_List {

    private Node head;
    private Node tail;
    private int length;

    private class Node{
        int data;
        Node prev;
        Node next;

        public Node(int data){
            this.data=data;
        }
    }

    public Doubly_Linked_List(){
        this.head=null;
        this.tail=null;
        this.length=0;
    }

    public boolean isEmpty(){
        return length==0;
    }

    public int getLength(){
        return length;
    }

    public void displayListForward(){
        if(head==null){
            return;
        }
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data + "-->");
            temp=temp.next;
        }
        System.out.println("null");
    }
    public void displayListBackward(){
        if(tail==null){
            return;
        }
        Node temp=tail;
        while(temp!=null){
            System.out.print(temp.data + "-->");
            temp=temp.prev;
        }
        System.out.println("null");
    }

    public void insertFirst(int data){
        Node newNode = new Node(data);
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

    public void insertLast(int data){
        Node newNode = new Node(data);
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

    public void insertAtPosition(int data, int pos) {
        if (pos < 1 || pos > length) {
            throw new IndexOutOfBoundsException("Invalid position");
        }
        Node newNode = new Node(data);
        if (pos == 1) {
            insertFirst(data);
            return;
        }
        Node temp = head;
        // Traverse to the node just before the desired position
        // Insert the new node
        for (int i = 1; i < pos-1; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        newNode.prev = temp;
        if (temp.next != null) {
            temp.next.prev = newNode;
        }
        temp.next = newNode;
        if (newNode.next == null) {
            tail = newNode; // Update tail if inserted at the last position
        }
        length++;
    }

    public Node deleteFirst(){
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
        return temp;
    }

    public Node deleteLast(){
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
        return temp;
    }

    public Node deleteAtPosition(int position) {
        if (position < 1 || position > length) {
            throw new IndexOutOfBoundsException();
        }

        Node temp=head;

        if (position == 1) {
            return deleteFirst();
        }

        if (position == length) {
            return deleteLast();
        }

        for (int i = 1; i < position; i++) {
            temp = temp.next;
        }

        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;

        temp.next = null;
        temp.prev = null;
        length--;

        return temp;
    }
}
