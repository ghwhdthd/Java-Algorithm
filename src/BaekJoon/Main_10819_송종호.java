package solve_myself;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_10819_송종호 {
    static int N;
    static int[] input;
    static int[] output;
    static boolean[] visit;
    static PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        input = new int[N];
        output = new int[N];
        visit = new boolean[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }
        perm(0);
        System.out.println(pq.peek());
    }
    static void perm(int depth){
        if(depth == N) {
            pq.offer(cal());
            return;
        }
        for(int i=0; i<N; i++){
            if(visit[i]) continue;
            output[depth] = input[i];
            visit[i] = true;
            perm(depth+1);
            visit[i] = false;
        }
    }
    static int cal(){
        int res =0;
        for(int i =0; i<N-1; i++){
            res+=Math.abs(output[i]-output[i+1]);
        }
        return res;
    }
}
