package laptrinhcoban;

import java.util.Scanner;
import java.util.StringTokenizer;

public class TN05_ChuanHoaXauHoTen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int repeat = scanner.nextInt();
        scanner.nextLine();
        while ( repeat --> 0){
            String inputStr = scanner.nextLine();
            System.out.println(chuanHoa(inputStr));
        }
    }

    private static String chuanHoa(String inputStr) {
        StringBuilder sb = new StringBuilder();
        StringTokenizer tokenizer = new StringTokenizer(inputStr);
        while (tokenizer.hasMoreTokens()){
            String word = tokenizer.nextToken();
            sb.append( Character.toUpperCase(word.charAt(0)));
            for (int i = 1; i < word.length(); i++) {
                sb.append( Character.toLowerCase(word.charAt(i)));
            }
            sb.append( " ");
        }
        return sb.toString().trim();
    }
}
