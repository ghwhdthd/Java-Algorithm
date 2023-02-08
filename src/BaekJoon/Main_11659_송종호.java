package day_0208.ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11659_송종호 {
    //수의 개수 : N
    //합을 구해야하는 횟수 : M
    //합을 구해야하는 구간 from, to
    static int N;
    static int M;
    static int from;
    static int to;
    static int[] arr;
    static int[] sumArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N =Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        sumArr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        //합 배열을 따로 만들기
        sumArr[0] = arr[0];
        for(int i=1; i<arr.length; i++){
            sumArr[i] = arr[i] + sumArr[i-1]; 
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken())-1;
            to = Integer.parseInt(st.nextToken())-1;
            int res = 0;
            
            //시작점이 0인 경우
            if(from == 0) {
                res = sumArr[to];
            }
            else{// 시작점이 0이 아닌 경우
                res = sumArr[to] - sumArr[from-1];
            }
            sb.append(res).append("\n");

        }
        System.out.println(sb);
    }
}
