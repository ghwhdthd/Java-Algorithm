import java.util.ArrayList;
import java.util.Scanner;

public class Boj_1012_2 {
    static Scanner sc;
    static int N;
    static int M;
    static int K;
    static int[][] location;
    static ArrayList<Integer>[] linkCheck;
    static boolean[] visit;
    static int count;
    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        location = new int[K][2];
        for(int i =0; i<K; i++){
            location[i][0] = sc.nextInt();
            location[i][1] = sc.nextInt();
        }
    }
    static void link(){
        linkCheck = new ArrayList[K];
        for(int i = 0; i< K; i++){
            linkCheck[i] = new ArrayList<Integer>();
        }
        for(int i =0; i<K; i++){
            for(int j = 0; j< K; j++){
                int x = location[i][0];
                int y = location[i][1];

                int x_1 = location[i][0] - 1;
                int x1 = location[i][0] + 1;
                int y_1 = location[i][1] - 1;
                int y1 = location[i][1] + 1;

                if(x == location[j][0] && y_1 == location[j][1]){
                    linkCheck[i].add(j);
                }
                if(x == location[j][0] && y1 == location[j][1]){
                    linkCheck[i].add(j);
                }
                if(x_1 == location[j][0] && y == location[j][1]){
                    linkCheck[i].add(j);
                }
                if(x1 == location[j][0] && y == location[j][1]){
                    linkCheck[i].add(j);
                }
            }
        }
    }
    static void dfs(int x){
        // x 방문 가능한 거 알고 왔음
        visit[x] = true;
        // x와 연결된 애들 다 돌아야지
        for(int y : linkCheck[x]){
            if(visit[y]) continue;
            dfs(y);
        }
    }
    static void pro(){
        link();
        for(int i = 0; i<K; i++){
            System.out.println(String.valueOf(linkCheck[i]));
        }

        visit = new boolean[K];
        count = 0;
        for(int i =0; i<K; i++){
            if(!visit[i]){

                dfs(i);
                count++;
            }
        }



    }
    public static void main(String[] args) {
        sc =new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0; i<T; i++){
            input();
            pro();
            System.out.println(count);
        }
    }

}
