package ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1759 {
    static char[] arr;
    static int L;
    static int C;
    static char[] out;
    static StringBuilder sb;
    static List<String> strList;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr= new char[C];
        out = new char[L];

        strList = new ArrayList<>();

        sb =new StringBuilder();

        for(int i=0; i<C; i++){
            arr[i] = st.nextToken().charAt(0);
        }
        comb(0,0);

        Collections.sort(strList);
        for(String data : strList){
            System.out.println(data);
        }

    }
    static void comb(int depth, int start){
        if(depth == L){
            out.toString();
            if(lastCheck()){
                Arrays.sort(out);
                String str = "";
                for(int i = 0; i<out.length; i++){
                    str += out[i];
                }
                System.out.println(str);
                strList.add(str);
            }
            return;
        }
        for(int i =start; i<arr.length; i++){
            out[depth] = arr[i];
            comb(depth+1, i+1);

        }
    }
    static boolean lastCheck(){
        int moCnt = 0; //모음 개수
        int jaCnt = 0; // 자음 개수
        for(int i = 0; i<out.length; i++){
            if(out[i] =='a' || out[i] =='e' || out[i] =='i' || out[i] =='o'|| out[i] =='u'){
                moCnt++;
            }
            else {
                jaCnt++;
            }
        }
        if(moCnt <1 || jaCnt <2){
            return false;
        }else {
            return true;
        }
    }
}