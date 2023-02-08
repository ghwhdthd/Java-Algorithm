package day_0207.ws;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//우선순위 큐를 사용해서 max min control
public class Solution_1208 {
    static int[] height = new int[100];
    static int dump;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //우선순위 큐로 max와 min 만들기
        for(int tc = 1; tc <= 10; tc++) {
            dump = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

            //넣으면 자동으로 root에 max. min 값 올라옴
            for(int i=0; i<100; i++) {
                height[i] = Integer.parseInt(st.nextToken());
                minHeap.add(height[i]);
                maxHeap.add(height[i]);
            }

            //max 뽑고 - 1, min 뽑고 + 1
            while (dump-- > 0 && maxHeap.element() - minHeap.element() > 1) {
                int minElem = minHeap.poll() + 1;
                int maxElem = maxHeap.poll() - 1;

                //다시 heap에 넣음
                minHeap.add(minElem);
                maxHeap.add(maxElem);
            }

            bw.write(String.format("#%d %d\n", tc, maxHeap.element() - minHeap.element()));

        }

        bw.flush();
        bw.close();
        br.close();
    }
}
