package codelearn.io;

import java.util.HashSet;
import java.util.Scanner;

public class PrimeXor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println(primeXor(a, b));
    }

    static long primeXor(long a, long b) {
        long result = 0;
        HashSet<Long> hashSetA = new HashSet<>();
        HashSet<Long> hashSetB = new HashSet<>();
        long temp = a;
        for (long i = 2; i <= Math.sqrt(a); i++) {
            while (temp% i == 0){
                hashSetA.add(i);
                temp = temp/ i;
            }
        }
        hashSetA.add(temp);
//        System.out.println(hashSetA.size());
        temp = b;
        for (long i = 2; i <= Math.sqrt(b) ; i++) {
            while (temp% i == 0){
                hashSetB.add(i);
                temp = temp/ i;
            }
        }
        hashSetB.add(temp);
//        System.out.println(hashSetB.size());
        HashSet<Long> xorSet = new HashSet<>();
        xorSet.addAll(hashSetA);
        xorSet.addAll(hashSetB);
        hashSetA.retainAll(hashSetB);
        xorSet.removeAll(hashSetA);
        result = xorSet.stream()
                .reduce(1L, (subResult, ele) -> subResult * ele);

        return result;
    }
}
