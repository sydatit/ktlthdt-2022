package codelearn.leetcode;

public class SwapNodesPairs {
    public static void main(String[] args) {
        SwapNodesPairs s = new SwapNodesPairs();
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        s.swapPairs(listNode);
        System.out.println(listNode);
    }
    public ListNode swapPairs(ListNode head) {
        ListNode listNode = new ListNode();
        ListNode result = listNode;
        if(head == null)
            return null;
        while (head != null){
            ListNode second = head.next;
            ListNode temp;
            if( second != null){
                temp = second.next;
                listNode = second;
                second.next = head;
                head.next = temp;
            } else {
                listNode = head;
            }
            head = head.next;
            listNode = listNode.next;
        }
        return result;
    }
}
