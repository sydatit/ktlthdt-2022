package codelearn.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class RemoveZeroSumConsecutiveNodesLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(-3);
        head.next.next.next.next = new ListNode(-2);
        RemoveZeroSumConsecutiveNodesLinkedList removeZeroSumConsecutiveNodesLinkedList = new RemoveZeroSumConsecutiveNodesLinkedList();
        ListNode result = removeZeroSumConsecutiveNodesLinkedList.removeZeroSumSublists(head);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
    public ListNode removeZeroSumSublists(ListNode head) {
        ArrayList<ListNode> nodes = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        ListNode current = head;
        while (current != null) {
            nodes.add(current);
            current = current.next;
        }
        int[] sum = new int[nodes.size() + 1];
        boolean[] removed = new boolean[nodes.size()];
        sum[0] = 0;
        for (int i = 0; i < nodes.size(); i++) {
            sum[i + 1] = sum[i] + nodes.get(i).val;
        }
        map.put(0, 0);
        System.out.println(nodes);
        System.out.println(Arrays.toString(sum));
        for (int i = 1; i < sum.length; i++) {
            Integer index = map.get(sum[i]);
            if (index != null && !removed[index]) {
                for (int j = index; j < i; j++) {
                    removed[j] = true;
                }
            }
            map.put(sum[i], i);
        }
        System.out.println(Arrays.toString(removed));
        ListNode dump = new ListNode(0);
        current = dump;
        for (int i = 0; i < nodes.size(); i++) {
            if (!removed[i]) {
                current.next = nodes.get(i);
                current = nodes.get(i);
            }
        }
        current.next = null;
        return dump.next;
    }
}
