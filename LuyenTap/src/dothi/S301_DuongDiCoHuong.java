package dothi;

import java.util.*;

public class S301_DuongDiCoHuong {
    static ArrayList<Integer> dske[];
    static boolean[] chuaxet;
    static int mark[];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int repeat = scanner.nextInt();
        while (repeat --> 0){
            int amountPoint = scanner.nextInt();
            int amountEdge = scanner.nextInt();
            int sourceP = scanner.nextInt();
            int destinationP = scanner.nextInt();
            dske = new ArrayList[amountPoint + 1];
            chuaxet = new boolean[amountPoint + 1];
            mark = new int[amountPoint + 1];
            for (int i = 0; i <= amountPoint; i++) {
                dske[i] = new ArrayList<>();
                chuaxet[i] = true;
            }
            for (int i = 0; i < amountEdge; i++) {
                int headP = scanner.nextInt();
                int lastP = scanner.nextInt();
                dske[headP].add(lastP);
            }
            algorithmBFS(sourceP);
            if( mark[destinationP] != 0){
                Stack<Integer> stack = new Stack<>();
                stack.add(destinationP);
                int previous = mark[destinationP];
                while (previous != sourceP){
                    stack.add(previous);
                    previous = mark[previous];
                }
                stack.add(sourceP);
                while (!stack.isEmpty()){
                    System.out.print(stack.pop());
                    if( !stack.isEmpty()) System.out.print(" -> ");
                }
                System.out.println();
            }else System.out.println(-1);
        }
    }

    private static void algorithmBFS(int sourceP) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(sourceP);
        chuaxet[sourceP] = false;
        while (!queue.isEmpty()){
            Integer headP = queue.poll();
            for (Integer item :dske[headP]) {
                if( chuaxet[item]){
                    chuaxet[item] = false;
                    queue.add(item);
                    mark[item] = headP;
                }
            }
        }
    }
}
