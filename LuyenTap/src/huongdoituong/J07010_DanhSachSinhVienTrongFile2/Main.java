package huongdoituong.J07010_DanhSachSinhVienTrongFile2;



import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        Scanner scanner = new Scanner(new File("SV.in"));
        int repeat = scanner.nextInt();
        scanner.nextLine();
        for (int i = 1; i <= repeat; i++) {
            Student student = new Student( i,  scanner.nextLine(), scanner.nextLine(),
                    scanner.nextLine(), scanner.nextFloat());
            if( i != repeat) scanner.nextLine();
            System.out.println(student);
        }

    }
}
