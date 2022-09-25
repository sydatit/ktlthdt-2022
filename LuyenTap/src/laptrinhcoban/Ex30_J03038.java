package laptrinhcoban;

import java.math.BigInteger;
import java.util.Scanner;

public class Ex30_J03038 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        boolean[] marked = new boolean[26];
        for (int i = 0; i < word.length(); i++) {
            marked[ word.charAt(i) - 'a'] = true;
        }
        int count = 0;
        for (int i = 0; i < marked.length; i++) {
            if( marked[i]) count++;
        }
        System.out.println(count);
    }
}
