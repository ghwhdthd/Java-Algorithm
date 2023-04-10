package solve_myself;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10974_송종호 {
    static int N;
    static int[] arr;
    static boolean[] visit;
    static int[] output;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr= new int[N];
        visit= new boolean[N];
        output = new int[N];
        for(int i=0; i< N; i++){
            arr[i] = i+1;
        }
        perm(0);
        System.out.println(sb.toString());
    }
    static void perm(int depth){
        if(depth == N) {
            for(int i=0; i<N; i++){
                sb.append(output[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        else{
            for(int i=0; i<N; i++){
                if(visit[i]) continue;
                output[depth] = arr[i];
                visit[i] = true;
                perm(depth +1);

                visit[i] = false;
            }
        }
    }
}
