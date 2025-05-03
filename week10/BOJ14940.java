package week10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14940 {

    static int n, m, x, y;
    static int[][] map;
    static int[][] dist;
    static boolean[][] visited;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        dist = new int[n][m];
        visited = new boolean[n][m];

        // 맵 입력 받기
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 2) { // 목표 지점
                    y = i;
                    x = j;
                    map[i][j] = 0; // 목표 지점은 0으로 초기화
                } else {
                    map[i][j] = num;
                }
                dist[i][j] = -1; // 초기화: 거리 정보는 -1로 설정
                if(map[i][j]==0)
                	dist[i][j]=0;
            }
        }

        // BFS 시작
        bfs(y, x);

        // 결과 출력
        for (int[] row : dist) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    public static void bfs(int startY, int startX) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startY, startX});
        dist[startY][startX] = 0; // 목표 지점의 거리는 0

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int y = current[0];
            int x = current[1];

            for (int i = 0; i < 4; i++) {
                int dy = y + dir[i][0];
                int dx = x + dir[i][1];

                if (dy >= 0 && dy < n && dx >= 0 && dx < m && map[dy][dx] == 1 && dist[dy][dx] == -1) {
                    dist[dy][dx] = dist[y][x] + 1;
                    queue.offer(new int[]{dy, dx});
                }
            }
        }
    }
}
