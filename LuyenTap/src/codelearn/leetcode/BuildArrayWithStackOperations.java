package codelearn.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BuildArrayWithStackOperations {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2};
        int n = 4;
        BuildArrayWithStackOperations operations = new BuildArrayWithStackOperations();
        System.out.println(operations.buildArray(array, n));
    }

    public List<String> buildArray(int[] target, int n) {
        List<String> result = new ArrayList<>();
        if (target.length == 0) return result;
        int stream = 1;
        String push = "Push";
        String pop = "Pop";
        for (int i = 0; i < target.length && stream <= n; i++) {
            while (target[i] != stream) {
                result.add(push);
                result.add(pop);
                stream++;
            }
            stream++;
            result.add(push);
        }
        return result;
    }
}
