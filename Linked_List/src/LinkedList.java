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

    public Node delete(Object x){ //paradeigma x = 3
        int pos = 0;
        boolean flag = false;

        if(head==null){
            System.out.println("To stoixeio den vrethike");
            return null;
        }

        if(head.data == x){
            System.out.println("To stoixeio vrethike sthn thesh "+ pos);
            head = head.next;
            return head;
        }

        Node temp = head;
        while(temp.next!=null){
            if(temp.next.data==x){
                System.out.println("To stoixeio vrethike sthn thesh "+ ++pos);
                flag = true;
                temp.next = temp.next.next;
                break;
            }
            pos++;
            temp = temp.next;
        }
        if(!flag){
            System.out.println("To stoixeio den vrethike");
        }
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

    public Object findmax(){
        if(head==null){
            return null;
        }
        Object max = head.data;
        Node curr = head.next;
        Node prev = null;
        while(curr!=null){
            if((int)curr.data>(int)max){
                max=curr.data;
            }
            curr=curr.next;
        }
        curr=head;
        while(curr.data!=max && curr.next!=null){
            prev=curr;
            curr=curr.next;
        }
        prev.next=curr.next;
        curr.next=head;
        head.next=curr;

        return max;
    }

    public void show(){
        Node node = head;
        while(node.next!=null){
            System.out.print(node.data+"->");
            node=node.next;
        }
        System.out.print(node.data+"->null");
        System.out.println();
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

    Node search(int x){
        if(head==null){
            return null;
        }
        if((int)head.data==x){
            Node temp = head;
            head = head.next;
            temp.next = null;
            return temp;
        }

        Node curr = head.next;
        Node prev = null;
        while(curr != null && (int)curr.data<x){
            prev = curr;
            curr = curr.next;
        }
        if(curr != null && (int)curr.data==x){
            prev.next=curr.next;
            curr.next=null;
            return curr;
        }
        return null;
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
