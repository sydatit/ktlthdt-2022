package codelearn.leetcode;

public class MaximumLevelSumBinaryTree {
    public static void main(String[] args) {
        MaximumLevelSumBinaryTree solution = new MaximumLevelSumBinaryTree();
        TreeNode root = new TreeNode(-100);
        root.left = new TreeNode(-200);
        root.right = new TreeNode(-300);
        root.left.left = new TreeNode(-20);
        root.left.right = new TreeNode(-5);
        root.right.left = new TreeNode(-10);
        System.out.println(solution.maxLevelSum(root));
    }
    private int[] levelSum;
    private int depth;

    public int maxLevelSum(TreeNode root) {
        levelSum = new int[10000];
        depth = 0;
        dfs(root, 1);
        int max = Integer.MIN_VALUE;
        int maxLevel = 0;
        for (int i = 1; i <= depth; i++) {
            if (levelSum[i] > max) {
                max = levelSum[i];
                maxLevel = i;
            }
        }
        return maxLevel;
    }

    private void dfs(TreeNode node, int level) {
        if (node == null) {
            return;
        }
        if (level > depth) {
            depth = level;
        }
        levelSum[level] += node.val;
        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
    }
}
