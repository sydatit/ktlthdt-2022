package huongdoituong.J07001_DocFileVanBan;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("VANBAN.in"));
        while (scanner.hasNext()){
            System.out.println(scanner.nextLine());
        }
    }
}
