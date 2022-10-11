package dothi.thamkhao.duyet;
import java.util.*;
public class DuongdiDFS {
    static int n, m;
    static ArrayList<Integer> dske[] = new ArrayList[1001];
    static boolean chuaxet[] = new boolean[1001];
    static int truoc[] = new int[1001];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int test = in.nextInt();
        while(test-->0){
            n = in.nextInt(); m = in.nextInt();
            int s = in.nextInt(), t = in.nextInt();
            for(int i=0;i<=n;i++){
                dske[i] = new ArrayList<>();
                chuaxet[i] = true;
                truoc[i] = 0;
            }
            for(int i=1;i<=m;i++){
                int u = in.nextInt(), v = in.nextInt();
                dske[u].add(v); dske[v].add(u);
            }
            dfs(s);
            if(chuaxet[t]) System.out.println(-1);
            else{
                ArrayList<Integer> kq = new ArrayList<>();
                int x = t;
                while(x!=s){
                    kq.add(x);
                    x = truoc[x];
                }
                kq.add(s);
                Collections.reverse(kq);
                for(Integer tmp: kq){
                    System.out.print(tmp + " ");
                }
                System.out.println();
            }
        }
    }
    public static void dfs(int u){
        chuaxet[u] = false;
        for(Integer v : dske[u]){
            if(chuaxet[v]) {
                dfs(v);
                truoc[v] = u;
            }
        }
    }
}
