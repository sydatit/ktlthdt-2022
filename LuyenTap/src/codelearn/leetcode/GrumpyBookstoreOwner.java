package codelearn.leetcode;

public class GrumpyBookstoreOwner {
    public static void main(String[] args) {
        GrumpyBookstoreOwner grumpyBookstoreOwner = new GrumpyBookstoreOwner();
        int[] customers = {1, 0, 1, 2, 1, 1, 7, 5};
        int[] grumpy = {0, 1, 0, 1, 0, 1, 0, 1};
        int minutes = 3;
        System.out.println(grumpyBookstoreOwner.maxSatisfied(customers, grumpy, minutes));
    }
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int maxSatisfied = 0;
        int countSatisfied = 0;
        int currentSInWindow = 0;
        for (int i = 0; i < minutes; i++) {
            if (grumpy[i] == 1) {
                currentSInWindow += customers[i];
            } else {
                countSatisfied += customers[i];
            }
        }
        maxSatisfied = currentSInWindow;
        for (int i = minutes; i < customers.length; i++) {
            if (grumpy[i] == 1) {
                currentSInWindow += customers[i];
            } else {
                countSatisfied += customers[i];
            }
            if (grumpy[i - minutes] == 1) {
                currentSInWindow -= customers[i - minutes];
            }
            if (currentSInWindow > maxSatisfied) {
                maxSatisfied = currentSInWindow;
            }
        }
        return countSatisfied + maxSatisfied;
    }
}
