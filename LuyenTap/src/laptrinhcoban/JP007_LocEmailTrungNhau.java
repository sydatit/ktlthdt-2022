package laptrinhcoban;

import java.util.Scanner;
import java.util.TreeSet;

public class JP007_LocEmailTrungNhau {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeSet<String> listEmail = new TreeSet<>();
        while (scanner.hasNext()){
            String input = scanner.nextLine();
            if( input.equals(""))
                break;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < input.length(); i++) {
                sb.append( Character.toLowerCase( input.charAt(i)));
            }
            listEmail.add(sb.toString());
        }
        listEmail.forEach(System.out::println);
    }
}
