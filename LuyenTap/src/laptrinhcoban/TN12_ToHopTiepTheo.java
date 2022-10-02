package laptrinhcoban;

import java.util.HashSet;
import java.util.Scanner;

public class TN12_ToHopTiepTheo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int repeat = scanner.nextInt();
        while (repeat --> 0){
            int N = scanner.nextInt(), K = scanner.nextInt();
            int[] arrayInt = new int[N];
            HashSet<Integer> hashSet = new HashSet<>();
            for (int i = 0; i < K; i++) {
                arrayInt[i] = scanner.nextInt();
                hashSet.add(arrayInt[i]);
            }
            int index = K - 1;
            while ( ( index >= 0) && ( arrayInt[index] == N - K + index + 1)) index--;
            if( index < 0){
                System.out.println(K);
            }else {
                arrayInt[index]++;
                int oldSize = hashSet.size();
                // change element
                hashSet.add(arrayInt[index]);
                for (int i = index + 1; i < K; i++) {
                    arrayInt[i] = arrayInt[i - 1] + 1;
                    hashSet.add(arrayInt[i]);
                }
                System.out.println( hashSet.size() - oldSize);
            }
        }
    }
}
