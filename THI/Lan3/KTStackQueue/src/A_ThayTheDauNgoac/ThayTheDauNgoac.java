package A_ThayTheDauNgoac;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class ThayTheDauNgoac {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int repeat = Integer.parseInt(scanner.nextLine());
        while (repeat --> 0){
            String inputStr = scanner.nextLine();
            solve(inputStr);
        }
    }

    private static void solve(String inputStr) {
        int length = inputStr.length();
        String[] chars = new String[length];
        Stack<PairKV> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            char charI = inputStr.charAt(i);
            if( charI == ')' && !stack.empty()){
                PairKV pairKV = stack.pop();
                while ( pairKV.getKey() != '('){
                    chars[pairKV.getIndex()] = pairKV.getKey() + "";
                    if( stack.empty())
                        break;
                    else pairKV = stack.pop();
                }
                if(pairKV.getKey() == '('){
                    chars[pairKV.getIndex()] = "0";
                    chars[i] = "1";
                }else {
                    chars[pairKV.getIndex()] = "-1";
                    chars[i] = "-1";
                }
            }else {
                stack.push(new PairKV(charI, i));
            }
        }
        while (!stack.empty()){
            PairKV pairKV = stack.pop();
            if( pairKV.getKey() == '(' || pairKV.getKey() == ')')
                chars[pairKV.getIndex()] = "-1";
            else chars[pairKV.getIndex()] = pairKV.getKey() + "";
        }
        Arrays.stream(chars).forEach(System.out::printf);
        System.out.println();
    }
}
class PairKV{
    private char key;
    private int index;

    public PairKV(char key, int index) {
        this.key = key;
        this.index = index;
    }

    public char getKey() {
        return key;
    }

    public int getIndex() {
        return index;
    }
}
