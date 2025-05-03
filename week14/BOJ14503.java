package week14;

import java.io.*;
import java.util.*;

public class BOJ14503 {

	static int n, m, res;
	static int[][] map;
	static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static int[] turn = { 3, 0, 1, 2 }; // 왼쪽으로 90도 도는 경우
	static int[] round = { 2, 3, 0, 1 }; // 뒤로 가는 경우

	static class cleaner { // 청소기 클래스
		int y, x, dir;

		public cleaner(int y, int x, int dir) {
			super();
			this.y = y;
			this.x = x;
			this.dir = dir;
		}

	}

	static cleaner c;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];

		st = new StringTokenizer(br.readLine());
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		c = new cleaner(y, x, d);

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		run();
		System.out.println(res);
	}

	static void run() {
		while (true) {
			if (map[c.y][c.x] == 0) {
				map[c.y][c.x] = 2;
				res++;
			}

			boolean chk = false;

			for (int d = 0; d < 4; d++) { // 4방향 중 청소할 곳 있는지 탐색
				int dy = c.y + dir[d][0];
				int dx = c.x + dir[d][1];
				if (dy < 0 || dy >= n || dx < 0 || dx >= m)
					continue;
				if (map[dy][dx] == 0) {
					chk = true;
					break;
				}
			}
			if (chk) { // 청소할 곳이 있다면 왼쪽으로 90도 돌아서 확인
				c.dir = turn[c.dir];
				int dy = c.y + dir[c.dir][0];
				int dx = c.x + dir[c.dir][1];
				if (dy < 0 || dy >= n || dx < 0 || dx >= m)
					continue;
				if (map[dy][dx] == 0) {
					c.y = dy;
					c.x = dx;
				}
			} else { // 청소할 곳이 없다면 뒤로 한칸 이동
				int dy = c.y + dir[round[c.dir]][0];
				int dx = c.x + dir[round[c.dir]][1];
				if (dy < 0 || dy >= n || dx < 0 || dx >= m || map[dy][dx] == 1)
					return;
				else {
					c.y = dy;
					c.x = dx;
				}
			}
		}
	}

}

