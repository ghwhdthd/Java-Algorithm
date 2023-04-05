package day0405.ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14890_송종호 {

	// 가로 점검 함수 true -> ans++
	// 세로 점검 함수 true -> ans++

	// 이제 점검을 어떻게 할건지 생각

	// 왼쪽, 위에서 시작을 가정
	// 올라가는 경우(오르막 길)와 내려가는 경우(내리막 길)로 나뉨
	// 올라가는 경우 올라간 시점 idx - 1한 부분 부터 x길이만큼 같은 숫자여야함
	// 내려가는 경우 내려간 시점 idx부터 x 길이만큼 같은 숫자여야함 아니면 false
	// 이미 경사로 만들었으면 체크도 해줘야함.

	static int  N, L, ans;
	static int[][] map;
	static boolean[] check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {

					map[i][j] = Integer.parseInt(st.nextToken());

				}
			}

			ans = 0;

			// 가로 세로 점검
			for (int i = 0; i < N; i++) {

				if (garo(i))
					ans++;
				if (sero(i))
					ans++;

			}
			System.out.println( ans);		
	}

	static boolean garo(int i) {
		check = new boolean[N];
		for (int j = 0; j < N; j++) {
			int n = map[i][j]; // 기준값은 n, 기준 idx는 j
			if (j == N - 1)
				return true; // j가 끝까지 갔으니까 true
			int next = map[i][j + 1];

			int incline = next - n;
			// 평지
			if (incline == 0)
				continue;

			// 내리막
			else if (incline == -1) {
				// 내리막은 next 부터 봐야지
				int start = j + 1;
				int end = start + L;

				if (end > N)
					return false;// 경사로가 map의 범위를 넘어가는 경우
				for (int k = start; k < end; k++) {
					if (check[k])
						return false;
					if (next != map[i][k])
						return false; // 경사로가 못 들어가는 경우
					check[k] = true;
				}
			}
			// 오르막
			else if (incline == 1) {
				// 오르막은 이전 꺼를 봐야지
				int start = j;
				int end = j - L + 1;
				if (end < 0)
					return false;// 경사로가 map의 범위를 넘어가는 경우
				for (int k = start; k >= end; k--) {
					if (check[k])
						return false;
					if (n != map[i][k])
						return false; // 경사로가 못 들어가는 경우
					check[k] = true;
				}
			}
			// 경사의 차이가 2이상인 경우 그냥 false
			else {
				return false;
			}
		}

		return false;

	}

	static boolean sero(int j) {
		check = new boolean[N];
		for (int i = 0; i < N; i++) {
			int n = map[i][j]; // 기준값은 n, 기준 idx는 i
			if (i == N - 1)
				return true; // i가 끝까지 갔으니까 true
			int next = map[i + 1][j];

			int incline = next - n;
			// 평지
			if (incline == 0)
				continue;

			// 내리막
			else if (incline == -1) {
				// 내리막은 next 부터 봐야지
				int start = i + 1;
				int end = start + L;
				if (end > N)
					return false;// 경사로가 map의 범위를 넘어가는 경우
				for (int k = start; k < end; k++) {
					if (check[k])
						return false;
					if (next != map[k][j])
						return false; // 경사로가 못 들어가는 경우
					check[k] = true;
				}
			}
			// 오르막
			else if (incline == 1) {
				// 오르막은 이전 꺼를 봐야지
				int start = i;
				int end = i - L + 1;
				if (end < 0)
					return false;
				for (int k = start; k >= end; k--) {
					if (check[k])
						return false;
					if (n != map[k][j])
						return false; // 경사로가 못 들어가는 경우
					check[k] = true;
				}
			}
			// 경사의 차이가 2이상인 경우 그냥 false
			else {
				return false;
			}
		}
		return false;

	}

}