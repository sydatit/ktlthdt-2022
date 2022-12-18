package laptrinhcoban;

import java.util.Arrays;
import java.util.Scanner;

public class GroupedBits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String bit = Integer.toBinaryString(n);
        String[] groupBits = bit.split("[0+]");
        long result = Arrays.stream(groupBits)
                        .filter( item -> item.trim().length() > 0)
                                .count();
        System.out.println(result);
    }
}
