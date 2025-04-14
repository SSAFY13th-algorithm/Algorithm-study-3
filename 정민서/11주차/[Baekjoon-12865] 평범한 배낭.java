/*
물건 i 안 넣는다
→ dp[i][w] = dp[i-1][w]

물건 i 넣는다 (단, 무게 여유가 있을 때)
→ dp[i][w] = dp[i-1][w - weight[i]] + value[i]

두 경우의 수 중 MAX
dp[i][w] = max(dp[i-1][w], dp[i-1][w - weight[i]] + value[i])
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] weight = new int[n + 1];
        int[] value = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }
        int[][] dp = new int[n + 1][k + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= k; w++) {
                if (w >= weight[i]) {
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weight[i]] + value[i]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        System.out.println(dp[n][k]);
    }
}
