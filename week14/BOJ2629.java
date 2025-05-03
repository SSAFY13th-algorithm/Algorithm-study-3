package week14;

import java.io.*;
import java.util.*;

public class BOJ2629 {

	static int n, m, res;
	static int[] w;
	static boolean[][] chk;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(br.readLine());
		w = new int[n];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			w[i] = Integer.parseInt(st.nextToken()); // 추 무들
		}

		m = Integer.parseInt(br.readLine());
		chk = new boolean[n + 1][15001];

		dfs(0, 0);

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			res = Integer.parseInt(st.nextToken()); // 구슬 무게를 그때그때 받아서 판단
			if (res > 15001) {
				sb.append("N ");
				continue;
			}
			if (chk[n][res])
				sb.append("Y ");
			else
				sb.append("N ");
		}
		System.out.println(sb);
	}

	static void dfs(int cnt, int weight) {
		if (cnt > n || weight < 0 || weight > 15001 || chk[cnt][weight])
			return;

		chk[cnt][weight] = true; // cnt 번째까지의 추를 고려했을 때의 가능한 무게

		if (cnt == n)
			return;

		dfs(cnt + 1, weight + w[cnt]); // 추를 올리거나
		dfs(cnt + 1, weight); // 추를 사용하지 않거나
		dfs(cnt + 1, Math.abs(weight - w[cnt])); // 추를 구슬쪽에 올리거나
	}
}

