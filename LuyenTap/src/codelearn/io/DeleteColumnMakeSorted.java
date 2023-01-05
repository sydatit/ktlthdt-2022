package codelearn.io;

import java.util.ArrayList;

public class DeleteColumnMakeSorted {
    public static void main(String[] args) {
        System.out.println(minDeletionSize( new String[]{"a", "b"}));
    }
    public static int minDeletionSize(String[] strs) {
        int result = 0;
        if( strs.length == 1) return 1;

        boolean[] notSorted = new boolean[strs[0].length()];
        for (int i = 1; i < strs.length; i++) {
            String previousStr = strs[i-1];
            String presentStr = strs[i];
            for (int j = 0; j < presentStr.length(); j++) {
                if( previousStr.charAt(j) > presentStr.charAt(j))
                    notSorted[j] = true;
            }
        }
        for (int i = 0; i < notSorted.length; i++) {
            if( notSorted[i]) result++;
        }
        return result;
    }
}
