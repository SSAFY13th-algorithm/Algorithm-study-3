import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 빠른 입출력을 위한 BufferedReader와 BufferedWriter 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 정점의 개수
        int m = Integer.parseInt(br.readLine()); // 간선의 개수

        // INF: 경로가 없음을 나타내기 위한 값 (문제 조건에 따라 충분히 큰 값)
        final int INF = 1000000000;
        int[][] dist = new int[n + 1][n + 1];

        // 1. 초기화: 모든 값을 INF로, 자기 자신으로 가는 거리는 0으로 설정
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        // 2. 간선 정보 입력: a에서 b로 가는 비용 갱신 (최소값 선택)
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            // 같은 간선이 여러 번 주어지는 경우를 대비하여 최소값 저장
            dist[a][b] = Math.min(dist[a][b], cost);
        }

        // 3. 플로이드–워셜 알고리즘 수행
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // 4. 결과 출력: 경로가 없으면 0을 출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                sb.append((dist[i][j] == INF ? 0 : dist[i][j])).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
