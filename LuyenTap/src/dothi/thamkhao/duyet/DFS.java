package dothi.thamkhao.duyet;
import java.util.*;
public class DFS {
    static int n, m;
    static ArrayList<Integer> dske[] = new ArrayList[1001];
    static boolean chuaxet[] = new boolean[1001];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-->0){
            n = in.nextInt(); m = in.nextInt();
            int s = in.nextInt();
            for(int i=0;i<=n;i++){
                dske[i] = new ArrayList<>();
                chuaxet[i] = true;
            }
            for(int i=1;i<=m;i++){
                int u = in.nextInt(), v = in.nextInt();
                dske[u].add(v); dske[v].add(u);
            }
            dfs(s);
            System.out.println();
        }
    }
    public static void dfs(int u){
        System.out.print(u + " ");
        chuaxet[u] = false;
        for(Integer v : dske[u]){
            if(chuaxet[v]) dfs(v);
        }
    }
}
