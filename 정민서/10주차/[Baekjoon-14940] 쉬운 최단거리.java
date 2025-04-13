import java.io.*;
import java.util.*;

public class Main {
    static class Point {
        int r, c;
        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] grid = new int[n][m];
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
                dist[i][j] = -1;
            }
        }

        // 시작점(값이 2인 칸) 찾기
        int startR = -1, startC = -1;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (grid[i][j] == 2) {
                    startR = i;
                    startC = j;
                    break;
                }
            }
            if (startR != -1) break;
        }

        Queue<Point> queue = new LinkedList<>();
        dist[startR][startC] = 0;
        queue.add(new Point(startR, startC));

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!queue.isEmpty()){
            Point cur = queue.poll();
            for (int i = 0; i < 4; i++){
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                if (grid[nr][nc] == 0 || dist[nr][nc] != -1) continue;
                // 최단 거리 갱신 및 큐에 추가
                dist[nr][nc] = dist[cur.r][cur.c] + 1;
                queue.add(new Point(nr, nc));
            }
        }

        // 원래 0인 칸은 0, 접근 가능한 칸은 dist 값
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                // 벽인 경우 0 출력
                if (grid[i][j] == 0) {
                    sb.append("0 ");
                } else {
                    sb.append(dist[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}
