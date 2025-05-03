package week13;

import java.io.*;
import java.util.*;

public class BOJ2206 {

	static int n, m;
	static int[][] map;
	static boolean[][][] visited;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	static class Cell {
		int y, x, wall;

		public Cell(int y, int x, int wall) {
			super();
			this.y = y;
			this.x = x;
			this.wall = wall;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		visited = new boolean[n][m][2];

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		bfs();
	}

	static void bfs() {
		Queue<Cell> list = new ArrayDeque<>();
		list.add(new Cell(0, 0, 0));
		visited[0][0][0] = true;
		int step = 1;

		while (!list.isEmpty()) {
			int size = list.size();
			for (int s = 0; s < size; s++) {
				Cell cur = list.poll();
				if (cur.y == n - 1 && cur.x == m - 1) {
					System.out.println(step);
					return;
				}
				for (int d = 0; d < 4; d++) {
					int dy = cur.y + dir[d][0];
					int dx = cur.x + dir[d][1];
					if (dy >= 0 && dy < n && dx >= 0 && dx < m) {
						if (map[dy][dx] == 1 && cur.wall == 0 && !visited[dy][dx][1]) {
							visited[dy][dx][1] = true;
							list.add(new Cell(dy, dx, 1));
						} else if (map[dy][dx] == 0 && !visited[dy][dx][cur.wall]) {
							visited[dy][dx][cur.wall] = true;
							list.add(new Cell(dy, dx, cur.wall));
						}
					}
				}
			}
			step++;
		}
		System.out.println("-1");
	}

}
