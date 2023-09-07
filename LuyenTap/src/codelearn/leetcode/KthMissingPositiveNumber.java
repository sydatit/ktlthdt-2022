package codelearn.leetcode;

public class KthMissingPositiveNumber {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int k = 2;
        System.out.println((new KthMissingPositiveNumber()).findKthPositive(arr, k));
    }
    int[] mark;
    public int findKthPositive(int[] arr, int k) {
        mark = new int[1001];
        for (int i = 0; i < arr.length; i++) {
            mark[arr[i]] = 1;
        }
        int result = 0;
        for (int i = 1; i < mark.length; i++) {
            if (mark[i] == 0) {
                k--;
            }
            if (k == 0) {
                result = i;
                break;
            }
        }
        if(k > 0)
            result = mark.length + k - 1;
        return result;
    }
}
