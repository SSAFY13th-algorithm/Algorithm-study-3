package week14;

import java.io.*;
import java.util.*;

public class BOJ2133 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		int[] dp = new int[31]; // 최대 30칸 까지
		dp[0] = 1;
		dp[1] = 0;
		dp[2] = 3;

		for (int i = 4; i <= n; i += 2) { // 점화식을 이용한 dp 풀이
			dp[i] = 3 * dp[i - 2];
			for (int j = 4; j <= i; j += 2) {
				dp[i] += 2 * dp[i - j];
			}
		}

		System.out.println(dp[n]);

	}

}

