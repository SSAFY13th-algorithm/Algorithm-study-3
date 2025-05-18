package week16;

import java.io.*;
import java.util.*;

public class BOJ18111 {

	static int n, m, b;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());

		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				int a = Integer.parseInt(st.nextToken());
				map[i][j] = a;
			}
		}

		int restime = Integer.MAX_VALUE;
		int resh = 0;

		for (int h = 0; h <= 256; h++) { // 높이를 가능한 경우 모두 탐색
			int remove = 0;
			int place = 0;

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (map[i][j] > h) {
						remove += map[i][j] - h; // 부셔야 되는 경우 횟수
					} else {
						place += h - map[i][j]; // 설치해야 되는 경우 횟수
					}
				}
			}

			if (remove + b >= place) { // 시간 계산
				int time = remove * 2 + place;
				if (time <= restime) {
					restime = time;
					resh = h;
				}
			}
		}
		System.out.println(restime + " " + resh);
	}
}

