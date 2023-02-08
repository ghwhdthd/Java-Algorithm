package day_0207;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15649_송종호 {
    static int N;
    static int M;
    static int[] res;
    static int[] selected;
    static StringBuilder sb;
    static void perm(int count){

        if(count > M){
            for(int i = 1; i<res.length; i++){
                sb.append(res[i]).append(' ');
            }
            sb.append('\n');
            return;
        }
        for(int i = 1; i<=N; i++){
            if(selected[i] == 1) continue;
            res[count] = i;
            selected[i] = 1;
            perm(count +1);
            selected[i] = 0;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str= br.readLine();
        StringTokenizer st = new StringTokenizer(str," ");
        sb =new StringBuilder();
        //nPr
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        selected = new int[N+1];
        res = new int[M+1];
        perm(1);
        System.out.println(sb);

    }

}
