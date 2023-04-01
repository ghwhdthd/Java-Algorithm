package ssafy.algo;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15651_송종호 {
    static int N;
    static int M;
    static int[] arr;
    static int[] res;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        res = new int[M];
        for(int i =0; i<N; i++){
            arr[i] = i+1;
        }
        comb(0);
        System.out.println(sb);

    }
    static void comb(int depth){
        if(depth == M) {
            for(int i =0; i<M; i++){
                sb.append(res[i]).append(" ");
            }
            sb.append('\n');
            return;
        }else{
            for(int i=0; i<N; i++){
                res[depth] = arr[i];
                comb(depth+1);
            }
        }


    }
}
