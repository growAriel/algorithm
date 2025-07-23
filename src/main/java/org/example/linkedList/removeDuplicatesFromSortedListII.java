package org.example.linkedList;

import static org.example.linkedList.reverseLinkedListII.printList;

public class removeDuplicatesFromSortedListII {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5)))))));
        ListNode result = deleteDuplicates(head);
        System.out.println(printList(result));

        ListNode head2 = new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3)))));
        ListNode result2 = deleteDuplicates(head2);
        System.out.println(printList(result2));
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-200, head);
        ListNode current = dummy;

        while(current.next != null && current.next.next != null) {
            if(current.next.val == current.next.next.val) {
                int duplicateValue = current.next.val;
                while(current.next != null && current.next.val == duplicateValue) {
                    current.next = current.next.next; // Skip all duplicates
                }
            } else {
                current = current.next; // Move to the next node if no duplicates
            }

        }
        return dummy.next;

    }
}
