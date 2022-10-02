package Ex1_TinhTongSoLong;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    private static final int MAX_INT = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("DATA1.in"));
        long sum = 0;
        while (scanner.hasNext()){
            String token = scanner.next();
            try {
                long num = Long.parseLong(token);
                if( num > MAX_INT) sum += num;
            }catch (NumberFormatException exception){
            }
        }
        System.out.println(sum);
    }
}
