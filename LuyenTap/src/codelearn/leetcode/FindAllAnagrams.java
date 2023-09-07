package codelearn.io;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagrams {
    public static void main(String[] args) {
        System.out.println((new FindAllAnagrams()).findAnagrams("cbaebabacd", "abc" ));
    }
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        List<Integer> model = new ArrayList<>(Arrays.asList(
                0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
        ));
        List<Integer> window = new ArrayList<>(Arrays.asList(
                0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
        ));
        int sL = s.length();
        int pL = p.length();
        if( sL < pL) return result;
        for (int i = 0; i < pL; i++) {
            model.set(p.charAt(i) - 'a', model.get(p.charAt(i) - 'a') + 1 );
            window.set(s.charAt(i) - 'a', window.get(s.charAt(i) - 'a') + 1 );
        }
        if( window.equals(model)) result.add(0);
        for (int i = pL; i < sL; i++) {
            window.set(s.charAt(i - pL) - 'a', window.get( s.charAt(i - pL) - 'a') - 1 );
            window.set(s.charAt(i) - 'a', window.get( s.charAt(i) - 'a') + 1 );
            if( window.equals(model))
                result.add(i -pL + 1);
        }
        return result;
    }

}
