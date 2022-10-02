package nganxep;

import java.util.Scanner;
import java.util.Stack;

public class DSA07021_DayNgoacDungDaiNhat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int repeat =scanner.nextInt();
        scanner.nextLine();
        while (repeat --> 0){
            String input = scanner.nextLine();
            Stack<String> stack = new Stack<>();
            for (int i = 0; i < input.length(); i++) {
                if( !stack.isEmpty()){
                    if( input.charAt(i) == '(' || stack.lastElement().equals(")")){
                        stack.push(input.charAt(i) + "");
                    }else {
                        String lastElement = stack.pop();
                        try{
                            int number = Integer.parseInt(lastElement);
                            if( !stack.isEmpty()){
                                String last = stack.pop();
                                if( last.equals(")")){
                                    stack.push(last);
                                    stack.push(lastElement);
                                    stack.push(input.charAt(i)+ "");
                                }else {

                                }
                            }else {
                                stack.push(number+"");
                                stack.push(input.charAt(i) +"");
                            }
                        }catch (NumberFormatException e){

                        }
                    }
                }else stack.push(input.charAt(i) + "");
            }
        }
    }
}
