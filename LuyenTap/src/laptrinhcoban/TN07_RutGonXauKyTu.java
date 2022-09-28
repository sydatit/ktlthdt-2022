package laptrinhcoban;

import java.util.LinkedList;
import java.util.Scanner;

public class TN07_RutGonXauKyTu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(trimInputString(input));
    }

    private static String trimInputString(String input) {
        LinkedList<Character> linkedList = new LinkedList<>();
        int length = input.length();
        for (int i = 0; i < length; i++) {
            linkedList.add(input.charAt(i));
        }
        int index = 0;
        while ( index < length - 1){
            if( linkedList.get(index) == linkedList.get(index + 1)){
                linkedList.remove(index);
                linkedList.remove(index);
                length = linkedList.size();
                index = 0;
            }else index++;
        }
        if( linkedList.isEmpty()) return "Empty String";
        else return
                linkedList.stream()
                        .map(Object::toString)
                        .reduce("",  (partialString, character) -> partialString + character).trim();
    }
}
