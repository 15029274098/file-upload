package com.company.linkedlist.两两交换链表节点24.递归;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // Nodes to be swapped
        ListNode firstNode = head;
        ListNode secondNode = head.next;

        //swapped
        firstNode.next = swapPairs(secondNode.next);
        secondNode.next = firstNode;
        // Return the new head node.
        return secondNode;
    }
}
