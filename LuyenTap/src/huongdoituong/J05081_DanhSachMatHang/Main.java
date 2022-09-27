package huongdoituong.J05081_DanhSachMatHang;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        ArrayList<MatHang> list = new ArrayList<>();
        for (int i = 1; i <= n ; i++) {
            MatHang matHang = new MatHang(i, scanner.nextLine(), scanner.nextLine(),
                    scanner.nextLong(), scanner.nextLong());
            list.add(matHang);
            scanner.nextLine();
        }
        Collections.sort(list);
        list.forEach(System.out::println);
    }
}
