package codelearn.leetcode;

import java.util.*;

public class FindDuplicateSubtrees {
    public static void main(String[] args) {

    }
    private HashMap<String,TreeNode> map;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        map = new HashMap<>();
        Set<TreeNode> result = new HashSet<>();
        findDuplicateSubtreesHelper(root, result);
        return new ArrayList<>(result);
    }
    private StringBuilder findDuplicateSubtreesHelper(TreeNode root, Set<TreeNode> result) {
        StringBuilder sb = new StringBuilder();
        if(root == null){
            return sb;
        }
        sb.append(root.val);
        sb.append(" ").append(findDuplicateSubtreesHelper(root.left, result));
        sb.append(" ").append(findDuplicateSubtreesHelper(root.right, result));
        String key = sb.toString();
        if(map.containsKey(key)){
            if(map.get(key) != null){
                result.add(map.get(key));
            }
        } else{
            map.put(key, root);
        }
        return sb;
    }
}

