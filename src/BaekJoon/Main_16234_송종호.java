package ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_16234_송종호 {
    static int N;
    static int L;
    static int R;
    static int[][] land;
    static boolean[][] visit;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int group_cnt;
    static int group_sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        land = new int[N][N];
        visit = new boolean[N][N];
        pro();



    }
    static void pro(){
        HashMap<Integer,Integer> group = new HashMap<>();
        for(int i =0; i<N ;i++){
            for(int j=0; j<N; j++){
                //아직 방문안했으면 거기로 들어가
                if(!visit[i][j]){
                    group_cnt =0;
                    group_sum = 0;
                    dfs(i,j);
                    //dfs다 하고 왔으면 연합수 알게 됨.
                    group.put(group_cnt, group_sum);
                    //연합 수와 해당 연합의 총합


                }
            }
        }
    }
    static void dfs(int x,int y){
        visit[x][y] =true;
        group_cnt++;
        group_sum += land[x][y];


        for(int i=0; i<4; i++){
            int tmpx = x+ dx[i];
            int tmpy = y+ dy[i];
            if(tmpy>=N || tmpx >=N || tmpx <0 || tmpy<0) continue;
            if(visit[tmpx][tmpy]) continue;
            int tmp = Math.abs(land[x][y] - land[tmpx][tmpy]);
            if(!brokenLine(tmp)) continue;

            dfs(tmpx,tmpy);

        }


    }
    // 경계 허물지 알아내는 메서드
    static boolean brokenLine(int n){ // n은 두 마을의 인구차이
        if(n >= L && n <= R ){
            return true;
        }else{
            return false;
        }
    }
}
