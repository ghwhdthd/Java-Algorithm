package day_0330.live;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_14502_송종호 {
	static int R;
	static int C;
	static int[][] map;
	static int[][] copyMap;
	
	static boolean[][] visited;
	static int[] dc = { 1, 0, -1, 0 };
	static int[] dr = { 0, -1, 0, 1 };

	static int[] arr;
	static int[] numbers;
	static int n;
	static int r = 3;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		copyMap = new int[R][C];
		
		visited = new boolean[R][C];
		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());

			}
		}
		copyMap =map.clone();
		
		// 여기까지 입력 끝

		// dfs
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (map[r][c] == 2)
					dfs(r, c);
			}
		}
		// System.out.println(Arrays.deepToString(map));

		// 조합
		n=R*C;
		arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}
		numbers = new int[r];
		combi(0, 0);

	}

	static void dfs(int r, int c) {
		visited[r][c] = true;
		// 사방탐색
		for (int i = 0; i < 4; i++) {
			int tmpr = r + dr[i];
			int tmpc = c + dc[i];
			if (tmpr < 0 || tmpr >= R || tmpc < 0 || tmpc >= C)
				continue;
			if (visited[tmpr][tmpc])
				continue;
			if (map[tmpr][tmpc] == 1)
				continue;
			map[tmpr][tmpc] = 2;

		}
	}

	public static void combi(int start, int cnt) {
		if (cnt == r) {
			//System.out.println(Arrays.toString(numbers));
			for(int i=0; i<numbers.length; i++) {
				int index = numbers[i];
				
			}
			return;
		}
		for (int i = start; i < n; i++) {
			numbers[cnt] = arr[i];
			combi(i + 1, cnt + 1);
		}
	}
}
