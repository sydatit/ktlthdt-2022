package codelearn.leetcode;

import java.util.ArrayList;
import java.util.List;

public class FindLargestValueEachTreeRow {
    public static void main(String[] args) {

    }
    private List<Integer> res;
    public List<Integer> largestValues(TreeNode root) {
        res = new ArrayList<>();
        traverseBFS(root, 0);
        return res;
    }

    private void traverseBFS(TreeNode u, int row) {
        if (u == null)
            return;
        if (res.size() == row)
            res.add(u.val);
        else {
            res.set(row, Math.max(res.get(row), u.val));
        }
        traverseBFS(u.left, row + 1);
        traverseBFS(u.right, row + 1);
    }
}
