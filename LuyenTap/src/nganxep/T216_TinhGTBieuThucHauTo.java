package nganxep;

import java.util.Scanner;
import java.util.Stack;

public class T216_TinhGTBieuThucHauTo {
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
        for (int i = 0; i < inputExp.length(); i++) {
            char charI = inputExp.charAt(i);
            if( '0' <= charI && charI <= '9'){
                stack.push(charI -'0');
            }else {
                int firstNum = stack.pop();
                int secondNum = stack.pop();
                int computeValue = 0;
                switch (charI){
                    case '+':
                        computeValue = secondNum + firstNum;
                        break;
                    case '-':
                        computeValue = secondNum - firstNum;
                        break;
                    case '*':
                        computeValue = secondNum * firstNum;
                        break;
                    case '/':
                        computeValue = secondNum / firstNum;
                        break;
                    case '^':
                        computeValue = (int) Math.pow( secondNum, firstNum);
                        break;
                    case '%':
                        computeValue = secondNum % firstNum;
                        break;
                }
                stack.push(computeValue);
            }
        }
        return stack.peek();
    }
}
