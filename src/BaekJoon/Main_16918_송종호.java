package song;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16918_송종호 {
    static int R,C,N;
    static char[][] input;
    static boolean[][] check;
    static int[] dr = {0,0,-1,1};
    static int[] dc = {1,-1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();


        //N이 짝수일 때 바로 처리
        if(N%2 == 0){
            for(int i=0; i<R; i++){
                for(int j=0; j<C; j++){
                    sb.append('O');
                }
                sb.append('\n');
            }
            System.out.println(sb);
            return;
        }
        //짝수가 아닌 경우
        input = new char[R][C];
        for(int i=0; i<R; i++){
            String str = br.readLine();
            for(int j=0; j<C; j++){
                input[i][j] = str.charAt(j);
            }
        }
        //1, 3, 5, 7, ..
        for(int i=1; i<= N; i++){
            if(i==1) continue; // 3일때 부터 터지니까
            if(i%2 == 0) continue;
            bombCheck();// 0일때 사방탐색해서
            change();

        }
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                sb.append(input[i][j]);
            }
            sb.append('\n');
        }

        System.out.println(sb);

    }

    static void bombCheck(){
        check = new boolean[R][C];// 전부 다 false인 상태
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(input[i][j] == 'O'){
                    //자기도 true
                    check[i][j] = true;
                    for(int k =0; k<4; k++){
                        int nr = i + dr[k];
                        int nc = j + dc[k];
                        if(nr <0 || nc <0 || nr >=R || nc>= C) continue;
                        //사방탐색 후 true
                        check[nr][nc] = true;
                    }
                }
            }
        }
    }
    static void change(){
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(check[i][j]){
                   input[i][j] = '.';
                }else{
                    input[i][j] = 'O';
                }
            }
        }
    }
}