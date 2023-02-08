package day_0207.hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1244_송종호 {
    static int[] arr;
    static int student;
    static int[][] sex_switch;
    static void male(int num){
        for(int i= num; i<arr.length; i++){
            if (i == num)continue;
            if(i % num == 0){
                if(arr[i] == 0) arr[i] = 1;
                else if(arr[i] == 1) arr[i] = 0;
            }
        }
    }
    static void female(int num){
        int r = -1;
        int l = -1;
        int tmp = 1;
        int fCount = 0;
        while (true){
            if(num - tmp < 0) break;
            if(num + tmp >= arr.length) break;
            l = arr[num - tmp];
            r = arr[num + tmp];
            if(arr[r] != arr[l]) {
                break;
            }
            else {
                fCount ++;
            }
            tmp ++;
        }
        for(int i = (num - fCount); i<=(num +fCount); i++){
            if(arr[i] == 0) arr[i] = 1;
            else if(arr[i] == 1) arr[i] = 0;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st =new StringTokenizer(br.readLine());

        arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        student = Integer.parseInt(br.readLine());
        sex_switch = new int[student][2];
        for(int i= 0; i<student ;i++){
            sex_switch[i][0] = Integer.parseInt(st.nextToken());
            sex_switch[i][1] = Integer.parseInt(st.nextToken());
        }
        
        for(int i=0; i<student; i++){

            if(sex_switch[i][0] == 1){
                male(sex_switch[i][1]);
            }
            else if (sex_switch[i][0] == 2) {
                 female(sex_switch[i][1]);


            }
        }






        //스위치의 상태를 1번 스위치에서 시작하여 마지막 스위치까지 한 줄에 20개씩 출력한다.
        // 예를 들어 21번 스위치가 있다면 이 스위치의 상태는 둘째 줄 맨 앞에 출력한다.
        // 켜진 스위치는 1, 꺼진 스위치는 0으로 표시하고, 스위치 상태 사이에 빈칸을 하나씩 둔다.

    }
}
