package day_0206;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//원재의 메모리 복구하기
public class Solution_1289_송종호 {
    static  BufferedReader br;
    static char [] inArr;
    static int count;
    static boolean check;
    static void input() throws IOException {
        String str = br.readLine();
        inArr = str.toCharArray();
    }
    static void pro(){
        count = 0;
        for(int i = 0; i< inArr.length; i++){
            if( '0'== inArr[i]) continue;

            //1인 경우 바꿔주기
            for(int j = i; j < inArr.length; j++){
                if(inArr[j] == '0') inArr[j] = '1';
                else if (inArr[j] =='1') inArr[j] = '0';
            }
            count ++;

            // 검사
            check = true;
            for(int j = i; j<inArr.length; j++){
                if(inArr[j] == '1') check = false;
            }
            if(check) break;
        }
    }
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i=1; i<=T; i++){
            input();
            pro();
            System.out.println("#" + i + " " + count);

        }
    }
}
