package codelearn.leetcode;

public class DoubleNumberRepresentedLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(9);
        head.next = new ListNode(9);
        head.next.next = new ListNode(9);
        DoubleNumberRepresentedLinkedList doubleNumberRepresentedLinkedList = new DoubleNumberRepresentedLinkedList();
        ListNode temp = doubleNumberRepresentedLinkedList.doubleIt(head);

        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }
    public ListNode doubleIt(ListNode head) {
        int carry = getNumber(head);
        if (carry != 0) {
            ListNode result = new ListNode(carry);
            result.next = head;
            return result;
        }
        return head;
    }

    private int getNumber(ListNode node) {
        if (node == null) {
            return 0;
        }
        int carry = getNumber(node.next);
        int sum = node.val * 2 + carry;
        node.val = sum % 10;
        return sum / 10;
    }

    private String multiTwoStringNumber(StringBuilder originalNumber, char c) {
        String number = originalNumber.toString();
        int m = c - '0';
        StringBuilder result = new StringBuilder();
        int carry = 0;
        for (int i = number.length() - 1; i >= 0; i--) {
            int digit = number.charAt(i) - '0';
            digit = digit * m + carry;
            result.append(digit % 10);
            carry = digit / 10;
        }
        if (carry != 0) {
            result.append(carry);
        }
        return result.reverse().toString();
    }

    private void buildListNode(ListNode node, String numberStr, int i) {
        if (i >= numberStr.length())
            return;
        if (node != null) {
            node.val = numberStr.charAt(i) - '0';
            if (node.next == null && i + 1 < numberStr.length()) {
                node.next = new ListNode(0);
            }
            buildListNode(node.next, numberStr, i + 1);
        }
    }


}
