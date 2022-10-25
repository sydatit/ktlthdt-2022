package huongdoituong.J07052_DanhSachTrungTuyen;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("src/huongdoituong/J07052_DanhSachTrungTuyen/THISINH.in"));
        int soThiSinh = Integer.parseInt(scanner.nextLine());

        ArrayList<ThiSinh> thiSinhList = new ArrayList<>();
        ArrayList<Float> diemList = new ArrayList<>();
        for (int i = 1; i <= soThiSinh; i++) {
            ThiSinh thiSinh = new ThiSinh(scanner.nextLine(), scanner.nextLine(), scanner.nextLine(),
                    scanner.nextLine(), scanner.nextLine());
            diemList.add(thiSinh.getTongDiem());
            thiSinhList.add(thiSinh);
        }
        int soChiTieu = scanner.nextInt();
        float diemChuan = 0;
        Collections.sort(thiSinhList);
        if( soChiTieu < 1){
            System.out.println(String.format("%.1f", 0f));
            thiSinhList.stream()
                    .forEach(thiSinh -> {
                        thiSinh.setTrangThai("TRUOT");
                        System.out.println(thiSinh);
                    });
        }else {
            List<Float> listDiemCH = diemList.stream()
                    .sorted(Comparator.reverseOrder())
                    .distinct()
                    .collect(Collectors.toList());
            if( soChiTieu >= listDiemCH.size()){
                diemChuan = listDiemCH.get( listDiemCH.size() - 1);
            }else {
                diemChuan = listDiemCH.get( soChiTieu - 1);
            }
            for (int i = 0; i < thiSinhList.size(); i++) {
                ThiSinh thiSinh = thiSinhList.get(i);
                if( thiSinh.getTongDiem() < diemChuan) thiSinh.setTrangThai("TRUOT");
                else thiSinh.setTrangThai("TRUNG TUYEN");
            }

            System.out.println(String.format("%.1f", diemChuan));
            thiSinhList.forEach(System.out::println);
        }
    }
}
