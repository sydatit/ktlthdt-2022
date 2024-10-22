package codelearn.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class DiagonalTraverseII {
    public static void main(String[] args) {
        DiagonalTraverseII di = new DiagonalTraverseII();
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(4, 5);
        List<Integer> list3 = Arrays.asList(7, 8, 9);
        List<List<Integer>> nums = new ArrayList<>();
        nums.add(list1);
        nums.add(list2);
        nums.add(list3);
        System.out.println(Arrays.toString(di.findDiagonalOrder(nums)));
    }
//    public int[] findDiagonalOrder(List<List<Integer>> nums) {
//        int rows = nums.size();
//        int cols = 0;
//        int length = 0;
//        for (List<Integer> list: nums){
//            if (list.size() > cols) {
//                cols = list.size();
//            }
//            length += list.size();
//        }
//        int[] result = new int[length];
//        int i = 0;
//        int j = 0;
//        int index = 0;
//        while (i < rows && j < cols) {
//            for (int r = i, c = j; r >= 0 && c < cols; r--, c++) {
//                List<Integer> list = nums.get(r);
//                if (c < list.size()) result[index++] = list.get(c);
//            }
//            if (i == rows - 1) j++;
//            if (i + 1 < rows) i++;
//        }
//
//        return result;
//    }

    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        LinkedList<LinkedList<Integer>> linkedLists = new LinkedList<>();
        int rows = nums.size();
        for (int i = 0; i < rows; i++) {
            linkedLists.add(new LinkedList<>(nums.get(i)));
        }
        int length = 0;
        for (List<Integer> list: nums){
            length += list.size();
        }
        int[] result = new int[length];
        int index = 0;
        int c = 0;
        while (!linkedLists.isEmpty()) {
            for (int i = c; i >= 0; i--) {
                LinkedList<Integer> linkedList = linkedLists.get(i);
                if (linkedList.isEmpty()) continue;
                result[index++] = linkedList.getFirst();
                linkedList.removeFirst();
                if (linkedList.isEmpty()) linkedLists.removeFirst();
            }
            c++;
        }
        return result;
    }
}
