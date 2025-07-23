package org.example.linkedList;

import static org.example.linkedList.reverseLinkedListII.printList;

public class removeNthFromEndSolution {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        int n = 2;
        ListNode result = removeNthFromEnd(head, n);
        System.out.println(printList(result));

        ListNode head2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode resultOnePass = removeNthFromEndOnePass(head2, n);
        System.out.println(printList(resultOnePass));
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        int size = getSize(head);

        ListNode curr = dummy;
        for(int i = 0; i< size - n; i++){
            curr = curr.next;
        }

        curr.next = curr.next.next;
        return dummy.next;

    }

    public static int getSize(ListNode head){
        int size = 0;

        while(head !=null ){
            ++ size;
            head = head.next;
        }
        return size;
    }

    public static ListNode removeNthFromEndOnePass(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;

        for(int i = 0; i < n; i++){
            first = first.next;
        }

        while(first != null){
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;
        return dummy.next;
    }
}
