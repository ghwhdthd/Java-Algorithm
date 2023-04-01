import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Boj_14502 {
    static Scanner sc;
    static int N;
    static int M;
    static int[][] dir = {{1,0},{-1,0},{0,-1},{0,-1}};
    static int[][] location;
    static boolean[][] visit;
    static ArrayList<Integer>[] twoLocation;
    static int twoCount;
    static ArrayList<Integer> res;

    static void input(){
        twoCount = 0;
        N = sc.nextInt();
        M = sc.nextInt();
        location = new int[N][M];
        for(int i =0; i<N; i++){
            for(int j=0; j<M; j++){
                location[i][j] = sc.nextInt();
                if(location[i][j] == 2) twoCount++;
            }
        }
    }
    static void dfs(int i, int j){
        visit[i][j] = true;

        for(int k =0; k<4; k++){
            int nx = i + dir[i][0];
            int ny = j + dir[i][1];
            if(nx < 0 || ny < 0 || nx > N || ny >M) continue;
            if(visit[nx][ny]) continue;
            if(location[nx][ny] == 0){
                dfs(nx,ny);
            }
        }
    }
    // 바이러스가 갈 수 있는 영역 다 세는 함수
    static int count(){
        int cnt = 0;
        for(int i = 0; i< N; i++){
            for(int j =0; j<M; j++){
                if(!visit[i][j] && location[i][j] == 0) cnt++;
            }
        }
        return cnt;
    }
    static void changeAndSearch(){

        for(int i =0; i<N; i++){
            for(int j = 0; j<M; j++){
                if(location[i][j] == 0){
                    location[i][j] =1;
                }
                else continue;
                    for(int k =0; k<N; k++){
                        for(int l = 0; l<M; l++){
                            if(location[k][l] == 0){
                                location[i][j] =1;
                            }
                            else continue;
                                for(int m =0; m<N; m++){
                                    for(int n = 0; n<M; n++){
                                        if(location[m][n] == 0){
                                            location[m][n] = 1;
                                            for(int o =0; o<twoLocation.length; o++ ){
                                                int x = twoLocation[o].get(0);
                                                int y = twoLocation[o].get(1);
                                                visit = new boolean[N][M];
                                                dfs(x,y);
                                                res.add(count());

                                            }
                                        }
                                        else continue;
                                        location[m][n] = 0;
                                    }
                                }

                                location[k][l] = 0;
                        }
                    }

                    location[i][j] = 0;
            }
        }


    }
    static void pro(){

        res = new ArrayList<>();
        twoLocation = new ArrayList[twoCount];
        for(int i =0; i<twoCount; i++){
            twoLocation[i] = new ArrayList<>();
        }

        for(int i =0; i<N; i++){
            for(int j=0; j<M; j++){
                if(location[i][j] == 2){
                    twoLocation[i].add(i);
                    twoLocation[i].add(j);
                }
            }
        }
        changeAndSearch();
        //결론
        int cnt = Collections.min(res);
        System.out.println(cnt);
    }

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        input();
        pro();


    }
}
