package codelearn.leetcode;

public class StringCompression {
    public static void main(String[] args) {
        char[] chars = {'a'};
        System.out.println(new StringCompression().compress(chars));
    }
    public int compress(char[] chars) {
        int count = 1;
        char currentC = chars[0];
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < chars.length; i++) {
            if( chars[i] != currentC){
                sb.append(currentC).append(count != 1 ? count : "");
                count = 0;
                currentC = chars[i];
            }
            count++;
        }
        sb.append(currentC).append(count != 1 ? count : "");
        char[] result = sb.toString().toCharArray();
        for (int i = 0; i < result.length; i++) {
            chars[i] = result[i];
        }
        return sb.toString().length();
    }
}
