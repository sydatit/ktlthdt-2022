package contest.midyear2024;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GROUPING {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        int res = 0;
        boolean isValid = true;
        for (int value : map.values()) {
            int numberOfGroups = 0;
            int remainder = value % 3;
            if (remainder == 0) {
                numberOfGroups += value / 3;
            } else {
                int division = value / 3;
                if (division > 0) {
                    numberOfGroups += division + 1;
                } else if (value % 2 == 0) {
                    numberOfGroups += 1;
                }
            }
            if (numberOfGroups > 0) {
                res += numberOfGroups;
            } else {
                isValid = false;
                break;
            }
        }
        System.out.println(isValid ? res : -1);
    }
}
/*
7
1 1 1 2 2 1 2
 */