package codelearn.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    public static void main(String[] args) {
        String s = "foo";
        String t = "add";
        System.out.println(new IsomorphicStrings().isIsomorphic(s, t));
    }
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] mapS = new int[256];
        int[] mapT = new int[256];
        Arrays.fill(mapS, -1);
        Arrays.fill(mapT, -1);
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if (mapS[sChar] != -1 && mapS[sChar] != tChar)
                return false;
            if (mapT[tChar] != -1 && mapT[tChar] != sChar)
                return false;
            mapS[sChar] = tChar;
            mapT[tChar] = sChar;
        }
        return true;
    }
}
