package week11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ12865 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 물품개수
		int K = Integer.parseInt(st.nextToken()); // 최대무게

		int[] weight = new int[N];
		int[] value = new int[N];

		for (int i = 0; i < N; i++) { // 입력부
			st = new StringTokenizer(br.readLine());
			weight[i] = Integer.parseInt(st.nextToken());
			value[i] = Integer.parseInt(st.nextToken());
		}

        //dp[i][w] = i번째 물건까지 고려했을 때 w무게에서의 가치
		int[][] dp = new int[N + 1][K + 1];

		for (int i = 1; i <= N; i++) {
			for (int w = 0; w <= K; w++) {
				if (weight[i - 1] > w) { // 물품이 제한보다 무거운 경우
					dp[i][w] = dp[i - 1][w];
				} else { // 아닌 경우 넣거나 안넣거나 해서 값 계산
					dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weight[i - 1]] + value[i - 1]);
				}
			}
		}

		System.out.println(dp[N][K]);
	}

}
