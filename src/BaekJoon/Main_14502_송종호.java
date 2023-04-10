package solve_myself;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_14502_송종호 {
    static int N,M;
    static int [][] input;
    static List<Birus> Blist = new LinkedList<>();
    static List<Wall> Wlist = new LinkedList<>();
    static boolean[][] visit;
    static int[] dr = {1,-1,0,0};
    static int[] dc = {0,0,1,-1};
    static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    public static void main(String[] args) throws IOException {
        //전체에서 조합으로 3개 뽑아서 벽 세우고
        //bfs로 바이러스 퍼뜨려
        //0의 개수 pq에 넣어
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        input = new int[N][M];
        for(int i=0; i<N; i++){
            st =new  StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                input[i][j] =Integer.parseInt(st.nextToken());
                if(input[i][j] == 2) Blist.add(new Birus(i,j));
                if(input[i][j] == 0) Wlist.add(new Wall(i,j));
            }
        }
        //입력 끝
        comb(0, 0);
        System.out.println(pq.peek());
    }
    static void comb(int depth, int idx){
        if(depth == 3){
            pq.offer(bfs());
            return;
        }
        for(int i=idx; i<Wlist.size(); i++){
            int r=Wlist.get(i).r;
            int c=Wlist.get(i).c;
            if(input[r][c] == 1) continue;
            input[r][c] = 1;
            comb(depth + 1, i+1);
            input[r][c] = 0;
        }

    }

    static int bfs(){
        int cnt =0;
        visit = new boolean[N][M];
        Queue<Path_1> que = new LinkedList<>();
        for(int i=0; i<Blist.size(); i++){
            que.add(new Path_1(Blist.get(i).r, Blist.get(i).c));
            visit[Blist.get(i).r][Blist.get(i).c] = true;
        }
        while (!que.isEmpty()){
            Path_1 p = que.poll();
            for(int i=0; i<4; i++){
                int nr = dr[i] + p.r;
                int nc = dc[i] + p.c;
                if(nr<0|| nc<0|| nr>=N ||nc>=M )continue;
                if(input[nr][nc] != 0 )continue;
                if(visit[nr][nc]) continue;
                que.add(new Path_1(nr,nc));
                visit[nr][nc] = true;
            }

        }
        for(int i =0; i<N; i++){
            for(int j=0; j<M; j++){
                if(visit[i][j]) continue;
                else if(input[i][j] == 0) cnt ++;
            }
        }
        return cnt;
    }

}
class Birus {
    int r,c;
    public Birus(int r, int c){
        this.r = r;
        this.c = c;
    }
}
class Wall{
    int r,c;
    public Wall(int r, int c){
        this.r = r;
        this.c = c;
    }
}
class Path_1{
    int r,c;
    public Path_1(int r, int c){
        this.r = r;
        this.c = c;
    }

}