package huongdoituong.J07022_LoaiBoSoNguyen;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    private static Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("DATA.in"));
        HashSet<String> hashSetWord = new HashSet<>();
        HashSet<BigInteger> bigIntegers = new HashSet<>();
        while (scanner.hasNext()){
            String token = scanner.next();

            try{
                int num = Integer.parseInt(token);
            }catch (NumberFormatException ignored){
                if( pattern.matcher(token).matches()){
                    bigIntegers.add( new BigInteger(token));
                }else
                    hashSetWord.add(token);
            }
        }
        bigIntegers.stream().forEach( bigInteger -> System.out.print(bigInteger + " "));
        hashSetWord.stream().forEach(s -> System.out.printf( s + " "));
    }
}
