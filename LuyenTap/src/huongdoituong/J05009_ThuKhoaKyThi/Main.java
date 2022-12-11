package huongdoituong.J05009_ThuKhoaKyThi;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());
        int count = 1;
        float maxGrade = 0;
        ArrayList<ThiSinh> thiSinhs = new ArrayList<>();
        while ( t --> 0){
            ThiSinh thiSinh = new ThiSinh(count++, scanner.nextLine(), scanner.nextLine(), scanner.nextLine()
            , scanner.nextLine(), scanner.nextLine());
            thiSinhs.add(thiSinh);
            maxGrade = Math.max( maxGrade, thiSinh.getTongDiem());
        }
        float finalMaxGrade = maxGrade;
        thiSinhs.stream()
                .filter( thiSinh -> thiSinh.getTongDiem() == finalMaxGrade)
                .sorted()
                .forEach(System.out::println);
    }
}
/*
3
Nguyen Van A
12/12/1994
3.5
7.0
5.5
Nguyen Van B
1/9/1994
7.5
9.5
9.5
Nguyen Van C
6/7/1994
8.5
9.5
8.5
 */