package nganxep;

import java.util.Scanner;
import java.util.Stack;

public class T216_TinhGTBieuThucTienTo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int repeat = Integer.parseInt(sc.nextLine());
        while (repeat -->0){
            String inputExp = sc.nextLine();
            System.out.println(compute(inputExp));
        }
    }

    private static int compute(String inputExp) {
        Stack<Integer> stack = new Stack<>();
        for (int i = inputExp.length() -1; i >= 0; i--) {
            char charI = inputExp.charAt(i);
            if( '0' <= charI && charI <= '9'){
                stack.push(charI -'0');
            }else {
                int firstNum = stack.pop();
                int secondNum = stack.pop();
                int computeValue = 0;
                switch (charI){
                    case '+':
                        computeValue = firstNum + secondNum;
                        break;
                    case '-':
                        computeValue = firstNum - secondNum;
                        break;
                    case '*':
                        computeValue = firstNum * secondNum;
                        break;
                    case '/':
                        computeValue = firstNum / secondNum;
                        break;
                    case '^':
                        computeValue = (int) Math.pow( firstNum, secondNum);
                        break;
                    case '%':
                        computeValue = firstNum % secondNum;
                        break;
                }
                stack.push(computeValue);
            }
        }
        return stack.peek();
    }
}
