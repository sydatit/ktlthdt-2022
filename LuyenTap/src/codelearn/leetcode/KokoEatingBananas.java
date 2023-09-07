package codelearn.leetcode;

public class KokoEatingBananas {
    public static void main(String[] args) {
        int[] piles = {3,6,7,11};
        int h = 8;
        System.out.println(new KokoEatingBananas().minEatingSpeed(piles, h));
    }
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < piles.length; i++) {
            max = Math.max(max, piles[i]);
        }
        int left = 1;
        int right = max;
        while ( left < right){
            int mid = left + (right - left)/2;
            int count = 0;
            for (int i = 0; i < piles.length; i++) {
                int time = piles[i]/mid;
                if(piles[i] % mid != 0) time++;
                count += time;
                if(count > h) break;
            }
            if (count > h){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return left;
    }
}
/*
Example 1:

    Input: piles = [3,6,7,11], h = 8
    Output: 4
Example 2:

    Input: piles = [30,11,23,4,20], h = 5
    Output: 30
Example 3:

    Input: piles = [30,11,23,4,20], h = 6
    Output: 23
 */
