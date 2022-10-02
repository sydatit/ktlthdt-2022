package huongdoituong.J07053_XetTuyen;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("XETTUYEN.in"));
        int size = scanner.nextInt();
        scanner.nextLine();
        ArrayList<ThiSinh> thiSinhs = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            ThiSinh thiSinh = new ThiSinh(i + 1 ,scanner.nextLine(), scanner.nextLine(), scanner.nextLine(),
                    scanner.nextLine());
            thiSinhs.add(thiSinh);
        }
        thiSinhs.forEach(System.out::println);
    }
}
