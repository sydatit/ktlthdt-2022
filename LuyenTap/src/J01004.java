import java.util.Scanner;

public class J01004 {
    public static boolean soNguyenTo(long number){
        if( number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if( number % i == 0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while ( t --> 0){
            long number = scanner.nextLong();
            if( soNguyenTo(number)) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
