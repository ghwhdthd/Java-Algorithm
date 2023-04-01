import java.util.Scanner;

public class Boj_15651 {
    static Scanner sc;
    static int N;
    static int M;
    static int[] arr;

    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[M+1];

    }
    static void rec(int k){
        if(k == M+1){
            for(int i = 1; i<arr.length ;i++ ){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }else{
            for(int i =1; i<=N; i++){
                arr[k] = i;
                rec(k+1);
            }

        }

    }
    public static void main(String[] args) {
        sc = new Scanner(System.in);

        input();
        rec(1);

    }
}
