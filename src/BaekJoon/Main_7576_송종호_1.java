package solve_myself;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7576_송종호_1 {
    static int R, C;
    static int[][] input;
    static int[] dr = {1,-1,0,0};
    static int[] dc = {0,0,-1,1};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Queue<Tomato1> que = new LinkedList<>();
        input = new int[R][C];
        for(int i=0; i<R; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<C; j++){
                input[i][j] = Integer.parseInt(st.nextToken());
                if(input[i][j] == 1){
                    que.add(new Tomato1(i,j,0));
                }
            }
        }
        //input끝
        //bfs의 depth 를 나누려면 큐에 넣을 때 depth를 생각하면 됨
        int res = bfs(que);
        System.out.println(res);

    }
    static int bfs(Queue<Tomato1> que){
        int max = -1;
        while(!que.isEmpty()){
            Tomato1 t =que.poll();
            for(int i = 0; i<4; i++) {
                int nr = t.r + dr[i];
                int nc = t.c + dc[i];
                if (nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
                if (input[nr][nc] != 0) continue;
                //bfs의 depth를 나누려면 que에 넣을 때 depth를 포함해서 넣으면 된다.
                que.add(new Tomato1(nr, nc, t.depth+1));
                input[nr][nc] = 1;
            }
            max = Math.max(t.depth,max);
        }
        boolean zero = false;
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(input[i][j] == 0) zero = true;
            }
        }
        if(zero){
            return -1;
        }
        return max;

    }
}
class Tomato1{
    int r;
    int c;
    int depth;
    public Tomato1(int r, int c, int depth){
        this.r = r;
        this.c = c;
        this.depth = depth;
    }
}
