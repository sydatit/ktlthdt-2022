package codelearn.leetcode;

public class SwappingNodesLinkedList {
    //    public ListNode swapNodes(ListNode head, int k) {
//        int indexOfSecondNode = 0;
//        int length = 1, firstValue = 0, secondValue = 0, i = 1;
//        if(k == 1)
//            firstValue = head.val;
//        ListNode temp = head.next;
//        while (temp != null) {
//            length++;
//            if(k == length)
//                firstValue = temp.val;
//            temp = temp.next;
//        }
//        indexOfSecondNode = length - k;
//
//        if(indexOfSecondNode == 1)
//            secondValue = head.val;
//        temp = head.next;
//        while (temp != null) {
//            i++;
//            if(i == indexOfSecondNode)
//                secondValue = temp.val;
//            temp = temp.next;
//        }
//
//        temp = head;
//        for (int j = 0; j < length; j++) {
//            if( j + 1 == k)
//                temp.val = secondValue;
//            if(j + 1 == indexOfSecondNode)
//                temp.val = firstValue;
//            temp = temp.next;
//        }
//        return head;
//    }
    public ListNode swapNodes(ListNode head, int k) {

        ListNode temp = head;
        int length = 0;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        int indexOfSecondNode = length - k + 1;
        temp = head;
        ListNode firstNode = null, secondNode = null;
        for (int i = 1; i <= length; i++) {
            if(i == k)
                firstNode = temp;
            if(i == indexOfSecondNode)
                secondNode = temp;
            temp = temp.next;
        }
        int tempVal = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = tempVal;
        return head;
    }
}



class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {

            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
    }
}