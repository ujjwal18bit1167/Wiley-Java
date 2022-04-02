package multithreading;

// class Node {
//     int data;
//     Node next;

//     Node(int data) {
//         this.data = data;
//     }
// }

class LinkedList1 {
    static Node head;
    static class Node{
        int data;
        Node next;
        Node(int data)
        {
            this.data = data;
             
        }
    }

    Node reverse(Node head)
    {
        Node prev = null;
        Node current = head;
        Node next = null;
        while(current!=null)
        {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;

        }
        head = prev;
        return head;

    }



}

public class LinkedListReverse {

    

    public static void main(String[] args) {
        LinkedList1 list = new LinkedList1();
        
        

    }
}
