package day_0208.ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main_11660_송종호 {


    // N : 표의 크기
    // M : 합을 구해야 하는 횟수
    static int N;
    static int M;
    static int x1;
    static int y1;
    static int x2;
    static int y2;
    static int[][] arr;
    static int[][] sumArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        N =Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        arr= new int[N+1][N+1];
        sumArr = new int[N+1][N+1];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =1;j<=N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i =1; i<=N; i++){
            sumArr[i][1] = arr[i][1];
            for(int j =2; j<=N; j++){
                sumArr[i][j] = arr[i][j] + sumArr[i][j-1];
            }
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            int res= 0;

            for(int j= x1; j<=x2; j++){
                if(y1 == 1){
                    res += sumArr[j][y2];
                }
                else {
                    res = res + sumArr[j][y2] - sumArr[j][y1-1];
                }

            }
            sb.append(res).append("\n");
        }

        System.out.print(sb);

    }

}
