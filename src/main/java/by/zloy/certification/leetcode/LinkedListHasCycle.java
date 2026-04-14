package by.zloy.certification.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LinkedListHasCycle {

    public static void main(String[] args) {
        ListNode l4 = new ListNode(-4);
        ListNode l3 = new ListNode(0);
        ListNode l2 = new ListNode(2);
        ListNode l1 = new ListNode(1);
        l4.next = l2; // cycle there
        l3.next = l4;
        l2.next = l3;
        l1.next = l2;
        System.out.println(hasCycle(l1));
        System.out.println(hasCycle_FloydCycleDetection(l1));
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) return true;
            set.add(head);
            head = head.next;
        }
        return false;
    }

    // Use two pointers: slow moves 1 step, fast moves 2 steps.
    // If there is a cycle, the fast pointer will eventually meet the slow pointer inside the loop.
    public static boolean hasCycle_FloydCycleDetection(ListNode head) {
        ListNode first = head;
        ListNode second = head;
        while (second != null && second.next != null) {
            first = first.next;
            second = second.next.next;
            if (first == second)
                return true;
        }
        return false;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
