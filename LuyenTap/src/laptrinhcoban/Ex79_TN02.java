package laptrinhcoban;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex79_TN02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int repeat = scanner.nextInt();
        while (repeat --> 0){
            long number = scanner.nextLong();
            System.out.println(maxPrime(number));
        }
    }

    private static long maxPrime(long number) {
        ArrayList<Long> longArrayList = new ArrayList<>();
        long numberTemp = number;
        if( isPrime(number))
            return number;
        for (long i = 2; i <= Math.sqrt(number) && numberTemp != 1; i++) {
            while (numberTemp % i == 0){
                longArrayList.add(i);
                numberTemp/= i;
            }
        }
        if( numberTemp != 1) return numberTemp;
        return longArrayList.stream().max(Long::compareTo).get();
    }

    private static boolean isPrime(long number) {
        if( number <= 1 || number % 2 == 0 || number % 3 == 0) return false;
        if( number == 2 || number == 3) return true;
        long sqrtN = (long) Math.sqrt(number) + 1;
        for (long i = 6L; i <= sqrtN ; i += 6) {
            if( number % ( i - 1) == 0 || number % ( i + 1) == 0)
                return false;
        }
        return true;
    }
}
