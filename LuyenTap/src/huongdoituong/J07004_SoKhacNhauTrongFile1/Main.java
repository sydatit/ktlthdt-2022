package huongdoituong.J07004_SoKhacNhauTrongFile1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("VANBAN.in"));
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        while (scanner.hasNextInt()){
            int number = scanner.nextInt();
            if( treeMap.containsKey(number)){
                int oldValue = treeMap.get(number);
                treeMap.put(number, ++oldValue);
            }else {
                treeMap.put(number, 1);
            }
        }
        treeMap.forEach( (k, v) -> System.out.println(k + " " + v));
    }
}
