package solve_myself;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17129_송종호 {
    static int N, M;
    static int[][] map;
    static int[] dr = { 1, -1, 0, 0 };
    static int[] dc = { 0, 0, 1, -1 };
    static boolean[][] visit;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visit = new boolean[N][M];
        Queue<Location> que = new LinkedList<>();

        Location location;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                map[i][j] = str.charAt(j) - '0';
                if (map[i][j] == 2) {
                    que.add(new Location(i, j, 0));
                }
            }

        }

        int n = bfs(que);
        if (n != -1) {
            System.out.println("TAK");
            System.out.println(n);
        } else {
            System.out.println("NIE");
        }

    }

    static int bfs(Queue<Location> que) {
        Location l = que.peek();
        visit[l.r][l.c] = true;

        while (!que.isEmpty()) {
            Location current = que.poll();
            // 사방탐색
            for (int i = 0; i < 4; i++) {
                int nr = current.r + dr[i];
                int nc = current.c + dc[i];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M)
                    continue;
                if (visit[nr][nc])
                    continue;
                if (map[nr][nc] == 1)
                    continue;
                // 다 되는 거

                if (map[nr][nc] == 3 || map[nr][nc] == 4 || map[nr][nc] == 5) {
                    return current.depth + 1;
                }
                que.add(new Location(nr, nc, current.depth + 1));
                visit[nr][nc] = true;
            }

        }
        return -1;

    }

}

class Location {
    int r;
    int c;
    int depth;

    public Location(int r, int c, int depth) {
        super();
        this.r = r;
        this.c = c;
        this.depth = depth;
    }

}