public class LinkedList {
    Node head;

    public class Node {
        Object data;
        Node next;

        public Node(Object data) {
            this.data = data;
        }
    }

    public void insertAtEnd(Object data) {
        Node node = new Node(data);

        if (head == null) {
            head=node;
        }
        else{
            Node n = head;
            while(n.next!=null){
                n=n.next;
            }
            n.next=node;
        }
    }

    public void insertAtStart(Object data){
        Node node = new Node(data);
        node.next=head;
        head = node;
    }

    public void insertAt(int index, Object data){
        Node node = new Node(data);

        if(index==0){
            insertAtStart(data);
        }
        else {
            Node n = head;
            for (int i = 0; i < index - 1; i++) {
                n = n.next;
            }
            node.next = n.next;
            n.next = node;
        }
    }

    public void deleteAt(int index){
        if(index==0){
            head=head.next;
        }
        else{
            Node n = head;
            Node n1=null;
            for (int i = 0; i < index - 1; i++) {
                n = n.next;
            }
            n1=n.next;
            n.next=n1.next;
            n1=null; //to diagafoume teleiws apo thn mnhmh
        }
    }

    public Node deleteFirstNode(){
        if(head==null){
            return null;
        }
        Node temp=head;
        head=head.next;
        temp.next=null;
        return temp;
    }

    public Node deleteLastNode(){
        if(head==null || head.next==null){
            return head;
        }
        Node current=head;
        Node previous=null;
        while(current.next!=null){
            previous=current;
            current=current.next;
        }
        previous.next=null;
        return current;
    }

    public void show(){
        Node node = head;
        while(node.next!=null){
            System.out.println(node.data);
            node=node.next;
        }
        System.out.println(node.data);
    }

    public void reverse() {
        if (head == null) {
            return;
        }
        Node current = head;
        Node prev = null;
        Node next_Node = null;

        while (current != null) {
            next_Node = current.next;
            current.next = prev;
            prev = current;
            current = next_Node;
        }
        head = prev;
    }



}
