package day_0208.ws;

import java.util.Scanner;

public class Main_2798_송종호 {
    static int N;
    static int M;
    static int[] arr;
    static int[] tmp = new int[3];
    static boolean[] check;
    static void c(int cnt){
        for(int i =0; i< arr.length; i++){
            if(check[i]) continue;
            tmp[cnt] = arr[i];
            check[i] = true;
            c(cnt +1);
            check[i] = false;


        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N];
        check = new boolean[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        c(0 )
    }

}
