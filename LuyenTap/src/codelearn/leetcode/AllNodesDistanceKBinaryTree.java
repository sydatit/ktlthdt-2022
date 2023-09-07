package codelearn.leetcode;

import java.util.ArrayList;
import java.util.List;

public class AllNodesDistanceKBinaryTree {
    public static void main(String[] args) {
        AllNodesDistanceKBinaryTree test = new AllNodesDistanceKBinaryTree();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        System.out.println(test.distanceK(root, root.left, 2));
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();
        targetHigh = 0;
        iterateOver(root, target, result, k, 0, 1);
        if(targetHigh - 1 <= k)
            iterateWithHigh(root, target, result, k - targetHigh + 1 , 0);
        return result;
    }

    private void iterateWithHigh(TreeNode node, TreeNode target, List<Integer> result, int targetHigh, int high) {
        if(node == null)
            return;
        if(node.equals(target))
            return;
        if(high == targetHigh){
            result.add(node.val);
            return;
        }
        iterateWithHigh(node.left,target , result, targetHigh, high + 1);
        iterateWithHigh(node.right,target , result, targetHigh, high + 1);
    }

    private int targetHigh;

    private void iterateOver(TreeNode node, TreeNode target, List<Integer> result, int k, int countFromTarget, int high) {
        if(node == null)
            return;
        if(node.equals(target)){
            targetHigh = high;
            iterateOver(node.left, target, result, k, 1, high + 1);
            iterateOver(node.right, target, result, k, 1, high + 1);
            return;
        }
        if(countFromTarget > 0 && countFromTarget != k){
            iterateOver(node.left, target, result, k, countFromTarget + 1, high + 1);
            iterateOver(node.right, target, result, k, countFromTarget + 1, high + 1);
            return;
        }else if(countFromTarget == k) {
            result.add(node.val);
            return;
        }
        iterateOver(node.left, target, result, k, 0, high + 1);
        iterateOver(node.right, target, result, k, 0, high + 1);
    }
}
