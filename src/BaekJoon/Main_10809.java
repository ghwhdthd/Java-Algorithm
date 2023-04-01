package ssafy.algo;

import java.io.*;
import java.util.Arrays;

public class Main_10809 {
    static int[] location = new int[26];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String abc = br.readLine();
        Arrays.fill(location, -1);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<abc.length(); i++){
            char tmp = abc.charAt(i);
            int index = tmp -'a';
            if(location[index] == -1){
                location[index] = i;
            }
        }

        for(int i=0; i<location.length; i++){
            if(i==(location.length-1)) {
                sb.append(location[i]);
                break;
            }
            sb.append(location[i]).append(" ");
        }
        System.out.println(sb);
    }
}
