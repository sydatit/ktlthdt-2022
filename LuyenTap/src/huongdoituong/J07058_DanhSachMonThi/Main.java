package huongdoituong.J07058_DanhSachMonThi;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("MONHOC.in"));
        int lap = scanner.nextInt();
        scanner.nextLine();
        ArrayList<MonHoc> list = new ArrayList<>();
        while (lap --> 0){
            MonHoc monHoc = new MonHoc(scanner.nextLine(), scanner.nextLine(), scanner.nextLine());
            list.add(monHoc);
        }
        list.stream()
                .sorted(Comparator.comparing(MonHoc::getMaMon))
                .forEach(System.out::println);

    }
}
