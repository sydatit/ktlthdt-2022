package codelearn.leetcode;

public class MergeBetweenLinkedLists {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(0);
        ListNode temp = list1;
        for (int i = 1; i < 10; i++) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        ListNode list2 = new ListNode(100);
        temp = list2;
        for (int i = 101; i < 110; i++) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        MergeBetweenLinkedLists mergeBetweenLinkedLists = new MergeBetweenLinkedLists();
        ListNode result = mergeBetweenLinkedLists.mergeInBetween(list1, 3, 3, list2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode tailList2 = null;
        ListNode temp = list2;
        while (temp != null) {
            tailList2 = temp;
            temp = temp.next;
        }
        int index = 0;
        ListNode nextNode = null;
        ListNode prevNode = null;
        temp = list1;
        while (temp != null) {
            if (index == a - 1) {
                prevNode = temp;
            }
            if (index == b) {
                nextNode = temp.next;
                break;
            }
            temp = temp.next;
            index++;
        }
        if (tailList2 != null)
            tailList2.next = nextNode;
        if (a == 0) {
            return list2;
        }
        if (prevNode != null)
            prevNode.next = list2;

        return list1;
    }
}
