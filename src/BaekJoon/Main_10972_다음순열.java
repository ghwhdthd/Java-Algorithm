package ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10972_다음순열 {
    static  int[] input;
    static int[] arr;
    static boolean[] visit;
    static int[] output;
    static int N;
    static int cnt;
    static int[] reverse;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr= new int[N];

        visit  = new boolean[N];
        output = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());

        }
        reverse = new int[N];
        for(int i = 0; i<N; i++){
            reverse[i] = N-i;
            if(reverse[i] != arr[i]) break;
            if(i == N-1) {
                System.out.println(-1);
                return;
            }
        }


        perm(0);

        System.out.println(sb.toString());
    }
    static void perm(int depth){
        if(cnt == 2) return;
        if(depth == N) {
            if(cnt ==1){
                for(int i=0; i<output.length; i++){
                    sb.append(output[i]).append(" ");
                }
                sb.append('\n');

            }
            cnt++;
            return;
        }
        for(int i=0; i<N; i++){
            if(visit[i]) continue;
            output[depth] = arr[i];
            visit[i] = true;
            perm(depth + 1);
            visit[i] = false;

        }
    }
}
