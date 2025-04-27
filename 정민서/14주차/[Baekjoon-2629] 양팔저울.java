import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] dp;
    static int[] weights;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine()); // 추 개수
        weights = new int[n];
        int sum = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
            sum += weights[i];
        }

        dp = new boolean[n + 1][sum + 1];

        dfs(0, 0);

        int m = Integer.parseInt(br.readLine()); // 구슬 개수
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            int bead = Integer.parseInt(st.nextToken());
            if (bead > sum) {
                sb.append("N ");
            } else if (dp[n][bead]) {
                sb.append("Y ");
            } else {
                sb.append("N ");
            }
        }

        System.out.println(sb.toString().trim());
    }

    static void dfs(int idx, int weight) {
        if (dp[idx][weight]) return; // 이미 방문했으면 리턴
        dp[idx][weight] = true;

        if (idx == n) return;

        // 다음 추를 사용해서 3가지 경우를 고려:
        dfs(idx + 1, weight);                           // 추를 사용 안 함
        dfs(idx + 1, weight + weights[idx]);             // 오른쪽에 추가
        dfs(idx + 1, Math.abs(weight - weights[idx]));   // 왼쪽에 추가
    }
}
