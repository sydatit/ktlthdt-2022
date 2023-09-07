package codelearn.leetcode;

public class CapacityToShipPackagesWithinDDays {
    public static void main(String[] args) {
        System.out.println((new CapacityToShipPackagesWithinDDays()).shipWithinDays(
                new int[]{
                        1,2,3,4,5,6,7,8,9,10
                },
                5
        ));
    }
    public int shipWithinDays(int[] weights, int days) {
        int maxWeight = -1, totalWeight = 0;
        for (int item :weights) {
            maxWeight = Math.max(maxWeight, item);
            totalWeight += item;
        }
        System.out.println("out loop "+ maxWeight + " total: " + totalWeight);
        while ( maxWeight < totalWeight){
            int mid = (totalWeight + maxWeight)/2;
//            System.out.println(mid);
//            System.out.println("in loop "+ maxWeight + " total: " + totalWeight);
            int totalDay = 1, curWeight = 0;
            for (int item :weights) {
                if( curWeight + item > mid){
                    totalDay++;
                    curWeight = 0;
                }
                curWeight += item;
            }
//            System.out.println(totalDay);
            if( totalDay > days){
                maxWeight = mid + 1;
            }else totalWeight = mid;
        }
        return maxWeight;
    }
}
