package ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//색종이문제
//둘레 구하는 방법 : 내가 true인데 내 사방(위, 아래, 좌, 우)가 false일 때마다 cnt++해주면 됨.
//단, 둘레가 사방 끝에 겹쳐있는 경우는 그냥 cnt++
/**
 * 1 1 1 1      ->      2 1 1 2        -> 둘레는 16
 * 1 1 1 1              1 1 1 1
 * 1 1 1 1              1 1 1 1
 * 1 1 1 1              2 1 1 2
 * */
public class Main_2567_송종호 {
    static int N;
    static boolean[][] drawingPaper = new boolean[101][101];
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i =0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            fillDrawPaper(r,c);
        }
        int res = count();
        System.out.println(res);
    }
    static void fillDrawPaper(int r, int c){
        for(int i = r;i < r+10; i++){
            for(int j=c; j< c+10; j++){
                if(drawingPaper[i][j]) continue;
                else drawingPaper[i][j] = true;
            }
        }
    }


    static int count(){
        int cnt = 0;
        for(int i =1; i<=100; i++){
            for(int j =1; j<=100; j++){
                if(drawingPaper[i][j] == true){
                    for(int k =0; k<4; k++){
                        int tmpx = dx[k] + i;
                        int tmpy = dy[k] + j;
                        if(tmpx < 1 || tmpx > 100 || tmpy < 1|| tmpy > 100) cnt++; // 색칠된 둘레가 사방 끝에 있는 경우
                        else{
                            if(!drawingPaper[tmpx][tmpy]) {
                                cnt++;
                            }

                        }
                    }
                }
            }
        }
        return cnt;
    }
}
