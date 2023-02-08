package day_0208.ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Main_15650_송종호 {
    static int N;
    static int M;
    static int[] nums;
    static boolean[] check;
    static StringBuilder sb =new StringBuilder();

    static void P(int cnt, int start){
        if (cnt == M){
            for(int i =0; i<nums.length; i++){
                if(i == nums.length-1) {
                    sb.append(nums[i]).append("\n");
                    break;
                }
                sb.append(nums[i]).append(" ");
            }

            return;
        }
        for(int i = start; i<=N; i++){
            nums[cnt] = i; // 난 i를 선택했으니
            P(cnt+1, i+1); //너는 i 뒤부터 선택해
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[M];
        check =new boolean[N+1];
        //nPm
        P(0, 1);

        System.out.print(sb);



    }
}
