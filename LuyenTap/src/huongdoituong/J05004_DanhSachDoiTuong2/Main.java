package huongdoituong.J05004_DanhSachDoiTuong2;

import java.text.ParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());
        int count = 0;
        while (t --> 0){
            SinhVien sinhVien = new SinhVien(++count, scanner.nextLine(), scanner.nextLine(), scanner.nextLine(),
                    scanner.nextLine());
            System.out.println(sinhVien);
        }
    }
}
/*
1
nGuyEn  vaN    biNH
D20CQCN01-B
2/12/2002
3.19
 */