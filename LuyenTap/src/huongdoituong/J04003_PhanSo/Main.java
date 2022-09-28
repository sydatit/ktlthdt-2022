package huongdoituong.J04003_PhanSo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PhanSo phanSo = new PhanSo( scanner.next(), scanner.next());
        System.out.println(phanSo.toiGian());
    }
}
