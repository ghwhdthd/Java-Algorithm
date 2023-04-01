package ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1759_송종호 {
    static int L;
    static int C;
    static List<Character> input = new ArrayList<>();
    static char[] res;
    static StringBuilder sb= new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        //cCl
        st = new StringTokenizer(br.readLine());
        for(int i =0; i<C; i++){
            input.add(st.nextToken().charAt(0));
        }
        Collections.sort(input);
        res = new char[L];
        combination(0,0);
        System.out.println(sb);
    }
    //조합
    static void combination(int depth, int start){
        if(depth == L) {
            int vowel= 0;
            int consonat = 0;
            for(int i=0; i<res.length; i++){
                if(res[i] == 'a' ||res[i] == 'e' ||res[i] == 'i' ||res[i] == 'o' ||res[i] == 'u') vowel++;
                else consonat++;
            }
            if(vowel<1) return;
            if(consonat<2) return;

            for(int i=0; i<res.length; i++){
                sb.append(res[i]);
            }
            sb.append('\n');
            return;
        }
        else{
            for(int i = start; i<C; i++){
                 res[depth] = input.get(i);
                combination(depth+1, i+1);
            }
        }
    }
}
