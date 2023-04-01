package ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1987_송종호 {
    static boolean[] abc = new boolean[27];
    //index 1 = A, 2 = B ...27 = Z 로 생각.
    //아스키코드 A : 65, Z : 90
    static int R;
    static int C;
    static char[][] input;
    static boolean[][] visit;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R =Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        input = new char[R][C];
        visit = new boolean[R][C];
        for(int i = 0; i< R; i++){
            String str = br.readLine();
            for(int  j= 0; j<str.length(); j++){
                input[i][j] = str.charAt(j);
            }
        }
        //input 끝
        dfs(0,0, 1);
        System.out.println(max);

    }

    static void dfs(int r, int c , int cnt){

        //tmp = 알파벳을 숫자로 바꿈
        //A = 65 이니까
        // 65-64 = 1 -> A=1
        int tmp = input[r][c] - 64;
        abc[tmp] = true;
        visit[r][c] = true;

        for(int i=0; i<4; i++){
            //사방탐색
            int x = r + dx[i];
            int y = c + dy[i];
            if(x<0 || y<0 || x>=R ||y>=C) continue;
            if(visit[x][y]) continue;
            // input[x][y] 에는 알파벳 대문자 있으니까 -64 하면 위에처럼 숫자로 바뀜
            if(abc[input[x][y] - 64]) continue;
            dfs(x,y, cnt + 1);
            visit[x][y] = false;
            abc[input[x][y] - 64] = false;

        }
        if(max < cnt) max = cnt;


    }


}
