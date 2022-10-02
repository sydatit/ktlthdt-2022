package Ex8_LuyenTapLapTrinh;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("LUYENTAP.in"));
        int repeat = Integer.parseInt(scanner.nextLine());
        ArrayList<SinhVien> list = new ArrayList<>();
        while (repeat --> 0){
            String hoTen = scanner.nextLine();
            String[] soLieus = scanner.nextLine().split(" ");
            SinhVien sinhVien = new SinhVien( hoTen, soLieus[0], soLieus[1]);
            list.add(sinhVien);
        }
        list.stream()
                .sorted()
                .forEach(System.out::println);
    }
}
