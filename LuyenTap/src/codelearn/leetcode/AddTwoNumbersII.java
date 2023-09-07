package codelearn.leetcode;

import java.util.Stack;

public class AddTwoNumbersII {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(7);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(3);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(4);

        l5.next = l6;
        l6.next = l7;

        AddTwoNumbersII addTwoNumbersII = new AddTwoNumbersII();
        ListNode result = addTwoNumbersII.addTwoNumbers(l1, l5);
        while (result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        createStringNumber(l1, sb1);
        createStringNumber(l2, sb2);
        Stack<ListNode> stack = new Stack<>();
        addTwoList(sb1.toString(), sb2.toString(), stack);
        ListNode head = new ListNode(stack.pop().val);
        ListNode cur = head;
        while (!stack.isEmpty()){
            cur.next = new ListNode(stack.pop().val);
            cur = cur.next;
        }
        return head;
    }

    private void addTwoList(String l1, String l2, Stack<ListNode> stack) {
        int i = l1.length() - 1;
        int j = l2.length() - 1;
        int du = 0;
        while ( i >= 0 && j >= 0){
            int a = l1.charAt(i) - '0';
            int b = l2.charAt(j) - '0';
            stack.add(new ListNode((a + b + du) % 10));
            du = (a + b + du) / 10;
            i--;
            j--;
        }
        while ( i >= 0){
            int a = l1.charAt(i) - '0';
            stack.add(new ListNode((a + du) % 10));
            du = (a + du) / 10;
            i--;
        }
        while ( j >= 0){
            int b = l2.charAt(j) - '0';
            stack.add(new ListNode((b + du) % 10));
            du = (b + du) / 10;
            j--;
        }
        if(du > 0)
            stack.add(new ListNode(du));

    }

    private void createStringNumber(ListNode l, StringBuilder sb) {
        if(l == null)
            return;
        sb.append(l.val);
        createStringNumber(l.next, sb);
    }
}
