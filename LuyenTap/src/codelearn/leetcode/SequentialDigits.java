package codelearn.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SequentialDigits {
    public static void main(String[] args) {
        SequentialDigits sequentialDigits = new SequentialDigits();
        System.out.println(sequentialDigits.sequentialDigits(1000, 13000));
    }
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<>();
        int[] digits = new int[9];
        for (int i = 0; i < digits.length; i++) {
            digits[i] = i + 1;
        }
        int minL = ("" + low).length();
        int maxL = ("" + high).length();
        for (int l = minL; l <= maxL; l++) {
            boolean isExcess = false;
            for (int i = 0; i < digits.length; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = i; j < l + i && j < digits.length; j++) {
                    sb.append(digits[j]);
                }
                if (sb.length() == l) {
                    int value = Integer.parseInt(sb.toString());
                    if (low <= value && value <= high)
                        result.add(value);
                    else if (value > high){
                        isExcess = true;
                        break;
                    }
                }
            }
            if (isExcess)
                break;
        }
        return result;
    }
}
