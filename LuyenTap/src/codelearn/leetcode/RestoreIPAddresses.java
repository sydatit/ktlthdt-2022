package codelearn.io;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
    public static void main(String[] args) {
        String s = "Hello Anh";
        RestoreIPAddresses ipAddresses = new RestoreIPAddresses();
        System.out.println(ipAddresses.restoreIpAddresses("0279245587303"));
    }
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        int minL = 1;
        int maxL = 3;
        System.out.println( minL + " " + maxL);
        for (int i = minL; i <= maxL; i++) {
            for (int j = minL; j <= maxL; j++) {
                for (int k = minL; k <= maxL; k++) {
                    System.out.println(i + " " +j + " " + k + " ---- ");
                    if( i + j + k >= s.length())
                        continue;
                    String strCheck = checkIP(i, j, k, s);
                    if( strCheck.length() > 0) result.add(strCheck);
                }
            }
        }
        return result;
    }

    private String checkIP(int i, int j, int k, String s) {
        int index = 0;
        String s1 = s.substring(index, index += i);
        String s2 = s.substring(index, index += j);
        String s3 = s.substring(index, index += k);
        String s4 = s.substring(index);
        if( checkNumberValid(s1) && checkNumberValid(s2) &&
                checkNumberValid(s3) && checkNumberValid(s4)){
            return String.format("%s.%s.%s.%s", s1, s2, s3, s4);
        }
        return "";
    }

    private boolean checkNumberValid(String s) {
        if( s.equals(""))
            return false;
        System.out.println(s + " ++++ ");
        if( (s.length() > 1 && s.charAt(0) == '0') || Long.parseLong(s) > 255){
            return false;
        }
        return true;
    }
}
