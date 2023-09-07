package codelearn.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        int[] nums = {1, 0};
        List<List<Integer>> res = permutations.permute(nums);
        System.out.println(res);
    }
    private List<List<Integer>> res;
    private boolean[] visited;
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        int[] indices = new int[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        res = new ArrayList<>();
        visited = new boolean[n];
        Try(nums, indices, 0, n);
        return res;
    }

    private void Try(int[] nums, int[] indices, int i, int n) {
        for (int j = 0; j < n; j++) {
            if(!visited[j]){
                visited[j] = true;
                indices[i] = j;
                if(i == n - 1){
                    List<Integer> list = new ArrayList<>();
                    for (int k = 0; k < n; k++) {
                        list.add(nums[indices[k]]);
                    }
                    res.add(list);
                }else{
                    Try(nums, indices, i + 1, n);

                }
                visited[j] = false;
            }
        }
    }
}
