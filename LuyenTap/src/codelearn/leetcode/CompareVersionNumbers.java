package codelearn.leetcode;

public class CompareVersionNumbers {
    public static void main(String[] args) {
        CompareVersionNumbers compareVersionNumbers = new CompareVersionNumbers();
        System.out.println(compareVersionNumbers.compareVersion("1.01", "1.001"));
        System.out.println(compareVersionNumbers.compareVersion("1.0", "1.0.0"));
        System.out.println(compareVersionNumbers.compareVersion("0.1", "1.1"));
        System.out.println(compareVersionNumbers.compareVersion("1.0.1", "1"));
    }
    public int compareVersion(String version1, String version2) {
        String[] revisions1 = version1.split("\\.");
        String[] revisions2 = version2.split("\\.");
        for (int i = 0; i < revisions1.length || i < revisions2.length; i++) {
            int revision1 = i < revisions1.length ? Integer.parseInt( revisions1[i]) : 0;
            int revision2 = i < revisions2.length ? Integer.parseInt( revisions2[i]) : 0;
            if (revision1 < revision2) {
                return -1;
            } else if (revision1 > revision2) {
                return 1;
            }
        }
        return 0;
    }
}
