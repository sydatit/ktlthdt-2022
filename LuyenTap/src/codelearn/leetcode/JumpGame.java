package codelearn.leetcode;

import java.util.Scanner;

public class JumpGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        JumpGame jumpGame = new JumpGame();
        System.out.println(jumpGame.canJump(arr));
    }
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if( n == 1) return true;
        boolean[] isReach = new boolean[n];

        isReach[0] = true;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if( isReach[j] && i - j <= nums[j] ){
                    isReach[i] = true;
                    break;
                }
            }
        }

        return isReach[n-1];
    }
}
/*
5
2 3 1 1 4

5
3 2 1 0 4
 */