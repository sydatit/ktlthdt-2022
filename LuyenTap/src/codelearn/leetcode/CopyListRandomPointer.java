package codelearn.leetcode;

import java.util.HashMap;

public class CopyListRandomPointer {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public static void main(String[] args) {
        CopyListRandomPointer copyListRandomPointer = new CopyListRandomPointer();
        Node head = copyListRandomPointer.new Node(7);
        Node temp = head;
        temp.next = copyListRandomPointer.new Node(13);
        temp = temp.next;
        temp.next = copyListRandomPointer.new Node(11);
        temp = temp.next;
        temp.next = copyListRandomPointer.new Node(10);
        temp = temp.next;
        temp.next = copyListRandomPointer.new Node(1);
        temp = temp.next;
        temp.random = head;
        temp = head.next;
        temp.random = temp.next.next;
        temp = temp.next;
        temp.random = head;
        temp = temp.next;
        temp.random = head.next.next;
        Node copyHead = copyListRandomPointer.copyRandomList(head);
        while (copyHead != null) {
            System.out.println(copyHead.val);
            copyHead = copyHead.next;
        }
    }
    private HashMap<Node, Node> map;
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        map = new HashMap<>();
        Node temp = head;
        Node copyHead = new Node(head.val);
        Node copyTemp = copyHead;
        while (temp != null) {
            if (temp.next != null) {
                copyTemp.next = new Node(temp.next.val);
            }
            map.put(temp, copyTemp);
            temp = temp.next;
            copyTemp = copyTemp.next;
        }
        temp = head;
        copyTemp = copyHead;
        while (temp != null) {
            copyTemp.random = map.get(temp.random);
            temp = temp.next;
            copyTemp = copyTemp.next;
        }
        return copyHead;
    }
}
