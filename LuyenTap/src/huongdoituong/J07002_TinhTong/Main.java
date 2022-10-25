package huongdoituong.J07002_TinhTong;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("DATA.in"));
        long sum = 0;
        while (scanner.hasNext()){
            String token = scanner.next();
            try{
                int num = Integer.parseInt(token);
                sum += num;
            }catch (NumberFormatException ignored){
            }
        }
        System.out.println(sum);
    }
}
