import java.util.Scanner;

public class Boj_1946 {
    static Scanner sc;
    static int N;
    static int [][] score;
    static boolean[][] pass;
    static int count;
    static void input(){
        N = sc.nextInt();
        score = new int[N][2];
        for(int i = 0; i< N; i++){
            for(int j =0; j<2; j++){
                score[i][j] = sc.nextInt();
            }
        }
    }
    static void pro(){
        pass = new boolean[N][2];
        for(int i =0; i<pass.length; i++){
            for(int j=0; j<2; j++){
                pass[i][j] =false;
            }
        }
        int xMin = score[0][0];
        int yMin = score[0][1];

        for(int i = 0; i<score.length; i++){
            if(xMin > score[i][0]){
                xMin = score[i][0];
            }
            if(yMin < score[i][1]){
                yMin = score[i][1];
            }
        }
        int lCount = 0;
        int rCount = 0;
        for(int i = 0; i<score.length; i++){
            if(xMin == score[i][0]){
                for(int j =0; j<score.length; j++){
                    if(score[i][1] < score[j][1]){
                        lCount++;
                    }
                }
            }
        }
        for(int i = 0; i<score.length; i++){
            if(yMin == score[i][1]){
                for(int j =0; j<score.length; j++){
                    if(score[i][0] < score[j][0]){
                        rCount++;
                    }
                }
            }
        }
        if(lCount > rCount){
            System.out.println(lCount);
        }
        else{
            System.out.println(rCount);
        }
    }

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0; i< T; i++){
            input();
            pro();
        }
    }
}
