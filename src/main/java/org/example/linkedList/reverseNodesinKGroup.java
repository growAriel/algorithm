package org.example.linkedList;

import static org.example.linkedList.reverseLinkedListII.printList;

public class reverseNodesinKGroup {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        int k = 2;
        ListNode result = reverseKGroup(head, k);
        System.out.println(printList(result));

        ListNode head2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        int k2 = 3;
        ListNode result2 = reverseKGroup(head2, k2);
        System.out.println(printList(result2));
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head;
        }

        ListNode dummy = new ListNode(0, head);
        ListNode prevGroupEnd = dummy;

        while (prevGroupEnd.next != null) {
            ListNode groupStart = prevGroupEnd.next;
            ListNode groupEnd = groupStart;

            // Check if there are k nodes to reverse
            for (int i = 0; i < k - 1 && groupEnd != null; i++) {
                groupEnd = groupEnd.next;
            }

            if (groupEnd == null) {
                break; // Not enough nodes to reverse
            }

            ListNode nextGroupStart = groupEnd.next;
            groupEnd.next = null; // Temporarily end the current group

            // Reverse the current group
            // Connect the previous part with the reversed group
            prevGroupEnd.next =  reverseList(groupStart);

            // Connect the reversed group with the next part
            groupStart.next = nextGroupStart;

            // Move prevGroupEnd to the end of the reversed group
            prevGroupEnd = groupStart;
        }

        return dummy.next;
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode nextTemp = current.next; // Store the next node
            current.next = prev; // Reverse the link
            prev = current; // Move prev to current
            current = nextTemp; // Move to the next node
        }

        return prev; // New head of the reversed list
    }
}

