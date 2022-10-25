package huongdoituong.J07054_TinhDiemTrungBinh;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("BANGDIEM.in"));
        int soSV = Integer.parseInt(scanner.nextLine());
        ArrayList<SinhVien> sinhViens = new ArrayList<>();
        for (int i = 0; i < soSV; i++) {
            SinhVien sinhVien = new SinhVien(i + 1, scanner.nextLine(), scanner.nextLine(), scanner.nextLine(),
                    scanner.nextLine());
            sinhViens.add(sinhVien);
        }
        Collections.sort(sinhViens);
        int hang = 0;
        for (int i = 0; i < sinhViens.size(); i++) {
            SinhVien sinhVien = sinhViens.get(i);
            if( i == 0 ){
                sinhVien.setXepHang( ++hang);
            }else {
                SinhVien svTruoc = sinhViens.get(i - 1);
                if( svTruoc.getDiemTB() == sinhVien.getDiemTB()){
                    sinhVien.setXepHang( hang);
                }else {
                    hang = i + 1;
                    sinhVien.setXepHang( hang);
                }
            }
        }
        sinhViens.forEach(System.out::println);
    }
}
