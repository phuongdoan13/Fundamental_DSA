package DS2_LinkedList;

public class LinkedList{
    Node head; // the first node of the list

    public void append(int data){
        /*
            Add a new node at the end; O(n)
        */
        if(head == null){
            head = new Node(data);
            return;
        }
        
        Node current = head;
        while(current.next != null){
            current = current.next;
        }
        current.next = new Node(data);

    }

    public void prepend(int data){
        /*
            Add a new node at the start O(1)
        */
        Node newHead = new Node(data, head);
        head = newHead;
    }

    public void deleteNode(int data){
        /*
            Delete a node. O(n)
        */
        // if the list is empty
        if(head == null)
            return;
        
        // if head is the node to delete
        if(head.val == data){
            head = head.next;
            return;
        }
        
        Node curr = new Node(-99999, head);
        while(curr.next != null){
            if(curr.next.val == data){
                curr.next = curr.next.next;
                return;
            }
            curr = curr.next;
        }
        
    }

    public void printLinkedList(){
        /*
            O(n)
        */
        Node curr = head;
        while(curr != null){
            System.out.println(curr.val);
            curr = curr.next;
        }
    }
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.append(0);
        list.append(1);
        list.append(2);
        list.prepend(-9);
        list.deleteNode(-9);
        list.deleteNode(1);
        list.printLinkedList();
    }
}

class Node{
    int val;
    Node next;
    public Node(int val){
        this.val = val;
    }
    public Node(int val, Node next){
        this.val = val;
        this.next = next;
    }
}