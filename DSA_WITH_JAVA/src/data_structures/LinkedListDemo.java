package DSA_WITH_JAVA.src.data_structures;

import java.util.NoSuchElementException;

class LinkedList {
    Node head;
    private int mySize;

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;

        }

    }

    void insertAtFirst(int data) {
        Node temp = new Node(data);
        temp.next = head;
        head = temp;
        mySize++;

    }

    void insertAtIndex(int index, int data) {
        if (index >= mySize || index < 0)
            throw new IndexOutOfBoundsException();
        Node myNode = new Node(data);

        if (index == 0) {
            insertAtFirst(data);
        } else {
            Node temp = head;
            Node prev = head;
            int count = 0;

            while (temp != null) {

                if (count == index) {
                    myNode.next = temp;
                    prev.next = myNode;
                    mySize++;

                    break;
                }
                prev = temp;
                temp = temp.next;
                count++;
            }

        }

    }

    void insertAtEnd(int data) {
        if (head == null)
            insertAtFirst(data);
        else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = new Node(data);
            mySize++;

        }

    }

    void traverse() {
        if (head == null)
            throw new NoSuchElementException("Empty");
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public boolean isEmpty() {
        return head == null;

    }

    public int size() {
        if (isEmpty())
            return 0;
        else
            return mySize;
    }

    void deleteFromBeginning() {
        head = head.next;
    }

    void deleteFromEnd() {
        Node curr = head;
        Node prev = head;

        while (curr.next != null) {
            prev = curr;
            curr = curr.next;
        }
        prev.next = null;
    }

    void deleteAtIndex(int index) {
        Node curr = head;
        Node prev = head;
        int count = 0;
        while (curr != null) {
            if (count == index) {
                prev.next = curr.next;
            }
            prev = curr;
            curr = curr.next;
            count++;

        }
    }

}

public class LinkedListDemo {
    public static void main(String[] args) {
        // LinkedList.Node obj = new LinkedList.Node(10);
        LinkedList list = new LinkedList();
        list.insertAtFirst(20);
        list.insertAtFirst(30);
        list.insertAtIndex(1, 40);

        // list.insertAtIndex(-2, 65);
        list.insertAtIndex(0, 25);

        list.insertAtEnd(80);
        list.deleteFromEnd();
        list.traverse();

    }
}
