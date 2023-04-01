package ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1244_송종호 {
    static int[] arr;
    static int student;
    static int[][] sex_switch;
    static void male(int num){
        for(int i = num; i<arr.length; i++){

            if(i % num == 0){
                if(arr[i] == 0) arr[i] = 1;
                else arr[i] =0;
            }

        }
    }
    // 0 1 0 1 0 0 0 1
// 0 1 1 1 0 1 0 1

// 1 0 1 0 1 1 0 1
    static void female(int num){
        int tmp = 1;
        while(true){
            if(num - tmp < 1) break;
            if(num + tmp > arr.length-1) break;
            int l = arr[num -tmp];
            int r = arr[num + tmp];
            if(l !=r ) break;
            tmp++;
        }
        int count = tmp -1;
        for(int i = num - count; i<= num + count; i++){
            if(arr[i] == 0) arr[i] = 1;
            else arr[i] =0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr= new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr[0] = -100;

        for(int i =1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        student = Integer.parseInt(br.readLine());
        sex_switch = new int[student][2];

        for(int i =0; i<student; i++){
            st = new StringTokenizer(br.readLine());
            sex_switch[i][0] = Integer.parseInt(st.nextToken());
            sex_switch[i][1] = Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<student; i++){
            if(sex_switch[i][0] == 1){
                male(sex_switch[i][1]);
            }
            else{
                female(sex_switch[i][1]);
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i=1; i<arr.length; i++){
            if(i==arr.length-1) {
                sb.append(arr[i]);
                break;
            }
            sb.append(arr[i] + " ");

            if(i % 20 ==0) sb.append('\n');
        }
        System.out.println(sb.toString());

    }
}


