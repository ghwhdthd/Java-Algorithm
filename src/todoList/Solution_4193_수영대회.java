package song;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_4193_수영대회 {
	static int T, N, sr, sc, er, ec;
	static int[][] input;
	static boolean[][] visit;
	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
	static List<Tornado> tornado;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st;
			N = Integer.parseInt(br.readLine());
			input = new int[N][N];
			visit = new boolean[N][N];
			tornado= new LinkedList<>();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					input[i][j] = Integer.parseInt(st.nextToken());
					//소용돌이 위치 추가
					if(input[i][j] == 2) {
						tornado.add(new Tornado(i, j));
					}
				}
			}
			
			st= new StringTokenizer(br.readLine());
			sr = Integer.parseInt(st.nextToken());
			sc = Integer.parseInt(st.nextToken());
			
			st= new StringTokenizer(br.readLine());
			er = Integer.parseInt(st.nextToken());
			ec = Integer.parseInt(st.nextToken());

			
			//입력 끝
			Queue<Path> que = new LinkedList<Path>();
			//시작을 que에 넣고 시작
			que.add(new Path(sr, sc, 0));
			int res =bfs(que);
			System.out.println(res);
			
			
			
		}
	}
	static int bfs(Queue<Path> que) {
		//각 que에서 뺀 depth를 확인하면서 소용돌이 숫자를 바꿔주기
		// visit도 바꿔줘야함.
		boolean tornadoOff = false;
		while(!que.isEmpty()) {
			// false일때 소용돌이 도는 중 true일 때 멈춤
			
			
			Path p = que.poll();
			visit[p.r][p.c] = true;
			
			//depth == 2가 되는 순간 0이 됨
			if((p.depth % 3) == 2) {
				if(!tornadoOff) change();
				tornadoOff = true;
			}
			for(int i=0; i<4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				if(nr<0 || nc<0 || nr>=N || nc >=N) continue;
				if(visit[nr][nc]) continue;
				//1이면 넘기고
				if(input[nr][nc] == 1 )continue;
				//소용돌이 돌고 있으면 기다려야함
				if(input[nr][nc] == 2 ) {
					//좌표는 그대로 depth 만 ++
					que.add(new Path(p.r, p.c, p.depth+1));
					continue;
				}
				//도착지에 도착하는 순간 depth를 return
				if(nr == er && nc == ec) {
					return p.depth+1;
				}
				que.add(new Path(nr, nc, p.depth+1));
				visit[nr][nc] =true;
			}
			//소용돌이가 멈췄을 때
			//위에서 depth랑 flag를 같게 만들어줬는데 depth가 1 증가하면 flag랑 달라지겠지? 
			//그래서 그 순간에 원복해주느 거임.
			
			if(tornadoOff) {
				if((p.depth%3) ==0) {
					change();
				}
			}
		}
		return -1;
	}
	
	static void change() {
		for(Tornado t : tornado) {
			if(input[t.r][t.c] ==2)input[t.r][t.c] =0;
			else if(input[t.r][t.c] ==0)input[t.r][t.c] =2;
		}
	}
}
class Path {
	int r,c,depth;
	public Path(int r, int c, int d) {
		this.r = r;
		this.c = c;
		this.depth = d;
	}
}
class Tornado {
	int r,c;
	public Tornado(int r, int c) {
		this.r = r;
		this.c = c;
	}
}
