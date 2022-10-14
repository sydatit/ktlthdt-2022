import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DSA09004_DFSTrenDoThiVoHuong {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int t = scanner.nextInt();
//        while ( t --> 0){
//            int v = scanner.nextInt(), e = scanner.nextInt();
//            ArrayList<Integer>[] dske = new ArrayList[v+ 1];
//            for (int i = 0; i < dske.length; i++) {
//                dske[i] = new ArrayList<>();
//            }
//            for (int i = 0; i < e; i++) {
//                int a = scanner.nextInt(), b = scanner.nextInt();
//                dske[a].add(b);
//                dske[b].add(a);
//            }
//            for (int i = 1; i < dske.length ; i++) {
//                System.out.print(i + ": ");
//                ArrayList<Integer> dskeI = dske[i];
//                dskeI.stream()
//                        .forEach( item -> System.out.print( item + " "));
//                System.out.println();
//            }
//        }
//    }
    // DSA09002
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int soDinh = Integer.parseInt(scanner.nextLine());
        ArrayList<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < soDinh; i++) {
            String[] tapDinhKe = scanner.nextLine().split(" ");
            for (int j = 0; j < tapDinhKe.length; j++) {
                int dinhCuoi = Integer.parseInt( tapDinhKe[j]);
                if( i + 1 < dinhCuoi) pairs.add(new Pair( i + 1, dinhCuoi));
            }
        }
        pairs.forEach( item -> System.out.println(item.getFirst() + " " + item.getSecond()));
    }
}
class Pair{
    private int first;
    private int second;

    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
