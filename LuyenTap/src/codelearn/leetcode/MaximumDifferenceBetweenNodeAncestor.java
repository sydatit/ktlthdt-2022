package codelearn.leetcode;

import java.util.Arrays;

public class MaximumDifferenceBetweenNodeAncestor {
    public static void main(String[] args) {

    }
    public int maxAncestorDiff(TreeNode root) {
        int[] range = new int[2];
        System.out.println();
        return findMax(root, range);
    }

    private int findRange(TreeNode node, int[] rangeOfParent) {
        int[] range = new int[2];
        int max = findMax(node, range);

        rangeOfParent[0] = Math.min(range[0], rangeOfParent[0]);
        rangeOfParent[1] = Math.max(range[1], rangeOfParent[1]);
        return max;
    }

    private int findMax(TreeNode node, int[] range) {
        Arrays.fill(range, node.val);
        int max = 0;
        if (node.left != null) {
            max = findRange(node.left, range);
        }
        if (node.right != null) {
            max = Math.max(max, findRange(node.right, range));
        }
        max = Math.max(max, Math.abs(node.val - range[0]));
        max = Math.max(max, Math.abs(node.val - range[1]));
        return max;
    }
}
