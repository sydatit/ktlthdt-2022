package codelearn.leetcode;

import java.math.BigInteger;
import java.util.Stack;

public class NumbStepsReduceNumberBinaryRepresentationOne {
    public static void main(String[] args) {
        NumbStepsReduceNumberBinaryRepresentationOne numbStepsReduceNumberBinaryRepresentationOne = new NumbStepsReduceNumberBinaryRepresentationOne();
        System.out.println(numbStepsReduceNumberBinaryRepresentationOne.numSteps2("1101"));
    }
//    public int numSteps(String s) {
//
//        BigInteger bigInteger = new BigInteger(s, 2);
//        // System.out.println(result);
//        int count = 0;
//        while(bigInteger.intValue() != 1) {
//            count++;
//            if (bigInteger.mod(BigInteger.valueOf(2L)).intValue() == 0) {
//                bigInteger = bigInteger.divide(BigInteger.valueOf(2L));
//            } else {
//                bigInteger = bigInteger.add(BigInteger.valueOf(1));
//            }
//        }
//        return count;
//    }
    public int numSteps(String s) {
        StringBuilder sb = new StringBuilder(s);
        while (sb.charAt(0) == '0')
            sb.deleteCharAt(0);
        int count = 0;
        while (sb.length() != 1) {
            while (sb.charAt(sb.length() - 1) == '0') {
                count++;
                sb.deleteCharAt(sb.length() - 1);
            }
            int length = sb.length();
            if (length == 1)
                break;
            while (sb.length() > 0 && sb.charAt(sb.length() - 1) == '1') {
                count++;
                sb.deleteCharAt(sb.length() - 1);
            }
            if (sb.length() == 0) {
                sb.append('0');
            } else {
                sb.setCharAt(sb.length() - 1, '1');
            }
            count++;
        }
        return count;
    }
    // could you convert my code to use array list instead of string builder
    public int numSteps2(String s) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i) - '0');
        }
        int count = 0;
        while (stack.size() != 1) {
            while (stack.peek() == 0) {
                count++;
                stack.pop();
            }
            int length = stack.size();
            if (length == 1)
                break;
            while (!stack.isEmpty() && stack.peek() == 1) {
                count++;
                stack.pop();
            }
            if (stack.isEmpty()) {
                stack.push(0);
            } else {
                stack.pop();
                stack.push(1);
            }
            count++;
        }
        return count;
    }
}
