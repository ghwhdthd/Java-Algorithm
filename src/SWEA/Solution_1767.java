package ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_1767 {
    static int N;
    static int [][] arr;
    static boolean[][] line;// 전선이 갈 수 있는 곳 체크
    static List<Index> li = new ArrayList<>();
    static class Index{
        int x;
        int y;
        public Index(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int min = 10000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            line = new boolean[N][N];
            for (int i = 0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j =0; j<N; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    if(arr[i][j] == 1){
                        line[i][j] = false;
                        if(i == 0 || i == N-1 || j==0 || j==N-1) continue;
                        li.add(new Index(i,j));
                    }
                    else line[i][j] = true;
                }
            }


        }


    }
}
