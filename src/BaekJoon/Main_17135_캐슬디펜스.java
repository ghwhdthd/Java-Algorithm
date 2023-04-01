package ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_17135_캐슬디펜스 {
    static int N;
    static int M;
    static int D;
    static int [][] arr;
    static int[] l; //조합 input 배열
    static int[] output = new int[3];
    static ArrayList<Index> location = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N =Integer.parseInt(st.nextToken());
        M =Integer.parseInt(st.nextToken());
        D =Integer.parseInt(st.nextToken());

        arr = new int[N+2][M+1];
        l = new int[M];
        for(int i =0; i<M; i++){
            l[i] = i+1;
        }


        for(int i=1; i<=N; i++ ){
            st = new StringTokenizer(br.readLine());
            for(int j =1; j<=M; j++ ){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //MC3;
        comb(0, 0);

        //궁수위치까지 완료

        //사격 -> max값 도출
        //이동
        //전부 0인지 체크


    }
    static void comb(int depth, int start){
        if(depth == 3){
            location.add(new Index(output[0],output[1],output[2]) );
            return;
        }
        for(int i = start; i<M; i++){
            output[depth] = l[i];
            comb(depth+1,i+1 );
        }
    }
    static class Index{
        int a1;
        int a2;
        int a3;
        //궁수의 위치
        public Index(int a1, int a2, int a3) {
            this.a1 = a1;
            this.a2 = a2;
            this.a3 = a3;
        }
    }
}
