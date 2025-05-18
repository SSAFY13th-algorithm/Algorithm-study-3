package week16;

import java.io.*;
import java.util.*;

public class BOJ2578 {

	static Map<Integer, int[]> list = new HashMap<>();
	static int[] x = new int[6];
	static int[] y = new int[6];
	static int[] diagonal = new int[2];
	static boolean[] x_done = new boolean[6];
	static boolean[] y_done = new boolean[6];
	static boolean[] d_done = new boolean[2];
	static int bingo = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int i = 1; i <= 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 5; j++) {
				int num = Integer.parseInt(st.nextToken());
				list.put(num, new int[] { i, j }); // 빙고판을 map으로 사용
			}
		}

		int cnt = 0;

		for (int i = 1; i <= 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 5; j++) {
				cnt++;
				int num = Integer.parseInt(st.nextToken());
				int[] temp = list.get(num);

				int r = temp[0];
				int c = temp[1];

				x[r]++; // 가로열 체크
				y[c]++; // 세로열 체크
				if (r == c) diagonal[0]++; // 대각선 1
				if (r + c == 6) diagonal[1]++; // 대각선 2

				// 빙고 개수 체크
				if (x[r] == 5 && !x_done[r]) {
					bingo++;
					x_done[r] = true;
				}
				if (y[c] == 5 && !y_done[c]) {
					bingo++;
					y_done[c] = true;
				}
				if (diagonal[0] == 5 && !d_done[0]) {
					bingo++;
					d_done[0] = true;
				}
				if (diagonal[1] == 5 && !d_done[1]) {
					bingo++;
					d_done[1] = true;
				}

				if (bingo >= 3) { // 조건 만족시
					System.out.println(cnt);
					return;
				}
			}
		}
	}
}

