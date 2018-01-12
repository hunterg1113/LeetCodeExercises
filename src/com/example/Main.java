package com.example;

public class Main
{
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
//        l1.next.next = new ListNode(9);
//        l1.next.next.next = new ListNode(0);
//        l1.next.next.next.next = new ListNode(0);
//        l1.next.next.next.next.next = new ListNode(1);

        ListNode l2 = new ListNode(1);
//        l2.next = new ListNode(8);

        ListNode l3 = solution.addTwoNumbers(l2, l1);

        while (l3 != null) {
            System.out.print(l3.val);
            l3 = l3.next;
        }
    }
}
