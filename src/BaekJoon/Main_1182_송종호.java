package solve_myself;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1182_송종호 {
    static int N,S;
    static int[] input;
    static boolean[] isSelected;
    static int[] output;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        input = new int[N];
        output = new int[N];
        isSelected = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for(int i =0; i<N; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }
        part(0);
        System.out.println(cnt);
    }
    static void part(int depth){
        if(depth == N) {
            int res = 0;
            int check=0;

            for (int i = 0; i < N; i++) {
                if(isSelected[i]){
                    res += input[i];
                    check++;
                }

            }
            if(check ==0){
                return;
            }
            if(res == S) cnt++;
            return;
        }

        isSelected[depth] = true;
        part(depth+1);
        isSelected[depth] = false;
        part(depth+1);

    }
}
