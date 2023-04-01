package ssafy.algo;

import java.io.*;
import java.util.StringTokenizer;

public class Main_2563_송종호 {
    static boolean[][] whitePaper = new boolean[101][101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int startx =Integer.parseInt(st.nextToken());
            int endy =100 - Integer.parseInt(st.nextToken());
            int endx = startx+10;
            int starty = endy-10;
            for (int j = starty; j<endy; j++){
                for(int k =startx; k<endx; k++){
                    if(whitePaper[j][k]) continue;
                    whitePaper[j][k] = true;
                }

            }
        }
        int cnt=0;
        for(int i =0; i<101; i++){
            for(int j =0; j<101; j++){
                if(whitePaper[i][j]) cnt++;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(cnt);
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
