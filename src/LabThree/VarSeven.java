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
        int indexMin = 0;
        int valueMax = 0; //head.value
        int valueMin = 2147483647;
        int index = 0;

        while(ref != null) {
            index++;
            if (ref.value > valueMax && (ref.value % 3 == 0)) {
                valueMax = ref.value;
                indexMax = index;
            }
            if (ref.value < valueMin && (ref.value % 3 == 0)) {
                valueMin = ref.value;
                indexMin = index;
            }
            //System.out.println(valueMax);
            ref = ref.next;
        }


        Node newNodeMax = new Node(valueMax, null);
        Node newNodeMin = new Node(valueMin, null);
        ref = head;
        index = 1;
        while (ref.next != null && (index < indexMin - 1)) {
            ref = ref.next;
            index++;
        }

        if(indexMin == 1){      //insert instead of first
            newNodeMax.next = head.next;
            head = newNodeMax;
        }
        else if(indexMin == n){     //insert instead of last
            ref = head;
            while (ref.next.next != null) {
                ref = ref.next;
            }
            ref.next = newNodeMax;
        }
        else
            newNodeMax.next = ref.next.next;
            ref.next = newNodeMax;


        ref = head;
        index = 1;

        while (ref.next != null && (index < indexMax - 1)){
            ref = ref.next;
            index++;
        }

        if (indexMax == 1){
            newNodeMin.next = head.next;
            head = newNodeMin;
        }
        else if(indexMax == n){
            ref = head;
            while (ref.next.next != null){
                ref = ref.next;
            }
            ref.next = newNodeMin;
        }
        else{
            newNodeMin.next = ref.next.next;
            ref.next = newNodeMin;
        }


        System.out.println("\nНомер наибольшего:" + indexMax + "\nЧисло:" + valueMax + "\n\nНомер наименьшего:" + indexMin + "\nЧисло:" + valueMin);
        System.out.println(head);
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
