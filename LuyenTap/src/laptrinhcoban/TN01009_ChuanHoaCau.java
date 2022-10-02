package laptrinhcoban;

import java.util.Arrays;
import java.util.Scanner;

public class TN01009_ChuanHoaCau {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            String[] words = line.split(" ");
            boolean headLine = true;
            for (int i = 0; i < words.length; i++) {
                if( words[i].equals(".") || words[i].equals("!") || words[i].equals("?")){
                    System.out.print(words[i]+"\n");
                }else {
                    if( words[i].equals(",") || words[i].equals(":")){
                        System.out.printf(words[i]);
                    }else {
                        if( headLine){
                            headLine = false;
                            words[i] = words[i].toLowerCase();
                            char firstC = words[i].charAt(0);
                            words[i].replace(firstC, Character.toUpperCase(firstC));
                            System.out.printf(words[i]);
                        }else {
                            System.out.printf(" " + words[i].toLowerCase());
                        }
                    }
                }
            }
        }
    }
}
