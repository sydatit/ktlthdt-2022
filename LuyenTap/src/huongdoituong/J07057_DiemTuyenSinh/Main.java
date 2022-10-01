package huongdoituong.J07057_DiemTuyenSinh;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("THISINH.in"));
        int soThiSinh = scanner.nextInt();
        scanner.nextLine();
        ArrayList<ThiSinh> list = new ArrayList<>();
        for (int i = 0; i < soThiSinh; i++) {
            ThiSinh thiSinh = new ThiSinh(i + 1, scanner.nextLine(), scanner.nextLine(),
                    scanner.nextLine(), scanner.nextLine());
            thiSinh.setTrangThai(20.5f);
            list.add(thiSinh);
        }
        Collections.sort(list);
        list.forEach(System.out::println);
    }
}
