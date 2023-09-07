package codelearn.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LongestSubarray1AfterDeletingOneElement {
    public static void main(String[] args) {
        LongestSubarray1AfterDeletingOneElement longestSubarray1AfterDeletingOneElement = new LongestSubarray1AfterDeletingOneElement();
        int[] nums = {0,1,1,1,0,0,1,1,0};
        int result = longestSubarray1AfterDeletingOneElement.longestSubarray(nums);
        System.out.println(result);
    }
    public int longestSubarray(int[] nums) {
        boolean hasZero = false;
        List<Boolean> listHasOneZero = new ArrayList<>();
        List<Integer> listOneSubArray = new ArrayList<>();
        int count = 0;
        int countZero = 0;
        for (int i = 0; i < nums.length; i++) {
            if( nums[i] == 1){
                count++;
                countZero = 0;
            }else{
                hasZero = true;
                countZero++;
                if( count > 0){
                    listOneSubArray.add(count);
                    count = 0;
                }
                if( i + 1 < nums.length && nums[i + 1] == 1 && !listOneSubArray.isEmpty()) {
                    if( countZero == 1)
                        listHasOneZero.add(true);
                    else
                        listHasOneZero.add(false);
                }
            }
        }
        if( count > 0)
            listOneSubArray.add(count);
        if( !hasZero)
            return nums.length - 1;
        if( listOneSubArray.size() == 1)
            return listOneSubArray.get(0);
        int max = listOneSubArray.get(0);
        for (int i = 0; i < listOneSubArray.size() - 1; i++) {
            max = Math.max(max, listOneSubArray.get(i));
            if(Boolean.TRUE.equals(listHasOneZero.get(i)))
                max = Math.max(max, listOneSubArray.get(i) + listOneSubArray.get(i + 1));
        }
        return max;
    }
}
