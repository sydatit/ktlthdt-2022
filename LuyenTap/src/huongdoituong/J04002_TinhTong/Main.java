package huongdoituong.J04002_TinhTong;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("src/huongdoituong/J04002_TinhTong/DATA.in"));
        int sum = 0;
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
