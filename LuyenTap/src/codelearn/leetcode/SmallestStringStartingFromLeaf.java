package codelearn.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class SmallestStringStartingFromLeaf {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
root.left = new TreeNode(0);
root.right = new TreeNode(1);
root.left.left = new TreeNode(1);
        System.out.println(new SmallestStringStartingFromLeaf().smallestFromLeaf(root));


    }
    String ans = "~";
    public String smallestFromLeaf(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return ans;
    }

    private void dfs(TreeNode node, StringBuilder sb) {
        if (node == null) return;
    }

}
