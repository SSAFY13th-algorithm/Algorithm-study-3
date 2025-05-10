package week13;

import java.io.*;
import java.util.*;

public class BOJ9465 {

	static int n;
	static int[][] sticker;
	static int[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine());
			sticker = new int[2][n];
			dp = new int[2][n];

			for (int i = 0; i < 2; i++) { // 스티커입력
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					sticker[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			if (n == 1) { // 1칸짜리 일 경우
				sb.append(Math.max(sticker[0][0], sticker[1][0]) + "\n");
				continue;
			}

			else { // 2칸 이상인 경우
				dp[0][0] = sticker[0][0];
				dp[1][0] = sticker[1][0];

				dp[0][1] = dp[1][0] + sticker[0][1];
				dp[1][1] = dp[0][0] + sticker[1][1];

				for (int i = 2; i < n; i++) { // dp 계산
					for (int j = 0; j < 2; j++) {
						dp[j][i] += Math.max(dp[(j * -1) + 1][i - 1], dp[(j * -1) + 1][i - 2]);
						dp[j][i] += sticker[j][i];
					}
				}

				sb.append(Math.max(dp[0][n - 1], dp[1][n - 1]) + "\n");
			}
		}

		System.out.println(sb);
	}
}
