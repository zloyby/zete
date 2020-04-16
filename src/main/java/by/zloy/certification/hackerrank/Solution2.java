package by.zloy.certification.hackerrank;

import java.util.Scanner;

@SuppressWarnings("ALL")
public class Solution2 {

    public static class LinkedListNode {
        int val;
        LinkedListNode next;

        LinkedListNode(int node_value) {
            val = node_value;
            next = null;
        }
    }

    public static LinkedListNode listAdd(LinkedListNode head, LinkedListNode tail, int val) {
        if (head == null) {
            head = new LinkedListNode(val);
            tail = head;
        } else {
            tail.next = new LinkedListNode(val);
            tail = tail.next;
        }
        return tail;
    }

    public static void printList(LinkedListNode head) {
        LinkedListNode iter = head;
        while (iter != null) {
            System.out.print(iter.val + " ");
            iter = iter.next;
        }
    }

    static LinkedListNode removeAll(int n, LinkedListNode head) {
        LinkedListNode nextNode = head.next;

        if (nextNode == null) {
            // One element
            return head.val == n ? null : head;
        }

        if (head.val == n) {
            // Head should be removed, mark next element as head
            return removeAll(n, nextNode);
        } else {
            // Iterate next
            if (nextNode.next != null) {
                if (nextNode.val == n) {
                    head.next = removeAll(n, nextNode.next);
                } else {
                    head.next = removeAll(n, nextNode);
                }
            } else {
                // Last element
                if (nextNode.val == n) {
                    head.next = null;
                }
            }

            return head;
        }
    }

    // 2 2 1 2 -->> 1
    // 2 5 1 2 3 4 5 -->> 1 3 4 5
    // 2 8 2 1 2 3 4 7 2 5 2 -->> 1 3 4 7 5
    // 2 8 2 2 2 2 2 7 2 5 2 -->> 7 5
    // 2 6 2 2 1 2 3 2 9 9 9 9 9 -->> 1 3 (as size=6, all 9 skipped)
    // 2 7 2 2 1 2 3 2 9 9 9 9 9 -->> 1 3 9
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int size = in.nextInt();
        int i, item;
        LinkedListNode head = null, tail = null;
        for (i = 0; i < size; i++) {
            item = in.nextInt();
            tail = listAdd(head, tail, item);
            if (i == 0) {
                head = tail;
            }
        }
        head = removeAll(n, head);
        printList(head);
    }
}