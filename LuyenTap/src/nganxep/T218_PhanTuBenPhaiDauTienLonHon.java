package nganxep;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class T218_PhanTuBenPhaiDauTienLonHon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int repeat = scanner.nextInt();
        while (repeat --> 0){
            int size = scanner.nextInt();
            int[] array = new int[size];
            for (int i = 0; i < size; i++) {
                array[i] = scanner.nextInt();
            }
            solve( size, array);
        }
    }

    private static void solve(int size, int[] array) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[size];
        for (int i = size - 1; i >= 0 ; i--) {
            while (!stack.empty() && array[i] >= stack.peek()) stack.pop();
            if( stack.empty()){
                result[i] = -1;
            }else {
                result[i] = stack.peek();
            }
            stack.push(array[i]);
        }
        Arrays.stream(result).forEach( item -> System.out.printf(item + " "));
        System.out.println();
    }
}
