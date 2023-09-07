package codelearn.leetcode;

public class SplitLinkedListParts {
    public static void main(String[] args) {
        SplitLinkedListParts test = new SplitLinkedListParts();
        ListNode head = new ListNode(1);
        ListNode next = head;
        for (int i = 2; i <= 11; i++) {
            next.next = new ListNode(i);
            next = next.next;
        }
        ListNode[] result = test.splitListToParts(head, 3);
        for (int i = 0; i < result.length; i++) {
            ListNode temp = result[i];
            while (temp != null) {
                System.out.print(temp.val + " ");
                temp = temp.next;
            }
            System.out.println("");
        }
    }
    public ListNode[] splitListToParts(ListNode head, int k) {
        int count = 0;
        ListNode[] result = new ListNode[k];
        int[] sizes = new int[k];
        ListNode temp = head;
        while(temp != null) {
            count++;
            temp = temp.next;
        }
        int size = count / k;
        int adding = count % k;
        for (int i = 0; i < k; i++) {
            sizes[i] = size;
            if (adding > 0) {
                sizes[i]++;
                adding--;
            }
        }
        temp = head;
        for (int i = 0; i < k; i++) {
            ListNode next = head;
            ListNode prev = null;
            while (sizes[i] > 0 && temp != null) {
                prev = temp;
                temp = temp.next;
                sizes[i]--;
            }
            if (prev != null) {
                prev.next = null;
            }
            result[i] = next;
            head = temp;
        }
        return result;
    }
}
