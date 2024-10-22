package prepare.interview.collection.impl;

public class MyLinkedList<E> {
    Node head;
    static class Node<E> {
        E value;
        Node next;

        public Node(E value) {
            this.value = value;
            next = null;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        int size = 0;
        Node temp = head;
        while (temp != null) {
            size += 1;
            temp = temp.next;
        }
        return size;
    }

    public void add(E value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

//    public E get(int index) {
//        int currentI = 0;
//        while (currentI != )
//    }
}
