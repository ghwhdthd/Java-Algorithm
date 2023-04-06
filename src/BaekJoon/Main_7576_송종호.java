package sjh.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7576_송종호 {
	static int R, C;
	static int[][] input;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	// 그래프 탐색 + 최소값 + 가중치 없으니까 => bfs를 사용!
	// 그래프 탐색 + 최소값 + 가중치 양수면 => 다익스트라!

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		input = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// input 끝

		Queue<Tomato> que = new LinkedList<>();

		// for 문 돌면서 1을 찾고 그걸 que에 넣어
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (input[i][j] == 1) {
					que.add(new Tomato(i, j));
				}
			}
		}

		// 준비 끝 bfs 시작
		int res = bfs(que);
		System.out.println(res);
	}

	// bfs를 돌 때 각 depth 마다 count를 늘리면서 구현해야함.
	// 이걸 어떻게 해야할까?
	// bfs 돌면서 0의 값을 처음 depth에서는 1로 바꾸고
	// 2번 depth에서는 0을 2로 바꾸고
	// 이렇게 숫자를 바꾸면서 bfs로 완탐을 하고 input arr 에서 max값을 구하면 그게 답이다.
	// 숫자를 바꾸면서 가니까 visit도 필요없음 (0 만 처음가는 길인거고 나머지는 왔던 길로 구분이 되니까)
	static int bfs(Queue<Tomato> que) {
		while (!que.isEmpty()) {
			Tomato t = que.poll();
			// 사방탐색
			for (int i = 0; i < 4; i++) {
				int nr = t.r + dr[i];
				int nc = t.c + dc[i];
				if (nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
				if(input[nr][nc] != 0 ) continue;
				//범위도 안벗어나고 0인 값
				//새롭게 가는 곳은 사방탐색의 기준 값 + 1을 넣어주면 됨 
				que.add(new Tomato(nr, nc));
				input[nr][nc] = input[t.r][t.c] + 1;

			}
		}
		//bfs끝났으니까 이제 check하면 끝
		// 0이 하나라도 있으면 바로 break하고 return -1
		int max = Integer.MIN_VALUE;
		boolean zeroCheck = false;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(input[i][j] == 0) {
					zeroCheck = true;
					break;
				}
				max = Math.max(max, input[i][j]);
				
			}
		}
		if(zeroCheck) return -1;
		else return max -1;
		//max -1 하는 이유 : 이미 익어있는 토마토부터 시작하니까 input[t.r][t.c]의 값이 1부터 시작임
		// 그래서 depth가 1일 때 input[nr][nc] = input[t.r][t.c] + 1; 
		// input[nr][nc] 에 2가 들어감
		// 즉 depth가 1일 때 2가 들어가므로 마지막에 -1 해줘야함!
		
		
	}

}

class Tomato {
	int r;
	int c;

	public Tomato(int r, int c) {
		super();
		this.r = r;
		this.c = c;
	}

}