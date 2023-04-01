package ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1946_송종호 {
    //면접 1등의 서류 순위보다 낮은 서류 순위인 애들 다 탈락
    //서류 1등의 면접 순위보다 낮은 면점순위 가진 애들 다 탈락
    static int N;
    static int[][] arr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            N = Integer.parseInt(br.readLine());
            int cnt = N;
            arr = new int[N][2];
            int standard0 = 100001; // 면접 1등의 서류 순위
            int standard1 = 100001; // 서류 1등의 면접 순위

            StringTokenizer st;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                arr[i][0] = (Integer.parseInt(st.nextToken()));
                arr[i][1] = (Integer.parseInt(st.nextToken()));
                if(arr[i][0] == 1) standard1 = arr[i][1];// 서류 1등의 면접 순위
                if(arr[i][1] == 1) standard0 = arr[i][0];// 면접 1등의 서류 순위
            }
            Arrays.sort(arr, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });
            int min = 100001;
            for (int i = 0; i < N; i++) {
                if(arr[i][1] > min) cnt--;
                else if(arr[i][1] < min ) min = arr[i][1];
            }
            System.out.println(cnt);
        }
    }
}
