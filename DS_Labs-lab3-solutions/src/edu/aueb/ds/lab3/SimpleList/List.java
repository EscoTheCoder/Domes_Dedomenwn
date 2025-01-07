package edu.aueb.ds.lab3.SimpleList;

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
        return head==null;
    }

    /**
     * Inserts the data at the front of the list
     *
     * @param data the inserted data
     */
    @Override
    public void insertAtFront(int data) {
        Node newNode = new Node(data);

        if(isEmpty()){
            head = newNode;
            tail = newNode;
        }
        else{
            newNode.next = head;
            head = newNode;
        }
    }

    /**
     * Inserts the data at the end of the list
     *
     * @param data the inserted item
     */
    @Override
    public void insertAtBack(int data) {
        Node newNode = new Node(data);

        if(isEmpty()){
            head = newNode;
            tail = newNode;
        }
        else{
            tail.next = newNode;
            tail = newNode;
        }
    }

    /**
     * Returns and removes the data from the list head
     *
     * @return the data contained in the list head
     * @throws EmptyListException if the list is empty
     */
    @Override
    public int removeFromFront() throws EmptyListException {
        if(isEmpty()){
            throw new EmptyListException();
        }
        int temp = head.data;

        if (head == tail)
            head = tail = null;
        else
            head = head.next;

        return temp;
    }

    /**
     * Returns and removes the data from the list tail
     *
     * @return the data contained in the list tail
     * @throws EmptyListException if the list is empty
     */
    @Override
    public int removeFromBack() throws EmptyListException {
        if(isEmpty()){
            throw new EmptyListException();
        }
        int temp = tail.data;

        if (head == tail) { // Only one element in the list
            head = tail = null;
        }
        else {
            Node iterator = head;
            while (iterator.next != tail) { // Traverse to the second-to-last node
                iterator = iterator.next;
            }
            iterator.next = null; // Remove the last node
            tail = iterator; // Update tail
        }

        return temp;
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
        ret.append(" HEAD -> ");

        while (current != null) {
            ret.append(current.data);

            if (current.getNext() != null)
                ret.append(" -> ");

            current = current.next;
        }

        ret.append(" <- TAIL");

        return ret.toString();
    }
}
