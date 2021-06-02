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

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите длину списка:");
        int n = sc.nextInt();
        Node head = createHead(n);
        System.out.println(head);

        sumAndAverage(head);


    }
}
