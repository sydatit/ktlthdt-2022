package huongdoituong.J07052_DanhSachTrungTuyen;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("THISINH.in"));
        int soThiSinh = scanner.nextInt();
        scanner.nextLine();
        ArrayList<ThiSinh> thiSinhList = new ArrayList<>();
        for (int i = 1; i <= soThiSinh; i++) {
            ThiSinh thiSinh = new ThiSinh(scanner.nextLine(), scanner.nextLine(), scanner.nextLine(),
                    scanner.nextLine(), scanner.nextLine());
            thiSinhList.add(thiSinh);
        }
        int soChiTieu = scanner.nextInt();
        float diemChuan = 0;
        if( soChiTieu < 1){
            Collections.sort(thiSinhList);
            System.out.println(String.format("%.1f", 0f));
            thiSinhList.stream()
                    .forEach(thiSinh -> {
                        thiSinh.setTrangThai("TRUOT");
                        System.out.println(thiSinh);
                    });
        }else {
            Collections.sort(thiSinhList);
            for (int i = 0; i < thiSinhList.size(); i++) {
                ThiSinh thiSinh = thiSinhList.get(i);
                if( soChiTieu > 0){
                    thiSinh.setTrangThai("TRUNG TUYEN");
                    soChiTieu--;
                    if( i + 1 < thiSinhList.size()){
                        ThiSinh thiSinhSau = thiSinhList.get(i + 1);
                        if( thiSinhSau.getTongDiem() == thiSinh.getTongDiem())
                            soChiTieu++;
                    }
                    if( soChiTieu == 0) diemChuan = thiSinh.getTongDiem();
                } else thiSinh.setTrangThai("TRUOT");
            }

            System.out.println(String.format("%.1f", diemChuan));
            thiSinhList.forEach(System.out::println);
        }
    }
}
