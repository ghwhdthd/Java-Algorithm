import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Boj_2839 {
    static Scanner sc;
    static int N;
    static int cnt;
    static void input(){
        N = sc.nextInt();
    }
    static void pro(){
        int tmp;
        int five = 0;
        int three = 0;
        five = N / 5;
        tmp = N % 5;
        if(tmp == 0){
            cnt = five;
        }
        else{
            cnt = five;

            three = tmp /3;
            tmp = tmp % 3;
            if(tmp !=0){
                cnt = -1;
            }
            else{
                cnt = cnt + three;
            }

        }
        if(cnt == -1){
            int min = -1;
            List<Integer> li = new ArrayList<>();

            for(int i = 0; i<=five; i++){
                int a =N - 5*i;
                int tmpCnt = i;
                if(a%3 == 0){
                    tmpCnt = tmpCnt + a/3;
                    li.add(tmpCnt);
                }
            }
            if(li.size() == 0){
                cnt = -1;
            }
            else{
                cnt=Collections.min(li);
            }
        }


    }
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        input();
        pro();
        System.out.println(cnt);

    }
}
