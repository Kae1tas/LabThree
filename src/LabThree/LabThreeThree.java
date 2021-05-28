package LabThree;

import java.util.Scanner;


class Node {
    public int value;
    public Node next;

    Node (int value, Node next) {
        this.value = value;
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }
}

public class LabThreeThree {
    static Node headS;
    static Node tailS;

    public static Node createHead(int i) {
        Scanner sc = new Scanner(System.in);
        Node head = null;
        for (; i > 0; i--) {
            head = new Node(i, head);
        }
        return head;
    }

    public static Node createTail(int n) {
        Scanner sc = new Scanner(System.in);
        Node head = new Node(0, null);
        Node tail = head;
        for (int i = 0; i < n - 1; i++) {
            tail.next = new Node(i + 1, null);
            tail = tail.next;
        }
        return head;
    }

    public static Node addFirst(Node oldHead, Node newHead) {
        newHead.next = oldHead;
        return newHead;
    }

    public static Node addLast(Node oldTail, Node newTail) {
        oldTail.next = newTail;
        return newTail;
    }

    public static Node Insert(Node head, Node newNode, int index) {
        Node ref = head;
        int k = 1;
        while (ref.next != null && (k < index)) {
            ref = ref.next;
            k++;
        }
        newNode.next = ref.next;
        ref.next = newNode;
        return head;
    }

    public static Node removeFirst(Node head) {
        return (head = head.next);
    }

    public static Node removeLast(Node head) {
        Node ref = head;
        while (ref.next.next != null) {
            ref = ref.next;
        }
        ref.next = null;
        return head;
    }

    public static Node Remove(Node head, int index) {
        Node ref = head;
        int k = 1;
        while (ref.next != null && (k < index - 1)) {
            ref = ref.next;
            k++;
        }
        ref.next = ref.next.next;
        return head;
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите длину списка:");
        int h = sc.nextInt();
        Node head = createHead(h);
        System.out.println(createHead(h));

        System.out.print("\nВведите длину списка:");
        int t = sc.nextInt();
        System.out.println(createTail(t));

        System.out.print("\nВведите новую голову:");
        System.out.println(addFirst(createHead(h), new Node(sc.nextInt(), null)));

        System.out.print("\nВведите новый хвост:");
        System.out.println(addLast(createHead(h), new Node(sc.nextInt(), null)));

        System.out.println("\nВведите значение элемента для вставки:");
        System.out.println(Insert(createHead(h), new Node(sc.nextInt(), null), 6));

        System.out.println("\nУдаление 1-го элемента списка:\n" + removeFirst(createHead(h)));

        System.out.println("\nУдаление последнего элемента списка:\n" + removeLast(createHead(h)));

        System.out.println("\nВведите значение элемента для удаления:");
        System.out.println(Remove(createHead(h), sc.nextInt()));
    }
}
