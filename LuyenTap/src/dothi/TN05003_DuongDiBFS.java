package dothi;

import java.util.*;

public class TN05003_DuongDiBFS {

    static ArrayList<Integer> dske[];
    static boolean chuaxet[];
    static int truoc[];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-->0){
            int n = in.nextInt(), m = in.nextInt();
            int s = in.nextInt();
            dske = new ArrayList[n + 5];
            chuaxet = new boolean[n + 5];
            truoc = new int[n + 5];
            for(int i=0;i<= n ;i++){
                dske[i] = new ArrayList<>();
                chuaxet[i] = true;
            }
            for(int i=1;i<=m;i++){
                int u = in.nextInt(), v = in.nextInt();
                dske[u].add(v);
                dske[v].add(u);
            }

            bfs(s);
            for (int i = 1; i <= n; i++) {
                if( i != s){
                    if( !chuaxet[i] ){
                        ArrayList<Integer> kq = new ArrayList<>();
                        int dinhTr = i;
                        kq.add(dinhTr);
                        while (dinhTr != s){
                            dinhTr = truoc[dinhTr];
                            kq.add(dinhTr);
                        }
                        Collections.reverse(kq);
                        kq.stream()
                                .forEach( integer -> System.out.print( integer + " "));
                        System.out.println();
                    }else System.out.println("No path");
                }
            }
        }
    }
    public static void bfs(int u){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(u); chuaxet[u] = false;
        while (!queue.isEmpty()) {
            Integer dinhDuyet = queue.poll();
            for (Integer item :dske[dinhDuyet]) {
                if( chuaxet[item]){
                    chuaxet[item] = false;
                    queue.add(item);
                    truoc[item] = dinhDuyet;
                }
            }
        }
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