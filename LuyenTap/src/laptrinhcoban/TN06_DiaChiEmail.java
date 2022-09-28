package laptrinhcoban;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class TN06_DiaChiEmail {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int repeat = scanner.nextInt();
        scanner.nextLine();
        Map<String, Integer> emailName = new HashMap<>();
        while (repeat --> 0){
            String inputStr = scanner.nextLine();
            chuanHoa(inputStr, emailName);
        }
    }

    private static void chuanHoa(String inputStr, Map<String, Integer> emailName) {
        StringBuilder sb = new StringBuilder();
        StringBuilder newName = new StringBuilder();
        StringTokenizer tokenizer = new StringTokenizer(inputStr);
        while (tokenizer.hasMoreTokens()){
            String word = tokenizer.nextToken();
            if( !tokenizer.hasMoreTokens()){
                for (int i = 0; i < word.length(); i++) {
                    newName.append(Character.toLowerCase(word.charAt(i)));
                }
                newName.append(sb);
            }else sb.append(Character.toLowerCase(word.charAt(0)));

        }
        if( emailName.containsKey(newName.toString())){
            Integer oldValue = emailName.get(newName.toString());
            oldValue++;
            emailName.replace(newName.toString(), oldValue);
            System.out.println(newName + "" + oldValue + "@ptit.edu.vn");
        }else {
            emailName.put(newName.toString(), 1);
            System.out.println(newName + "@ptit.edu.vn");
        }
    }
}
