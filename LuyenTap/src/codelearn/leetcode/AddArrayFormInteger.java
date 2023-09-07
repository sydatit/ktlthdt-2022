package codelearn.leetcode;

import java.util.LinkedList;
import java.util.List;

public class AddArrayFormInteger {
    public static void main(String[] args) {
        System.out.println((new AddArrayFormInteger()).addToArrayForm(
                new int[]{
                        2,1,5
                },
                806
        ));
    }
    public List<Integer> addToArrayForm(int[] num, int k) {
        final LinkedList<Integer> list = new LinkedList<>();
        int i = num.length - 1;
        while (i >= 0 || k > 0){
            if( i >= 0) k += num[i--];
            list.addFirst(k% 10);
            k /= 10;
        }
        return list;
    }
}
