package codelearn.io;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

public class PermutationString {
    public static void main(String[] args) {
//        System.out.println((new PermutationString()).checkInclusion("adc", "dcda"));

        System.out.println((new ArrayList<>(Arrays.asList(1, 2, 3))).
                equals(new ArrayList<>(Arrays.asList(1, 2, 3))));
    }
    public boolean checkInclusion(String s1, String s2) {
        int s1Length = s1.length();
        int s2Length = s2.length();
        if( s2Length < s1Length) return false;
        int[] s1Model = new int[26];
        int[] s2Window = new int[26];
        for (int i = 0; i < s1Length; i++) {
            s1Model[s1.charAt(i) - 'a']++;
            s2Window[s2.charAt(i) - 'a']++;
        }
        String s1ModelStr = Arrays.toString(s1Model);
        if(s1ModelStr.equals(Arrays.toString(s2Window))){
            return true;
        }
        for (int i = s1Length; i < s2.length(); i++) {
            s2Window[s2.charAt(i - s1Length) - 'a']--;
            s2Window[s2.charAt(i) - 'a']++;
            if(s1ModelStr.equals(Arrays.toString(s2Window))){
                return true;
            }
        }
        return false;
    }

}

/*
1 2 3 4 5 6 7 8
1 2 3 4 5 6 8 7
1 2 3 4 5 7 6 8
1 2 3 4 5 7 8 6
 */
