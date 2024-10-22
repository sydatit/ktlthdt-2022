package prepare.interview.collection;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class ArrayListAndLinkedListComparing {
    public static void main(String[] args) {
        testAddElementAtEndingOfList();
//        testAddElementAtBeginningOfList();
//        testAddElementAtMiddleOfList();
    }
    static void testAddElementAtEndingOfList() {
        // ArrayList
        long startTime = System.currentTimeMillis();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            arrayList.add(i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken by ArrayList: " + (endTime - startTime) + "ms");
        // LinkedList
        startTime = System.currentTimeMillis();
        Deque<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 1000000; i++) {
            linkedList.addLast(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Time taken by LinkedList: " + (endTime - startTime) + "ms");
    }

    static void testAddElementAtBeginningOfList() {
        // ArrayList
        long startTime = System.currentTimeMillis();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            arrayList.add(0, i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken by ArrayList: " + (endTime - startTime) + "ms");
        // LinkedList
        startTime = System.currentTimeMillis();
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 1000000; i++) {
            linkedList.add(0, i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Time taken by LinkedList: " + (endTime - startTime) + "ms");
    }

    static void testAddElementAtMiddleOfList() {
        // ArrayList
        long startTime = System.currentTimeMillis();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            arrayList.add(arrayList.size() / 2, i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken by ArrayList: " + (endTime - startTime) + "ms");
        // LinkedList
        startTime = System.currentTimeMillis();
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 10000; i++) {
            linkedList.add(linkedList.size() / 2, i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Time taken by LinkedList: " + (endTime - startTime) + "ms");
    }

}
