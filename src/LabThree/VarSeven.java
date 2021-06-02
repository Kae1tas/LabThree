package LabThree;

import java.util.Scanner;

public class VarSeven {
    public static Node createHead(int i) {
        Scanner sc = new Scanner(System.in);
        Node head = null;
        for (; i > 0; i--) {
            head = new Node(sc.nextInt(), head);
        }
        return head;
    }

    public static void sumAndAverage(Node head) {
        Node ref = head;
        int k = 0;
        int sum = 0;
        while (ref != null) {
            if (ref.value % 3 == 0) {
                k = k + 1;
                sum = sum + ref.value;
                ref = ref.next;
            }
            else {
                ref = ref.next;
            }
        }
        double average = (double)sum/k;
        System.out.println("Сумма:" + sum + "\nКоличество:" + k + "\nСреднее значение:" + average);
    }

    public static void findIndexMaxAndValue (Node head, int n) {
        Node ref = head;
        int indexMax = 0;
        int valueMax = head.value;
        int index = 0;
        while(ref != null) {
            index++;
            if (ref.value > valueMax) {
                valueMax = ref.value;
                indexMax++;
            }
            System.out.println(valueMax);
            ref = ref.next;
        }
        System.out.println("Номер:" + indexMax + "\nЧисло:" + valueMax);
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите длину списка:");
        int n = sc.nextInt();
        Node head = createHead(n);
        System.out.println(head);

        sumAndAverage(head);
        findIndexMaxAndValue(head, n);


    }
}
