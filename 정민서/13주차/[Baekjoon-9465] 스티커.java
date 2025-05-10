import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt(); // 스티커 열 수
            int[][] sticker = new int[2][n + 1];
            int[][] dp = new int[2][n + 1];

            // 입력 받기
            for (int i = 0; i < 2; i++) {
                for (int j = 1; j <= n; j++) {
                    sticker[i][j] = sc.nextInt();
                }
            }

            // 초기값 설정
            dp[0][1] = sticker[0][1];
            dp[1][1] = sticker[1][1];

            // DP 진행
            for (int j = 2; j <= n; j++) {
                dp[0][j] = Math.max(dp[1][j - 1], dp[1][j - 2]) + sticker[0][j];
                dp[1][j] = Math.max(dp[0][j - 1], dp[0][j - 2]) + sticker[1][j];
            }

            System.out.println(Math.max(dp[0][n], dp[1][n]));
        }
    }
}
