package com.example;

public class Main
{
    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
//        l1.next.next = new ListNode(3);
//        l1.next.next.next = new ListNode(4);
//        l1.next.next.next.next = new ListNode(5);

        ListNode res = solution.removeNthFromEnd(l1, 1);

        while (l1 != null) {
            System.out.print(l1.val);
            l1 = l1.next;
        }
        System.out.println();

        while (res != null) {
            System.out.print(res.val);
            res = res.next;
        }
    }
}
