package codelearn.leetcode;

import java.util.List;

public class PalindromeLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        PalindromeLinkedList palindromeLinkedList = new PalindromeLinkedList();
        System.out.println(palindromeLinkedList.isPalindrome(head));
    }
    public boolean isPalindrome(ListNode head) {
        int size = 0;
        ListNode curr = head;
        while (curr != null) {
            size++;
            curr = curr.next;
        }
        if (size == 1) {
            return true;
        }
        int v = (int) Math.ceil(size/2.0);
        curr = head;
        for (int i = 1; i < v; i++) {
            curr = curr.next;
        }
        ListNode temp = curr.next;
        curr.next = null;
        curr = temp;
        ListNode nextCurr = curr.next;
        curr.next = null;
        ListNode nextNextC = null;
        while (nextCurr != null) {
            nextNextC = nextCurr.next;
            nextCurr.next = curr;
            curr = nextCurr;
            nextCurr = nextNextC;
        }
//        System.out.println( "curr: " + curr);
//        System.out.println( "head: " + head);
        while (curr != null) {
            if (curr.val != head.val) {
                return false;
            }
            curr = curr.next;
            head = head.next;
        }
        return true;
    }
}
