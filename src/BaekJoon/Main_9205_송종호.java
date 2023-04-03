package 알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_9205_송종호_1 {

	static int[][] input;
	static int n;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		//테스트 맞음
		for (int t = 0; t < T; t++) {
			n = Integer.parseInt(br.readLine());
			input = new int[n + 2][2]; // 시작 + 끝 + 편의점 개수
			visit = new boolean[n + 2];
			st = new StringTokenizer(br.readLine());
			input[0][0] = Integer.parseInt(st.nextToken());
			input[0][1] = Integer.parseInt(st.nextToken()); // 상근이집

			for (int i = 1; i <= n; i++) {
				st = new StringTokenizer(br.readLine());
				input[i][0] = Integer.parseInt(st.nextToken()); // 편의점
				input[i][1] = Integer.parseInt(st.nextToken());

			}
			st = new StringTokenizer(br.readLine());
			input[n + 1][0] = Integer.parseInt(st.nextToken()); // 페스티벌
			input[n + 1][1] = Integer.parseInt(st.nextToken());
			// BFS
			bfs(input[0][0], input[0][1]); // 상근이 집부터 시작
			if (visit[n + 1]) {
				System.out.println("happy");
			} else {
				System.out.println("sad");
			}
		}

	}

	private static void bfs(int starti, int startj) {
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] { starti, startj });
		visit[0] = true;
		while (!que.isEmpty()) {
			int[] tmp = que.poll();
			int nowx = tmp[0];
			int nowy = tmp[1];
			for (int i = 0; i < n + 2; i++) {
				if (visit[i]) continue;
				int nextx = input[i][0];
				int nexty = input[i][1];
				if ((Math.abs((nowx - nextx)) + Math.abs((nowy - nexty))) <= 1000) {
					
					que.add(new int[] { nextx, nexty });
					visit[i] = true;
				}
			}
		}
	}
}
