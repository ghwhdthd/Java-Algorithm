package 알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//키 순서
public class Solution_5643_송종호 {
	static int T, N, M, cnt,ans;
	static int[][] input;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			input = new int[N + 1][N + 1];
			for (int i = 1; i <= M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int tmpi = Integer.parseInt(st.nextToken());
				int tmpj = Integer.parseInt(st.nextToken());
				input[tmpi][tmpj] = 1;

			}
			ans = 0;
			for (int k = 1; k <= N; k++) {
				cnt = 0;
				gtdfs(k, new boolean[N + 1]);
				ltdfs(k, new boolean[N + 1]);
				if(cnt == N-1) ans++;
			}
			System.out.println("#"+ t +" " +ans);
		}

	}

	static void gtdfs(int cur, boolean[] visited) {

		// cur 정점을 기준으로 자신보다 큰 정점을 탐색
		visited[cur] = true;

		for (int j = 1; j <= N; j++) {
			if (input[cur][j] == 1 && !visited[j]) {
				cnt++;
				gtdfs(j, visited);
			}
		}

	}

	static void ltdfs(int cur, boolean[] visited) {

		// cur 정점을 기준으로 자신보다 큰 정점을 탐색
		visited[cur] = true;

		for (int i = 1; i <= N; i++) {
			if (input[i][cur] == 1 && !visited[i]) {
				cnt++;
				ltdfs(i, visited);
			}
		}

	}
}
