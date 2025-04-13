import java.io.*;
import java.util.*;

public class BOJ12865 {
	static int N, K;
	static int[] weight, value;
	static int[][] dp;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		weight = new int[N+1];
		value = new int[N+1];
		
		
		for (int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			
			weight[i] = Integer.parseInt(st.nextToken());
			value[i] = Integer.parseInt(st.nextToken());
		}
		
		dp = new int[N+1][K+1];
		
		for (int i=1; i<=N; i++) {
			for (int j=1; j<=K; j++) {
				dp[i][j] = dp[i-1][j];
				
				if (j-weight[i]>=0) { // j가 weight[i]보다 같거나 크면
					// 기존 값 vs i번째 물건의 무게만큼 뺀 것의 최댓값(dp)에 i번째 물건의 가치를 더한 값 중 큰 것
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i]]+value[i]);
				}
			}
		}
		
		System.out.println(dp[N][K]);
	}
}