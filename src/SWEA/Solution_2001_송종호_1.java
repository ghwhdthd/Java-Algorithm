package dailyhw.day_0209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Solution_2001_송종호_1 {

    static int[][] inputArr;
    static int[][] sumArr;
    static BufferedReader br;
    static StringTokenizer st;

    static void pro(int N, int M) throws IOException{

        inputArr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                inputArr[i][j]= Integer.parseInt(st.nextToken());
            }
        }
        //sumArr 만들기
        for(int i=0; i<N; i++){
            sumArr[i][0] = inputArr[i][0];
            for(int j=1; j<N; j++){
                sumArr[i][j] = sumArr[i][j-1] + inputArr[i][j];
            }
        }
        //M은 1부터 시작인데 index는 0부터니까
        for(int i=0; i<N; i++){

        }
    }
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            pro(N, M);

        }
    }
}
