package huongdoituong.J05007_DSToiTuongNhanVien;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        List<NhanVien> nhanViens = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            NhanVien nhanVien = new NhanVien( i + 1, scanner.nextLine(), scanner.nextLine(),
                    scanner.nextLine(), scanner.nextLine(), scanner.nextLine(), scanner.nextLine());
            nhanViens.add(nhanVien);
        }
        nhanViens.stream()
                .sorted()
                .forEach(System.out::println);
    }
}
/*
3
Nguyen Van A
Nam
22/10/1982
Mo Lao-Ha Dong-Ha Noi
8333012345
31/12/2013
Ly Thi B
Nu
15/10/1988
Mo Lao-Ha Dong-Ha Noi
8333012346
22/08/2011
Hoang Thi C
Nu
04/02/1981
Mo Lao-Ha Dong-Ha Noi
8333012347
22/08/2011
 */