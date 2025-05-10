package week12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ16236 {

	public static class Shark { // 상어 정보 클래스
		int y, x, size, eat;

		public Shark(int y, int x, int size, int eat) {
			this.y = y;
			this.x = x;
			this.size = size;
			this.eat = eat;
		}
	}

	static int[][] map; // 맵
	static int n, res;
	static boolean[][] visited; // 방문처리
	static int[][] dir = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };
	static Shark s;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		map = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) { // 상어 초기위치 처리
					s = new Shark(i, j, 2, 0);
					map[i][j] = 0;
				}
			}
		}

		while (true) { // 상어가 더이상 먹을 물고기가 없을 때 까지 반복 수행
			int move = bfs();
			if (move == -1) break; // 먹지 못한 경우

			res += move;

			if (s.size == s.eat) { // 상어가 충분히 먹으면 크기 증가
				s.size++;
				s.eat = 0;
			}
		}

		System.out.println(res);
	}

	public static int bfs() {
		Queue<int[]> list = new ArrayDeque<>();
		visited = new boolean[n][n];
		list.add(new int[] { s.y, s.x });
		visited[s.y][s.x] = true;

		List<int[]> targets = new ArrayList<>();
		int step = 0;

		while (!list.isEmpty()) {
			int size = list.size();
			step++;

			for (int i = 0; i < size; i++) {
				int[] cur = list.poll();

				for (int d = 0; d < 4; d++) {
					int dy = cur[0] + dir[d][0];
					int dx = cur[1] + dir[d][1];

					if (dy >= 0 && dy < n && dx >= 0 && dx < n && !visited[dy][dx]) {
						if (map[dy][dx] <= s.size) { // 이동 가능한 경우 이동
							visited[dy][dx] = true;

							if (map[dy][dx] != 0 && map[dy][dx] < s.size) {
								targets.add(new int[] { dy, dx }); // 물고기인 경우 먹을 수 있는 물고기 후보 처리
							}

							list.add(new int[] { dy, dx });
						}
					}
				}
			}

			if (!targets.isEmpty()) { // 먹이 우선순위에 따라 물고기 먹는 칸 구하기
				targets.sort((a, b) -> {
					if (a[0] != b[0]) return a[0] - b[0]; // 위쪽
					return a[1] - b[1]; // 왼쪽
				});

				int[] target = targets.get(0);
				s.y = target[0];
				s.x = target[1];
				s.eat++; // 먹은 횟수 증가
				map[s.y][s.x] = 0; // 먹은 물고기 칸 0으로 수정
				return step;
			}
		}

		return -1;
	}
}

