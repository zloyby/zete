package by.zloy.certification.leetcode;

public class MergeTwoLinkedLists {

    public static void main(String[] args) {
        MergeTwoLinkedLists mergeTwoLinkedLists = new MergeTwoLinkedLists();
        ListNode list1_5 = new ListNode(5);             // 1,1,3,4,5
        ListNode list1_4 = new ListNode(4, list1_5);
        ListNode list1_3 = new ListNode(3, list1_4);
        ListNode list1_2 = new ListNode(1, list1_3);
        ListNode list1_1 = new ListNode(1, list1_2);
        ListNode list2_3 = new ListNode(3);             // 2,2,3
        ListNode list2_2 = new ListNode(2, list2_3);
        ListNode list2_1 = new ListNode(2, list2_2);
        ListNode merged = mergeTwoLinkedLists.mergeTwoLists(list1_1, list2_1);
        System.out.println(merged); // 1,1,2,2,3,3,4,5
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                list1.next = mergeTwoLists(list1.next, list2);
                return list1;
            } else {
                list2.next = mergeTwoLists(list1, list2.next);
                return list2;
            }
        }
        return list2 == null ? list1 : list2;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
