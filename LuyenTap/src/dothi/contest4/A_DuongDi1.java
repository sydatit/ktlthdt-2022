package dothi.contest4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class A_DuongDi1 {

    static ArrayList<Integer> dske[];
    static boolean chuaxet[];
    static int truoc[];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-->0){
            int n = in.nextInt(), m = in.nextInt();
            int s = in.nextInt(), x = in.nextInt();
            dske = new ArrayList[n + 5];
            chuaxet = new boolean[n + 5];
            truoc = new int[n + 5];
            for(int i=0;i<=n;i++){
                dske[i] = new ArrayList<>();
                chuaxet[i] = true;
            }
            for(int i=1;i<=m;i++){
                int u = in.nextInt(), v = in.nextInt();
                dske[u].add(v);
            }
            dfs(s, x);
        }
    }
    public static void dfs(int u, int x){

    }
}
/*
1
6 9 1 6
1 2
2 5
3 1
3 2
3 5
4 3
5 4
5 6
6 4
 */