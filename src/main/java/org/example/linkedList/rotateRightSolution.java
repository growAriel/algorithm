package org.example.linkedList;


import static org.example.linkedList.reverseLinkedListII.printList;

public class rotateRightSolution {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        int k = 2;
        ListNode result = rotateRight(head, k);
        System.out.println(printList(result)); // Assuming printList is a method to print the linked list
    }
    public static ListNode rotateRight(ListNode head, int k) {
        ListNode dummy =  new ListNode(0, head);
        int size = getSize(head);
        k= k%size;

        ListNode first = head;
        ListNode second = head;
        for(int i = 0; i< k; i++){
            first = first.next;
        }

        while(first.next !=null){
            first = first.next;
            second = second.next;
        }

        first.next = dummy.next;
        dummy.next = second.next;
        second.next = null;

        return dummy.next;
    }

    public static int getSize(ListNode head){
        int size = 0;
        while(head!=null){
            ++size;
            head=head.next;
        }
        return size;
    }
}
