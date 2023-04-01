import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//단지 번호 붙이기
public class Boj_2667 {
    static int N;
    static String[] home;
    static List<Integer> group;
    static int group_cnt = 0;
    static boolean [][]visit;
    static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};


    static void input(){
        Scanner sc = new Scanner(System.in);
        N=sc.nextInt();
        home = new String[N];
        for(int i = 0; i<N; i++){
            home[i] = sc.next();
        }
    }
    static void pro(){
        group = new ArrayList<>();
        visit = new boolean [N][N];
        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                if(!visit[i][j] && home[i].charAt(j) == '1'){
                    group_cnt = 0;
                    dfs(i,j);
                    group.add(group_cnt);
                }
            }
        }

    }
    static void dfs(int x, int y){
        visit[x][y] = true;
        group_cnt++;

        // 인접한 집으로 새롭게 방문하기
        //상하좌우 4번 방문해야함.
        for(int i = 0; i<4; i++){
            //새로운 x와 y좌표 설정
            int nx = x + dir[i][0]; // nx = x + 1, -1, 0, 0
            int ny = y + dir[i][1]; // ny = y + 0, 0, 1, -1

            //nx, ny가 범위에서 벗어난 경우 continue;
            if(nx < 0 || ny < 0 || nx >=N || ny >= N) continue;

            if(!visit[nx][ny] && home[nx].charAt(ny) == '1'){
                dfs(nx,ny);
            }
        }

    }
    public static void main(String[] args) {
        input();
        pro();
        Collections.sort(group);

        System.out.println(group.size());
        for(int i = 0; i<group.size(); i++){
            System.out.println(group.get(i));
        }


    }
}
