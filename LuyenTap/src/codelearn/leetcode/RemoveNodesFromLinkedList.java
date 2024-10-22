package codelearn.leetcode;

import java.util.List;
import java.util.Stack;

public class RemoveNodesFromLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.next = new ListNode(3);
        head.next.next = new ListNode(13);
        RemoveNodesFromLinkedList obj = new RemoveNodesFromLinkedList();
        ListNode result = obj.removeNodes(head);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> nodes = new Stack<>();
        while (head != null) {
            while (!nodes.isEmpty() && head.val > nodes.peek().val)
                nodes.pop();
            nodes.push(head);
            head = head.next;
        }
        ListNode dummy = null;
        while (!nodes.isEmpty()) {
            ListNode val = nodes.pop();
            head = dummy;
            dummy.next = head;
        }
        return dummy;
    }
}
