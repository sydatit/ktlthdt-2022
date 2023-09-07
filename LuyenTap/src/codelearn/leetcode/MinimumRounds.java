package codelearn.leetcode;

import java.util.HashMap;

public class MinimumRounds {
    public static void main(String[] args) {
        System.out.println(minimumRounds( new int[]{2,2,3}));
    }
    public static int minimumRounds(int[] tasks) {
        int result = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < tasks.length; i++) {
            if( map.containsKey(tasks[i])){
                Integer value = map.get(tasks[i]);
                map.put(tasks[i], ++value);
            }else {
                map.put(tasks[i], 1);
            }
        }

        for (Integer item : map.values()) {
            if( item == 1){
                return -1;
            }else if( item == 2 || item == 3){
                result++;
            }else {

                int mod = item % 3;
                if( mod == 0){
                    result += item/3;
                } else if (mod == 1) {
                    result += 2 + ( item - 4)/3;
                } else
                    result += 1 + item/3;
            }
        }
        return result;
    }
}
