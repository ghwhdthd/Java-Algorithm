package solve_myself;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_6603_송종호 {
    static List<Integer> input;
    static int[] output;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            sb = new StringBuilder();
            int k =Integer.parseInt(st.nextToken());
            if(k == 0) break;
            input = new LinkedList<>();
            output = new int[6];
            for(int i=0; i<k; i++){
                input.add(Integer.parseInt(st.nextToken()));
            }
            dfs(0, 0);
            sb.append("\n");
            System.out.print(sb.toString());
        }
    }
    static void dfs(int depth, int idx){
        if(depth ==6) {
            for(int i=0; i<6; i++){
                sb.append(output[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=idx; i<input.size(); i++){
            output[depth] = (input.get(i));
            dfs(depth+1, i+1);
        }
    }
}
