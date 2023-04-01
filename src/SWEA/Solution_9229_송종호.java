package ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_9229_송종호 {
    static int N;
    static int M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        //조합
        //1000C2는 대략 5000이니까 그냥 풀 수 있음.
        //2개의 합이 M초과 인 경우 continue
        //M인 경우 break
        //M 미만인 경우 우선순위 큐에 저장해서 바로 max값 뽑기
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int T =Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i =1; i<=T; i++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }
            int max = -1;
            boolean end = false;
            Arrays.sort(arr);
            for(int j=0; j<arr.length-1; j++){
                if(arr[j] > M) continue;

                for(int k =j+1; k<arr.length; k++){
                    int tmp =  arr[j] + arr[k];
                    if(tmp > M )continue;
                    if(tmp == M){
                        max = tmp;
                        end = true;
                        break;
                    }
                    if(tmp > max){
                        max = tmp;
                    }
                }
                if(end) break;
            }
            System.out.println("#"+i+" "+ max );

        }
    }

}
