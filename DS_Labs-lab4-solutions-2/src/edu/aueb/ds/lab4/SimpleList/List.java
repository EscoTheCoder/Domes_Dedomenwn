package edu.aueb.ds.lab4.SimpleList;

import edu.aueb.ds.exceptions.EmptyListException;


/**
 * Single-link List. Uses {@link Node} for list nodes.
 */
public class List implements ListInterface {

    private Node head = null;
    private Node tail = null;

    /**
     * Default constructor
     */
    public List() {
    }

    /**
     * Determine whether list is empty
     *
     * @return true if list is empty
     */
    @Override
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Inserts the data at the front of the list
     *
     * @param data the inserted data
     */
    @Override
    public void insertAtFront(Video data) {
        Node n = new Node(data);

        if (isEmpty()) {
            head = n;
            tail = n;
        } else {
            n.setNext(head);
            head = n;
        }
    }

    /**
     * Inserts the data at the end of the list
     *
     * @param data the inserted item
     */
    @Override
    public void insertAtBack(Video data) {
        Node n = new Node(data);

        if (isEmpty()) {
            head = n;
            tail = n;
        } else {
            tail.setNext(n);
            tail = n;
        }
    }

    /**
     * Returns and removes the data from the list head
     *
     * @return the data contained in the list head
     * @throws EmptyListException if the list is empty
     */
    @Override
    public Video removeFromFront() throws EmptyListException {
        if (isEmpty())
            throw new EmptyListException();

        Video data = head.getData();

        if (head == tail)
            head = tail = null;
        else
            head = head.getNext();

        return data;
    }

    /**
     * Returns and removes the data from the list tail
     *
     * @return the data contained in the list tail
     * @throws EmptyListException if the list is empty
     */
    @Override
    public Video removeFromBack() throws EmptyListException {
        if (isEmpty())
            throw new EmptyListException();

        Video data = tail.getData();

        if (head == tail)
            head = tail = null;
        else {
            Node iterator = head;
            while (iterator.getNext() != tail)
                iterator = iterator.getNext();

            iterator.setNext(null);
            tail = iterator;
        }

        return data;
    }

    /**
     * Returns list as String
     */
    @Override
    public String toString() {
        if (isEmpty()) {
            return "List is empty :(";
        }

        Node current = head;

        StringBuilder ret = new StringBuilder();

        // while not at end of list, output current node's data
        ret.append("\n\n HEAD -> ");

        while (current != null) {
            ret.append(current.data);

            if (current.getNext() != null)
                ret.append(" -> ");

            current = current.next;
        }

        ret.append(" <- TAIL");

        return ret.toString();
    }
    
    /**
     * Sorts the list
     *
     * @param comparator
     */
    @Override
    public void sort(VideoComparator comparator) {

        // No need to sort if list is empty or has a single element
        if (head == null || head == tail)
            return;

        Node newHead = null;
        Node newTail = null;

        while (head != null) {
            // get next item
            Node tmp = head;

            // move head
            head = head.getNext();

            // move swap to new-sorted list
            if (newHead == null) {
                newHead = newTail = tmp;
                tmp.setNext(null);
            } else {
                Node prev = null;
                Node iterator = newHead;

                // iterate newList until we get to a point where our data is smaller or reach the end
                while (iterator != null && comparator.compare(iterator.getData(), tmp.getData()) >= 0) {
                    prev = iterator;
                    iterator = iterator.getNext();
                }

                // reached the point where we should place the node

                // if prev == null then its the head of the list
                if (prev == null)
                    newHead = tmp;
                else
                    prev.setNext(tmp);

                // if iterator == null then its the tail of the list
                tmp.setNext(iterator);
                if(iterator == null)
                    newTail = tmp;
            }
        }

        head = newHead;
        tail = newTail;
    }    
}
