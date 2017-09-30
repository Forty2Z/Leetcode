package com.forty2leetcode.sep30;


/*
* Leetcode 143: Reorder List
*
*Given a singly linked list L: L0?L1?…?Ln-1?Ln,
*reorder it to: L0?Ln?L1?Ln-1?L2?Ln-2?…
*You must do this in-place without altering the nodes' values.
*分三个步骤， 找到中点，中点之后reverse，然后再merge
*
* */
public class ReorderList {

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;
        ListNode p2 = reverse(slow);
        ListNode p1 = head;
        merge(p1, p2);
    }


    private ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head, next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    private void merge(ListNode l1, ListNode l2) {
        while (l1 != null) {
            ListNode n1 = l1.next, n2 = l2.next;
            l1.next = l2;

            if (n1 == null)
                break;

            l2.next = n1;
            l1 = n1;
            l2 = n2;
        }
    }
}
