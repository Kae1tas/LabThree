package dsd_create;

class Node {
    public int value;
    public Node next;

    Node (int value, Node next) {
        this.value = value;
        this.next = next;
    }
}

public class DSD_create {
    public static void main(String[] args) {
        Node head = new Node(0, null);
        Node tail = head;

        for(int i = 0; i < 9; i++) {
            tail.next = new Node(i+1, null);
            tail = tail.next;
        }

        Node ref = head;
        while (ref != null) {
            System.out.print(" " + ref.value);
            ref = ref.next;
        }

        Node newtail = new Node(123, null);
        ref = head;

        while (ref.next != null) {
            ref = ref.next;
        }
        ref.next = newtail;


        Node newNode = new Node(44, null);
        ref = head;
        int k = 1;
        while(ref.next != null && (k<2)) {
            ref = ref.next;
            k++;
        }
        newNode.next = ref.next.next;
        ref.next = newNode;


        head = head.next;
        ref = head;
        k = 1;
        while (ref.next != null && (k < 2)) {
            ref = ref.next;
            k++;
        }

        ref.next = ref.next.next;
    }
}
