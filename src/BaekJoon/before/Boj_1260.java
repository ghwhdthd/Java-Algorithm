import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;




// BFS, DFS
public class Boj_1260 {
    static int N;
    static int M;
    static int V;
    static boolean[] visit;
    static int[][] adj;

    static void input(){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        V = sc.nextInt();
        adj = new int[N+1][N+1];
        visit = new boolean[N+1];
        for(int i = 1; i<=M; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            adj[x][y] = 1;
            adj[y][x] = 1;
        }
    }
    static void pro(){
        dfs(V);


        for(int i = 1; i<= N; i++){
            visit[i] = false;
        }
        System.out.println();
        bfs(V);
    }
    static void dfs(int x){
        visit[x] = true;
        System.out.print(x + " ");
        for(int y = 1; y<=N; y++){
            if(adj[x][y] == 0) continue;
            if(visit[y]) continue;
            dfs(y);
        }
    }
    static void bfs(int x){
        Queue<Integer> que = new LinkedList<>();
        que.add(x);
        visit[x] = true;
        while(!que.isEmpty()){
            x = que.poll();
            System.out.print(x + " ");
            for(int y = 1; y<=N; y++){
                if(visit[y]) continue;
                if(adj[x][y] == 0) continue;
                que.add(y);
                visit[y] = true;
            }
        }

    }
    public static void main(String[] args) {
        input();
        pro();

    }
}
