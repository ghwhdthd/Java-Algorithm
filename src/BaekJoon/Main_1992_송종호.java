package ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main_1992_송종호 {

    static int[][] input;
    static int N;
static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        input = new int[N][N];
        sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                input[i][j] = str.charAt(j) - '0';
            }
        }

        pro(0, 0 ,N,1);
        System.out.println(sb);

    }

    static void pro(int r, int c, int size, int flag) {
        int halfsize = size/2;
        if (check(r,c,size)){
            sb.append(input[r][c]);
            return;
        }else{
             sb.append("(");
            pro(r,c,halfsize,1);
            pro(r, c+halfsize,halfsize,0);
            pro(r+halfsize,c, halfsize,0);
            pro(r+halfsize,c+halfsize, halfsize,2);
            sb.append(")");

        }


    }
    static boolean check(int r, int c, int size) {
        int tmp = input[r][c];
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if(input[i][j] !=tmp) return false;
            }
        }

        return true;
    }
}
