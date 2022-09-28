package huongdoituong.J04006_KhaiBaoLopSinhVien;



import java.text.ParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        Student student = new Student( scanner.nextLine(), scanner.nextLine(),
                scanner.nextLine(), scanner.nextFloat());
        System.out.println(student);
    }
}
