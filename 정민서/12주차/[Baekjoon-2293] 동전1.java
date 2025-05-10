import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 동전의 종류 수
        int k = Integer.parseInt(st.nextToken());

        int[] coins = new int[n]; // 동전의 가치
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[k + 1]; // dp[i]: i원을 만드는 경우의 수
        dp[0] = 1; // 0원을 만드는 경우는 아무 동전도 사용하지 않는 1가지

        // 동전을 하나씩 추가하면서 경우의 수를 계산
        for (int i = 0; i < n; i++) {
            for (int j = coins[i]; j <= k; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }

        System.out.println(dp[k]);
        br.close();
    }
}