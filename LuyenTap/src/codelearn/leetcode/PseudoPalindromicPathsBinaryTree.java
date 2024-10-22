package codelearn.leetcode;

public class PseudoPalindromicPathsBinaryTree {
    public static void main(String[] args) {

    }
    int result;
    public int pseudoPalindromicPaths (TreeNode root) {
        result = 0;
        int[] occurrences = new int[10];
        dfs(root, occurrences, 0);
        return result;
    }

    private void dfs(TreeNode node, int[] occurrences, int length) {
        if (node == null) return;
        length++;
        boolean isLeaf = true;
        occurrences[node.val]++;
        if (node.left != null) {
            isLeaf = false;
            dfs(node.left, occurrences, length);
        }
        if (node.right != null) {
            isLeaf = false;
            dfs(node.right, occurrences, length);
        }

        if (isLeaf && checkPseudoPalindromic(occurrences, length)) {
            // calculate array
            result++;
        }
        occurrences[node.val]--;
    }

    private boolean checkPseudoPalindromic(int[] occurrences, int length) {
        int countOdd = 0;
        for (int occ :occurrences) {
            if (occ % 2 != 0)
                countOdd++;
        }
        return (countOdd == 0 && length % 2 == 0) || (length % 2 != 0 && countOdd == 1);
    }
}
