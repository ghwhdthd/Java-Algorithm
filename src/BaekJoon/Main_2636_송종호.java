package ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_2636_송종호 {
    static int N;
    static int M;
    static int[][] bArr;
    static int[][] aArr;
    static boolean[][] visit;
    static int[] dr = {1,-1,0,0};
    static int[] dc = {0,0,1,-1};
    static List<Integer> cntList= new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());
        bArr = new int[N][M];
        aArr = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                bArr[i][j] =Integer.parseInt(st.nextToken());
            }
        }

        pro();
        System.out.println(cntList);
        //System.out.println(Arrays.deepToString(bArr));

    }
    static void pro(){
        while (true){
            //visit 초기화
            visit = new boolean[N][M];
            //첫번째로 나오는 0 에서 bfs 시작해서 0을 -1로 바꿔줌 == 구멍찾기
            firstBfs();
            //겉면의 1을 0으로 바꿔줌 + 1의 개수를 세서 리스트에 넣어줌
            int cnt =  melt();
            if(cnt == 0) break;
            cntList.add(cnt);
            // bArr의 -1을 -> 0으로 바꿔주자
            mtoz();
        }


    }
    static void mtoz(){
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(bArr[i][j] == -1) bArr[i][j] = 0;
            }
        }
    }
    static int melt(){
        int cnt = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(bArr[i][j] != 1) continue;
                else{
                    for(int k=0; k<4;k++){
                        int tmpr= i+dr[k];
                        int tmpc= j+dc[k];
                        if(tmpr<0 || tmpr>=N|| tmpc<0|| tmpc>=M) continue;
                        if(bArr[tmpr][tmpc] == -1){
                            bArr[i][j] = 0;
                            break;
                        }
                        //녹은 이후에도 1이면 cnt++
                        if(bArr[i][j] == 1) cnt++;
                    }
                }

            }
        }
        //이번 melt 에 모두 녹았으면 cnt는 0이 리턴됨
        System.out.println(cnt);
        return cnt;
    }
    static void secondBfs(){

    }

    static void initvisit(){
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                visit[i][j] = false;
            }
        }
    }
    static void firstBfs(){
        boolean check = false;


        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(bArr[i][j] == 0) {
                    bfsToMinus1(i,j);
                    check = true;
                    break;
                }
            }
            if (check) break;


        }
    }


    static void bfsToMinus1(int r, int c){
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{r,c});
        visit[r][c] = true;
        bArr[r][c] = -1;
        while (!que.isEmpty()){
            int[] nindex = que.poll();
            int nr = nindex[0];
            int nc = nindex[1];
            //사방탐색
            for(int i =0; i<4;i++){
                int tmpr = nr+dr[i];
                int tmpc = nc+dc[i];
                if(tmpr<0 || tmpr>=N|| tmpc<0|| tmpc>=M) continue;
                if(visit[tmpr][tmpc]) continue;
                if(bArr[tmpr][tmpc] ==1)continue;

                que.add(new int[]{tmpr,tmpc});
                if(bArr[tmpr][tmpc] ==0) bArr[tmpr][tmpc] =-1;
                visit[tmpr][tmpc] = true;

            }
        }

    }
}
