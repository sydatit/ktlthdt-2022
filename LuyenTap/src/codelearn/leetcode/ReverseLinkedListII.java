package codelearn.leetcode;

import java.util.Stack;

public class ReverseLinkedListII {
    public static void main(String[] args) {
        ReverseLinkedListII reverseLinkedListII = new ReverseLinkedListII();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(reverseLinkedListII.reverseBetween(head, 4, 5));
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right)
            return head;
        int count = 1;
        Stack<ListNode> stack = new Stack<>();
        ListNode perviousOfLeft = null;
        ListNode nextOfRight = null;
        ListNode current = head;
        while (current != null && count <= right + 1) {
            if (count == left - 1) {
                perviousOfLeft = current;
            }
            if (left <= count && count <= right) {
                stack.push(current);
            }
            if (count == right + 1) {
                nextOfRight = current;
            }
            count++;
            current = current.next;
        }
        stack.forEach(item -> item.next = null);
        ListNode temp = null;
        ListNode top = null;
        while (!stack.isEmpty()) {
            if (temp == null) {
                temp = stack.pop();
                top = temp;
            } else {
                temp.next = stack.pop();
                temp = temp.next;
            }
        }
        if (temp != null)
            temp.next = nextOfRight;

        if (perviousOfLeft != null) {
            perviousOfLeft.next = top;
        } else
            head = top;

        return head;
    }
}
