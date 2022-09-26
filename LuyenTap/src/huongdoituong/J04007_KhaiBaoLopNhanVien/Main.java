package huongdoituong.J04007_KhaiBaoLopNhanVien;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try{
            Scanner scanner = new Scanner(System.in);
            NhanVien nhanVien = new NhanVien(scanner.nextLine(), scanner.nextLine(), scanner.nextLine(),
                    scanner.nextLine(), scanner.nextLine(), scanner.nextLine());
            System.out.println(nhanVien);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
