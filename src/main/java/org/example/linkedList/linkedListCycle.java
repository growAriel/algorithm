package org.example.linkedList;

public class linkedListCycle {
    public static void main(String[] args) {
        // Example usage
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next; // Creates a cycle

        boolean result = hasCycle(head);
        System.out.println("Does the linked list have a cycle? " + result);

        // Example without cycle
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        System.out.println("Does the linked list have a cycle? " + hasCycle(head2));
    }
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }
}
