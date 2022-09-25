package laptrinhcoban;

import java.util.Scanner;
import java.util.TreeSet;

public class Ex25_J02006 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lengthA = scanner.nextInt();
        int lengthB = scanner.nextInt();
        TreeSet<Integer> treeSetA = new TreeSet<>();
        TreeSet<Integer> treeSetB = new TreeSet<>();
        for (int i = 0; i < lengthA; i++) {
            treeSetA.add( scanner.nextInt());
        }
        for (int i = 0; i < lengthB; i++) {
            treeSetB.add( scanner.nextInt());
        }
        treeSetA.addAll(treeSetB);
        treeSetA.forEach( integer -> System.out.printf(integer + " "));
    }
}
