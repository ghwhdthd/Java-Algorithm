import java.util.Scanner;

public class Boj_2606 {
    static int N; // 컴퓨터 수
    static int M; // 간선의 수
    static int [][] arr;
    static int com_cnt;
    static boolean []visit;
    static void input(){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N+1][N+1];
        for(int i=0; i<M; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            arr[x][y] = 1;
            arr[y][x] = 1;
        }
    }
    static void pro(){
        visit = new boolean[N+1];
        dfs(1);

    }
    static void dfs(int x){
        visit[x] = true;
        com_cnt++;
        for(int y = 1; y<=N; y++){
            if(visit[y]) continue;
            if(arr[x][y] == 0) continue;
            dfs(y);
        }


    }
    public static void main(String[] args) {
        input();
        pro();

        //1번 컴퓨터는 제외하고 몇 개인지 세야함.
        System.out.println(com_cnt-1);

    }
}
