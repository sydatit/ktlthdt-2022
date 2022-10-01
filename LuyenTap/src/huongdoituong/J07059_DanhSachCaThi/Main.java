package huongdoituong.J07059_DanhSachCaThi;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("CATHI.in"));
        int count = scanner.nextInt();
        scanner.nextLine();
        ArrayList<CaThi> caThis = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            CaThi caThi = new CaThi( i + 1, scanner.nextLine(), scanner.nextLine(), scanner.nextLine());
            caThis.add(caThi);
        }
        caThis.stream()
                .sorted()
                .forEach(System.out::println);
    }
}
