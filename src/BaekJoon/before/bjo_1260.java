import java.util.Scanner;

public class bjo_1260 {
    static int N;
    static int M;
    static int V;
    static boolean [] visit;
    static int [][] adj;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        V = sc.nextInt();

        visit = new boolean[N+1];
        adj = new int[N+1][M+1];

        for(int i =0; i<M; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            adj[x][y] = 1;
            adj[y][x] = 1;
        }


    }
    static void dfs(int x){
        visit[x] = true;
        for(int y = 1; y<=N; y++){
            if(adj[x][y] == 0) continue;
            if(visit[y]) continue;
            dfs(y);
        }
    }
}
