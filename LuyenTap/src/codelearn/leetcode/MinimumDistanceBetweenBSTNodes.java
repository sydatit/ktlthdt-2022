package codelearn.leetcode;


import java.util.TreeSet;

public class MinimumDistanceBetweenBSTNodes {
    public int minDiffInBST(TreeNode root) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        if( root == null)
            return 0;
        treeSet.add(root.val);
        findMinBST(root.left, treeSet);
        findMinBST(root.right, treeSet);
        int min = Integer.MAX_VALUE;
        int previous = treeSet.first();
        for (Integer item :treeSet) {
            if(item == previous) continue;
            min = Math.min(min, item - previous);
            previous = item;
        }
        return min;
    }

    private void findMinBST(TreeNode root, TreeSet<Integer> listNode) {
        if(root == null){
            return;
        }
        listNode.add(root.val);
        findMinBST(root.left, listNode);
        findMinBST(root.right, listNode);
    }
}
