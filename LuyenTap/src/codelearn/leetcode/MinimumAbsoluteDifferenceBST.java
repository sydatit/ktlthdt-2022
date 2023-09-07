package codelearn.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class MinimumAbsoluteDifferenceBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode right = new TreeNode(3);
        TreeNode rightLeft = new TreeNode(2);
        root.right = right;
        right.left = rightLeft;
        System.out.println(new MinimumAbsoluteDifferenceBST().getMinimumDifference(root));
    }
    private int min = Integer.MAX_VALUE;
    private Integer prev = null;
    public int getMinimumDifference(TreeNode root) {
        if( root == null){
            return min;
        }
        getMinimumDifference(root.left);
        if( prev != null){
            min = Math.min(min, root.val - prev);
        }
        prev = root.val;
        getMinimumDifference(root.right);

        return min;
    }


}
