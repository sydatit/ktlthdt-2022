package codelearn.leetcode;

import java.util.HashMap;
import java.util.Map;

public class FindModeBinarySearchTree {
    public static void main(String[] args) {

    }
    Map<Integer, Integer> map;
    public int[] findMode(TreeNode root) {
        map = new HashMap<>();
        traverse(root);
        int count = 0;
        int max = -1;
        for (Map.Entry<Integer, Integer> item :map.entrySet()) {
            if (item.getValue() > max) {
                max = item.getValue();
                count = 1;
            } else if (item.getValue() == max) {
                count++;
            }
        }
        int[] result = new int[count];
        int i = 0;
        for (Map.Entry<Integer, Integer> item :map.entrySet()) {
            if (item.getValue() == max) {
                result[i++] = item.getKey();
            }
        }
        return result;
    }

    private void traverse(TreeNode u) {
        if (u == null) return;
        int count = map.getOrDefault(u.val, 0);
        map.put(u.val, ++count);
        traverse(u.right);
        traverse(u.left);
    }
}
