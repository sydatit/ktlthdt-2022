package dothi.thamkhao.duyet;
import java.util.*;
public class BFS {
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
            bfs(s); System.out.println();
        }
    }
    public static void bfs(int u){
        Queue<Integer> q = new LinkedList<>();
        q.add(u); chuaxet[u] = false;
        while(!q.isEmpty()){
            int v = q.poll();
            System.out.print(v + " ");
            for(Integer x : dske[v]){
                if(chuaxet[x]){
                    q.add(x); chuaxet[x] = false;
                }
            }
        }
    }
}
