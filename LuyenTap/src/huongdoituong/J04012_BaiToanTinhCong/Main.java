package huongdoituong.J04012_BaiToanTinhCong;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NhanVien nhanVien = new NhanVien(1, scanner.nextLine(), scanner.nextLine(),
                scanner.nextLine(), scanner.nextLine());
        System.out.println(nhanVien);
    }
}
