package week12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ17086 {

	static int[][] map;
	static int n, m, dist;
	static boolean[][] visited;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }, { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dist = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0) { // 상어가 없는 곳 마다 bfs 수행하여 안전거리 구함
					bfs(new int[] { i, j });
				}
			}
		}

		System.out.println(dist);
	}

	public static void bfs(int[] start) {
		Queue<int[]> list = new ArrayDeque<>();
		visited = new boolean[n][m];
		visited[start[0]][start[1]] = true;
		list.add(start);
		int step = 1; // step 별 bfs 수행으로 상어를 만나면 step을 안전거리로 갱신

		while (!list.isEmpty()) {
			int size = list.size();
			for (int s = 0; s < size; s++) {
				int[] cur = list.poll();
				for (int i = 0; i < 8; i++) {
					int dy = cur[0] + dir[i][0];
					int dx = cur[1] + dir[i][1];

					if (dy >= 0 && dy < n && dx >= 0 && dx < m) {
						if (map[dy][dx] == 1) {
							dist = Math.max(dist, step);
							return;
						} else if (!visited[dy][dx]) {
							visited[dy][dx] = true;
							list.add(new int[] { dy, dx });
						}
					}
				}
			}
			step++;
		}
	}
}

