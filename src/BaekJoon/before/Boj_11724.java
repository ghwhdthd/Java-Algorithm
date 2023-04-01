import java.util.ArrayList;
import java.util.Scanner;

public class Boj_11724 {
    static Scanner sc;
    static int N;
    static int M;
    static boolean[] visit;
    static ArrayList<Integer> link[];
    static int count;
    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();
        link = new ArrayList[N+1]; // 1부터 시작임!!
        for(int i = 1; i<=N; i++){
            link[i] = new ArrayList<>();
        }
        for(int i =0; i<M; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            link[x].add(y);
            link[y].add(x);
        }
    }
    static void dfs(int x){
        // x에 방문할 수 있다는 것을 알고옴.
        visit[x] = true;
        for(int y : link[x]){
            if(visit[y]) continue;
            dfs(y);
        }
    }
    static void pro(){
        visit = new boolean[N+1];
        count =0;
        for(int i=1; i<=N; i++){
            if(!visit[i]){
                dfs(i);
                count++;
            }
        }

    }
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        input();
        pro();
        System.out.println(count);
    }
}
