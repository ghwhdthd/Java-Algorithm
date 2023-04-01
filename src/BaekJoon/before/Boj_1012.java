import java.util.ArrayList;
import java.util.Scanner;

public class Boj_1012 {
    static Scanner sc;
    static int M;
    static int N;
    static int K;
    static int[][] location;
    static ArrayList<Integer> []linkCheck;
    static boolean[] visit;
    static int count;
    static void input(){
        N = sc.nextInt();// 가로 0 ~ N-1
        M = sc.nextInt();// 세로 0 ~ M-1
        K = sc.nextInt();
        location = new int[K][2];
        for(int i=0; i<K; i++){
            location[i][0] = sc.nextInt();
            location[i][1] = sc.nextInt();
        }

    }
    static void link(){
        linkCheck = new ArrayList[K];
        for(int i = 0; i<K; i++){
            linkCheck[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i<K; i++){
            int x = location[i][0];
            int y = location[i][1];

            int x_1 = location[i][0] -1;
            int x1 = location[i][0] +1;
            int y_1 = location[i][1] -1;
            int y1 = location[i][1] +1;
            for(int j = 0; j<K; j++){
                if(location[j][0] == x && location[j][1] == y_1){
                    linkCheck[i].add(j);
                }
                if(location[j][0] == x && location[j][1] == y1){
                    linkCheck[i].add(j);
                }
                if(location[j][0] == x_1 && location[j][1] == y){
                    linkCheck[i].add(j);
                }
                if(location[j][0] == x1 && location[j][1] == y){
                    linkCheck[i].add(j);
                }
            }
        }


    }

    static void dfs(int x){
        //x는 방문했어
        visit[x] = true;
        //x랑 연결되어있는 애들 찾아서 들어가서 방문해
        for (int y : linkCheck[x]) {
            if (visit[y]) continue;
            dfs(y);
        }

    }

    static void pro(){
        visit = new boolean[K];
        link();
        count = 0;
        for(int i =0; i<K; i++){
            if(!visit[i]){
                dfs(i);
                count++;
            }
        }
    }

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0; i<T; i++){
            input();
            pro();
            System.out.println(count);

        }
    }
}
