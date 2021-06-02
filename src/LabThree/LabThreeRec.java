package LabThree;

import java.util.Scanner;


public class LabThreeRec {
    public static Node createHeadRec(Node head, int i) {
        if (i > 0) {
            head = new Node(i, head);
            return createHeadRec(head, i - 1);
        }
        return head;
    }

    public static Node createTailRec(Node tail, int n, int i ) {
        if (i < n) {
            tail.next = new Node(i + 1, null);
            tail = tail.next;
            System.out.println(tail);
            return createTailRec(tail, n, i + 1);
        }
        return tail;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите длину списка:");
        Node head = createHeadRec(null, sc.nextInt());
        System.out.print(head);

        System.out.print("\nВведите длину списка:");
        Node tail = createTailRec(new Node(0, null), sc.nextInt(), 0);
        System.out.println(tail);
    }
}
