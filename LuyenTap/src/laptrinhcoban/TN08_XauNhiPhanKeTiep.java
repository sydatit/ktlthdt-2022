package laptrinhcoban;

import java.util.ArrayList;
import java.util.Scanner;

public class TN08_XauNhiPhanKeTiep {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int repeat = scanner.nextInt();
        scanner.nextLine();
        while (repeat --> 0){
            String input = scanner.nextLine();
            ArrayList<Character> list = new ArrayList<>();
            int length = input.length();
            for (int i = 0; i < length; i++) {
                list.add(input.charAt(i));
            }
            boolean change = false;
            for (int i = length -1; i >= 0; i--) {
                if( list.get(i) == '0'){
                    list.set(i, '1');
                    int j = i+1;
                    while ( j < length){
                        list.set(j++, '0');
                    }
                    change = true;
                    break;
                }
            }
            if(!change){
                list.forEach( c -> System.out.print("0"));
                System.out.println();
            }else {
                list.forEach( c -> System.out.printf(c + ""));
                System.out.println();
            }
        }
    }
}
