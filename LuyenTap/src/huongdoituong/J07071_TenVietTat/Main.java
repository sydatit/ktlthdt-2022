package huongdoituong.J07071_TenVietTat;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new File("DANHSACH.in"));
        int soHoTen = Integer.parseInt(scanner.nextLine());
        List<DoiTuong> doiTuongs = new ArrayList<>();
        for (int i = 0; i < soHoTen; i++) {
            DoiTuong doiTuong = new DoiTuong( scanner.nextLine());
            doiTuongs.add(doiTuong);
        }
        doiTuongs = doiTuongs.stream()
                            .sorted().collect(Collectors.toList());
        int soTenVT = Integer.parseInt(scanner.nextLine());
        String[] tvts = new String[soTenVT];
        for (int i = 0; i < soTenVT; i++) {
            tvts[i] = scanner.nextLine();
        }
        soKhop( doiTuongs, tvts, soTenVT);
    }

    private static void soKhop(List<DoiTuong> doiTuongs, String[] tvts, int soTenVT) {
        for (String item: tvts  ) {
            String[] kiTu = item.split("\\.");
            for (int i = 0; i < doiTuongs.size(); i++) {
                DoiTuong doiTuong = doiTuongs.get(i);
                if( kiTu.length == doiTuong.getTenVietTat().length()){
                    String tvt = doiTuong.getTenVietTat();
                    if( checkTVT( tvt, kiTu)){
                        System.out.println(doiTuong);
                    }
                }
            }
        }
    }

    private static boolean checkTVT(String tvt, String[] kiTu) {
        for (int i = 0; i < kiTu.length; i++) {
            if( tvt.charAt(i) != kiTu[i].charAt(0) && kiTu[i].charAt(0) != '*'){
                return false;
            }
        }
        return true;
    }
}


