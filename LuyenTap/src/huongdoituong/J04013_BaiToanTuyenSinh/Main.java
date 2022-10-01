package huongdoituong.J04013_BaiToanTuyenSinh;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ThiSinh thiSinh = new ThiSinh(scanner.nextLine(), scanner.nextLine(),
                scanner.nextLine(),scanner.nextLine(), scanner.nextLine());
        thiSinh.setTrangThai(24);
        System.out.println(thiSinh);
    }
}
/*
KV1A002
Hoang Thanh Tuan
5
6
7
 */