package codelearn.leetcode;

import java.util.Arrays;

public class Candy {
    public static void main(String[] args) {
        Candy candy = new Candy();
        int[] ratings = {1, 0, 2};
        System.out.println(candy.candy(ratings));
    }
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        int n = ratings.length;
        Arrays.fill(candies, 1);
        int total = 0;
        for (int i = 1; i < n ; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
//        System.out.println(Arrays.toString(candies));
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

//        System.out.println(Arrays.toString(candies));
        for (int i = 0; i < n; i++) {
            total += candies[i];
        }
        return total;
    }
}
