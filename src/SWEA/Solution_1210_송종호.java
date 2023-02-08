package day_0207;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1210_송종호 {
    static int[][] arr= new int[100][100];
    static boolean[][] check = new boolean[100][100];

    static int arriveIndex;
    static int []dr = {0,0,-1,1};

    static int []dc = {-1,1,0,0};
   static int RES;
   static int T;
    static BufferedReader br;
    static void input()throws IOException {
        T = Integer.parseInt(br.readLine());
        for(int i=0; i<10; i++){
            for(int j=0; j<100; j++){
                StringTokenizer st =new StringTokenizer(br.readLine());
                int k =0;
                while (st.hasMoreTokens()){
                    arr[j][k] = Integer.parseInt(st.nextToken());
                    k++;
                }
        }

        }

    }
    //체크확인하고 -> 양옆 -> 위로 -> 이동 후 체크
    static void pro(){
        for(int i = 0; i<100; i++){
            if(arr[99][i] == 2){
                arriveIndex = i;
                break;
            }
        }
        find(99,arriveIndex);

    }
    static void find(int row, int col){


        if(row == 0) {
            RES = col;
            return;
        }
        for(int i = 0; i < dr.length; i++) {
            int nr = row + dr[i];
            int nc = col + dc[i];

            if(nr > 99) continue;
            if(nr < 0) continue;
            if(nc > 99) continue;
            if(nc < 0) continue;

            if(arr[nr][nc] == 1){
                if(!check[nr][nc]) {
                    check[nr][nc] = true;
                    find(nr,nc);

                }
            }

        }
    }
    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        for(int i =1; i<=10; i++){
            input();
            pro();
            System.out.println("#" + T+ " "+ RES);
        }
    }
}
