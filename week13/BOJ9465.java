import java.io.*;
import java.util.*;

public class BOJ9465 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
		int T = Integer.parseInt(br.readLine());
		for (int t=0; t<T; t++){
			int n = Integer.parseInt(br.readLine());
			int[][] sticker = new int[2][n];

			for (int i=0; i<2; i++){
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j=0; j<n; j++){
					sticker[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int[][] dp = new int[2][n+1];
			dp[0][1] = sticker[0][0];
			dp[1][1] = sticker[1][0];

			for (int j=2; j<n+1; j++){
				for (int i=0; i<2; i++){
					dp[i][j] = Math.max(Math.max(dp[0][j-2], dp[1][j-2])+sticker[i][j-1], dp[(i+1)%2][j-1]+sticker[i][j-1]);
				}
			}
			
			System.out.println(Math.max(dp[0][n], dp[1][n]));
		}
	}
}