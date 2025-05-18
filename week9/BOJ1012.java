package week9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1012 {

	static int N, M, K, ans, max;
	static int[][] map;
	static boolean[][] chk;
	static boolean temp;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken()); // 밭 가로 길이
			N = Integer.parseInt(st.nextToken()); // 밭 세로 길이
			K = Integer.parseInt(st.nextToken()); // 배추가 심어진 위치

			map = new int[N][M];

			for (int i = 0; i < K; i++) { // 배추 위치 입력받아 저장
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				map[y][x] = 1;
			}
			max = 0;

			chk = new boolean[N][M];
			ans = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					temp = false; // 배추밭인지 아닌지 판단단
					find(i, j);
					if (temp) { // 붙어있는 배추밭에서는 배추벌레 1마리만 필요
						ans++;
					}
				}
			}
			if (max < ans) {
				max = ans;
			}

			System.out.println(max);
		}
	}

	public static void find(int y, int x) {
		if (chk[y][x] || map[y][x] != 1) { // 이미 체크 했거나 배추가 아니면
			return;
		} else {
			for (int i = 0; i < 4; i++) { // 상하좌우 탐색
				int dy = y + dir[i][0];
				int dx = x + dir[i][1];

				if (dy < 0 || dy >= N || dx < 0 || dx >= M) {
					continue;
				} else {
					chk[y][x] = true;
					temp = true;
					find(dy, dx);
				}
			}
		}
		return;
	}

}

