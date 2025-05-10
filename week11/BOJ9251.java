package week11;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ9251 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s1 = br.readLine();
		String s2 = br.readLine();
		
		System.out.println(lcs(s1,s2));
	}
	
	public static int lcs(String A, String B) {
        int n = A.length();
        int m = B.length();

        int[][] dp = new int[n + 1][m + 1]; // 각 문자열 길이로 2차원 배열 만듬

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) { // 전부 탐색하면서
                if (A.charAt(i - 1) == B.charAt(j - 1)) { // 같은 문자를 발견하면
                    dp[i][j] = dp[i - 1][j - 1] + 1; // 대각선 위의 경우에서 + 1
                } else { // 문자가 같지 않은 경우
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); // 이전것들 중 큰것 선택
                }
            }
        }
        
        return dp[n][m];
    }

}
