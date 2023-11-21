package codelearn.leetcode;

public class CountNodesEqualAverageSubtree {
    public static void main(String[] args) {

    }
    static class SubTree{
        int numberOfNodes;
        int sum;
        public SubTree(int numberOfNodes, int sum) {
            this.numberOfNodes = numberOfNodes;
            this.sum = sum;
        }
    }

    private int count;
    public int averageOfSubtree(TreeNode root) {
        count = 0;
        dfs(root);
        return count;
    }

    private int[] dfs(TreeNode node) {
        if (node == null) {return new int[2];}
        int sum = node.val;
        int numberOfNodes = 1;
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        numberOfNodes += left[0] + right[0];
        sum += left[1] + right[1];

        if (node.val == (int) Math.floor((double) sum / numberOfNodes)) {
            count++;
        }
        return new int[]{numberOfNodes, sum};
    }
}
