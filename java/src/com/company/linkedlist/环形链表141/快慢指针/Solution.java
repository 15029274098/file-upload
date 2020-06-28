package com.company.linkedlist.环形链表141.快慢指针;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode a = head;
        ListNode b = head.next;
        while (b != null && b.next != null) {
            if (a == b) {
                return true;
            }
            a = a.next;
            b = b.next.next;
        }
        return false;
    }
}