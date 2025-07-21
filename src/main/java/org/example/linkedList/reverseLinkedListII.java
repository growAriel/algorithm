package org.example.linkedList;

public class reverseLinkedListII {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int left = 2;
        int right = 4;

        ListNode result = reverseBetweenOnePass(head, left, right);
        System.out.println(printList(result));


        // Example usage of the two-pass method
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next = new ListNode(5);

        int left2 = 2;
        int right2 = 4;
        ListNode result2 = reverseBetween(head2, left2, right2);
        System.out.println(printList(result2));

    }


    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }


        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;

        // Move pre to the node just before the left position
        for(int i = 0; i< left -1; i++){
            pre = pre.next;
        }

        ListNode rightNode = pre;
        for(int i = 0; i < right - left + 1; i++){
            rightNode = rightNode.next;
        }

        // Now pre is at the node before left, and rightNode is at the node at right
        ListNode leftNode = pre.next;
        ListNode curr = rightNode.next;

        pre.next = null; // Disconnect the left part
        rightNode.next = null;

        reverseListedList(leftNode); // Reverse the sublist

        pre.next = rightNode; // Connect the reversed part to the left
        leftNode.next = curr; // Connect the reversed part to the right

        return dummy.next;
    }

    public static void reverseListedList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextTemp = current.next; // Store the next node
            current.next = prev; // Reverse the link
            prev = current; // Move prev to current
            current = nextTemp; // Move to the next node
        }
        head.next = null; // Set the new tail's next to null
    }
    public static String printList(ListNode head) {
        ListNode current = head;
        StringBuilder sb = new StringBuilder();
        while (current != null) {
            sb.append(current.val);
            if (current.next != null) {
                sb.append(" -> ");
            }
            current = current.next;
        }
        return sb.toString();
    }
    public static ListNode reverseBetweenOnePass(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;

        for(int i = 0; i < left -1; i++){
            pre = pre.next;
        }

        ListNode cur = pre.next;
        ListNode next;

        for(int i =0; i < right -left; i++){
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummy.next;
    }
}
