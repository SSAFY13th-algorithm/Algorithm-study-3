import java.io.*;

public class BOJ9251 {
	static char[] A, B;
	static int[][] dp;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String a = br.readLine();
		String b = br.readLine();
		
		dp = new int[a.length()+1][b.length()+1];
		A = new char[a.length()+1];
		B = new char[b.length()+1];
		
		for (int i=1; i<=a.length(); i++) {
			A[i] = a.charAt(i-1);
		}
		for (int i=1; i<=b.length(); i++) {
			B[i] = b.charAt(i-1);
		}
		
		for (int i=1; i<=a.length(); i++) {
			for (int j=1; j<=b.length(); j++) {
				// 두 문자가 같은 경우 이전까지의 공통 수열 길이에 +1
				if (A[i] == B[j]) dp[i][j] = dp[i-1][j-1]+1;
				// 다를 경우 dp[i][j-1]과 dp[i-1][j] 중 더 큰 값
				else dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
			}
		}
		
		System.out.println(dp[a.length()][b.length()]);
	}
}