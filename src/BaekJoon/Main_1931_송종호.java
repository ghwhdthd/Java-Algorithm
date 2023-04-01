package ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_1931_송종호 {
    static int[][] arr;
    public static void main(String[] args) throws IOException {

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        arr =new int[N][2];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] == o2[1] ? o1[0]-o2[0] : o1[1] - o2[1];
            }
        });
        int cnt = 0;
        int endtime =-1;
        for(int i = 0 ; i< N; i++){
            if(i == 0){
                endtime = arr[i][1];
                cnt++;
            }
            else{
                if(endtime <= arr[i][0]){
                    cnt++;
                    endtime = arr[i][1];
                }
            }
        }
        System.out.println(cnt);

    }
}
