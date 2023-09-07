package codelearn.leetcode;

import java.util.ArrayList;
import java.util.List;

public class KidsWithGreatestNumberCandies {
    public static void main(String[] args) {
        int[] candies = {12,1,12};
        int extraCandies = 10;
        System.out.println((new KidsWithGreatestNumberCandies()).kidsWithCandies(candies, extraCandies));
    }
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < candies.length; i++) {
            max = Math.max( max, candies[i]);
        }
        for (int i = 0; i < candies.length; i++) {
            result.add(candies[i] + extraCandies >= max);
        }
        return result;
    }
}
