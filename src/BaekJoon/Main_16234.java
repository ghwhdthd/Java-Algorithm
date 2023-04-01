package ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_16234 {

    static int N;
    static int L;
    static int R;
    static int[][] A;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    static int cnt = 0;
    static int totalCnt =0;
    static boolean[][] visit;
    static int groupCnt;
    static int sum;
    static List<Index> li;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //N * N
        N=Integer.parseInt(st.nextToken());

        //1<= L <= R <= 100
        L=Integer.parseInt(st.nextToken());
        R=Integer.parseInt(st.nextToken());
        A = new int[N][N];
        visit = new boolean[N][N];
        for(int i =0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0; j<N; j++){
                A[i][j]= Integer.parseInt(st.nextToken());
            }
        }
// --------------------------------여기까지 입력
        //입력 끝났으니까 process 메서드 호출
        pro();
        System.out.println(totalCnt);
    }
    /**
     * 풀이 정리
     * dfs 사용
     * dfs로 전체를 순회하면서 그룹 개수를 센다.
     * groupCnt 가 N*N개 일때 끝남. (더 이상 국경을 개방하지 않으면 groupCnt == N*N 일테니까)
     *
     */
    static void pro(){
        totalCnt =0;
        while (true){
            li= new ArrayList<>();
            groupCnt = 0;
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    visit[i][j] = false;
                }
            }
            //--------------------------------------사용하는 변수들 초기화

            //하나씩 순회하면서 dfs를 하는데 기존의 그룹으로 잡혔던 곳은 visit 체크를 통해 넘어감
            for(int i =0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(visit[i][j]) continue;
                    sum =0;
                    cnt =0;
                    dfs(i,j); // 예를 들어 0,0에서 시작한 그룹이 하나 만들어짐
                    groupCnt++;

                    int change = sum/cnt; // " (연합의 인구수) / (연합을 이루고 있는 칸의 개수) " 로 인구를 이동시킨다

                    for(int k=0; k<li.size(); k++){
                        //li에는 국경을 허문 나라들의 index가 들어있음. 그래서 해당 국가의 인구를 바꿔줘야함.
                        A[li.get(k).x][li.get(k).y] = change;
                    }
                    //리스트의 쓰임이 끝으니까 초기화 시킨다. <-이거 안해서 계속 틀렸음 주의!
                    li= new ArrayList<Index>();
                    //그룹 하나 만들어지면 해당 그룹의 인구를 이동시키고 다시 다른 그룹 찾아야함.
                    //다른 그룹을 위한 인덱스 li 새로 만드는 거임.
                }
            }

            // 모든 국경선이 닫힌 순간 이후에는 cnt를 셀 필요가 없으니까 break문 뒤에 cnt 를 놓는다.
            if(groupCnt == N*N) break;
            totalCnt++;
        }


    }
    //dfs 구현 + 조건에 맞는 사방탐색 (L<= 두 나라의 인구 차이 <=R)
    static void dfs(int x, int y){
        visit[x][y] = true;
        cnt++;
        sum+=A[x][y];
        li.add(new Index(x,y));
        for(int i=0; i<4; i++){
            int tmpX = x + dx[i];
            int tmpY = y + dy[i];
            if(tmpX < 0 || tmpY < 0 || tmpX > N-1 ||tmpY > N-1 ) continue;
            if(visit[tmpX][tmpY]) continue;
            int tmpRes  = Math.abs(A[x][y] - A[tmpX][tmpY]);
            if(tmpRes >= L && tmpRes <=R){
                dfs(tmpX,tmpY);
            }
        }
    }

}

class Index{
    int x;
    int y;
    Index(int x, int y){
        this.x = x;
        this.y = y;
    }
}
