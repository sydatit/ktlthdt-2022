package codelearn.leetcode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeInorderPostorderTraversal {
    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        TreeNode root = new ConstructBinaryTreeInorderPostorderTraversal().buildTree(inorder, postorder);
        System.out.println(root);
    }
    private Map<Integer, Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build( postorder, 0, inorder.length - 1, inorder.length - 1);
    }

    private TreeNode build( int[] postorder, int leftI, int rightI, int indexPost) {
        if (leftI > rightI) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[indexPost]);
        int i = map.get(postorder[indexPost]);
        root.right = build( postorder, i + 1, rightI, indexPost - 1);
        root.left = build( postorder, leftI, i - 1, indexPost - (rightI - i) - 1);
        return root;
    }
}
