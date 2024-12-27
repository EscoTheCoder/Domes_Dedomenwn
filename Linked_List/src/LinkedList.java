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

    public Node insert(Object x) {
        if (head == null) {
            head = new Node(x); // Δημιουργία και ορισμός κεφαλής εάν η λίστα είναι κενή
            return head;
        }

        if ((int)x == (int)head.data) {
            return null; // Δεν επιτρέπουμε διπλές τιμές
        }

        if ((int)x < (int)head.data) {
            // Εισαγωγή πριν από την κεφαλή
            Node newNode = new Node(x);
            newNode.next = head;
            head = newNode;
            return head;
        }

        // Εισαγωγή μετά την κεφαλή
        Node current = head;
        while (current.next != null) {
            if ((int)x == (int)current.next.data) {
                return null; // Δεν επιτρέπουμε διπλές τιμές
            }

            if ((int)x < (int)current.next.data) {
                // Βρέθηκε η σωστή θέση
                Node newNode = new Node(x);
                newNode.next = current.next;
                current.next = newNode;
                return newNode;
            }

            current = current.next; // Μετακίνηση στον επόμενο κόμβο
        }

        // Εισαγωγή στο τέλος
        Node newNode = new Node(x);
        current.next = newNode;
        return newNode;
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

    public Node deleteAt(int index){
        if(index==0){
            deleteFirstNode();
        }
        else{
            Node n = head;
            Node n1=null;
            for (int i = 0; i < index - 1; i++) {
                n = n.next;
            }
            n1=n.next;
            n.next=n1.next;
            return n1;
        }
        return null;
    }

    public Node delete(Object x){
        int pos=0; // gia thn thesh pou tha vrethei o komvos
        Node curr = head;
        Node prev = null;

        if(head==null){
            System.out.println("to stoixeio den uparxei");
            return null;
        }
        if(head.data==x){
            System.out.println("to stoixeio uparxei sthn thesh: "+ pos++);
            head = head.next;
            return head;
        }
        while(curr.data != x){
            if((int)curr.data>(int)x){ //type cast se int gia elegxo
                System.out.println("to stoixeio den uparxei!");
                return head;
            }
            pos++;
            prev=curr;
            curr = curr.next;
        }
        System.out.println("to stoixeio uparxei sthn thesh: " + pos);

        curr = curr.next;
        prev.next=curr;
        return head;
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
        Node currNext = null;

        while (current != null) {
            currNext = current.next;
            current.next = prev;
            prev = current;
            current = currNext;
        }
        head = prev;
    }

    @Override
    public String toString() {
        if (head==null) {
            return "List is empty :(";
        }

        Node current = head;

        StringBuilder ret = new StringBuilder();

        // while not at end of list, output current node's data
        ret.append(" HEAD -> ");

        while (current != null) {
            ret.append(current.data);

            if (current.next != null)
                ret.append(" -> ");

            current = current.next;
        }

        ret.append(" -> null");

        return ret.toString();
    }


}
