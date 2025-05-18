import java.io.*;
import java.util.*;

public class BOJ2629 {
    static boolean[][] dp;
    static int[] weights;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        weights = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
        }

        dp = new boolean[N + 1][15001];
        solve(0, 0);

        int T = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int target = Integer.parseInt(st.nextToken());
            if (target > 15000) sb.append("N ");
            else sb.append(dp[N][target] ? "Y " : "N ");
        }

        System.out.println(sb);
    }

    static void solve(int idx, int weight) {
        if (idx > N || dp[idx][weight]) return;

        dp[idx][weight] = true;

        if (idx == N) return;

        solve(idx + 1, weight); // 추 사용 안함
        solve(idx + 1, weight + weights[idx]); // 오른쪽에 놓음
        solve(idx + 1, Math.abs(weight - weights[idx])); // 왼쪽에 놓음
    }
}
