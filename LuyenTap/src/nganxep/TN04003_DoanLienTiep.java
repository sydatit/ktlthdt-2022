package nganxep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class TN04003_DoanLienTiep {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int repeat = scanner.nextInt();
        while (repeat--> 0){
            int size = scanner.nextInt();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                list.add(scanner.nextInt());
            }
            solve(list, size);
        }
    }
    private static void solve(ArrayList<Integer> list, int size) {
        int[] arrayResult = new int[size];
        Stack<PairInt> stack = new Stack<>();
        stack.push(new PairInt( Integer.MAX_VALUE, -1));
        for (int i = 0; i < size; i++) {
            while (!stack.empty() && list.get(i) >= stack.peek().getKey()) stack.pop();
            arrayResult[i] = i - stack.peek().getValue();
            stack.push(new PairInt(list.get(i), i ));
        }
        Arrays.stream(arrayResult).forEach(item -> System.out.print(item + " "));
        System.out.println();
    }
}

class PairInt{
    private int key;
    private int value;

    public PairInt(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }
}
