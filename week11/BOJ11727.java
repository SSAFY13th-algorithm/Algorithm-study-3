import java.io.*;

public class BOJ11727 {
	static int N;
	static int[] dp;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		if (N == 1) {
			System.out.println(1);
			return;
		}
		
		dp = new int[N+1];
		dp[1] = 1;
		dp[2] = 3;
			
		// 마지막 2*2 타일을 채우는 경우(2가지) + 2*1 타일을 채우는 경우
		for (int i=3; i<=N; i++) {
			dp[i] = (dp[i-2]*2+dp[i-1]) % 10007;
		}
		
		System.out.println(dp[N]);
	}
}