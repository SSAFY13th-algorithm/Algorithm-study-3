import java.util.Scanner;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        clean(r, c, d);
        System.out.println(count);
    }

    static void clean(int x, int y, int d) {
        if (!visited[x][y]) {
            visited[x][y] = true;
            count++;
        }

        for (int i = 0; i < 4; i++) {
            d = (d + 3) % 4; // 왼쪽으로 회전
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                if (map[nx][ny] == 0 && !visited[nx][ny]) {
                    clean(nx, ny, d);
                    return;
                }
            }
        }

        // 네 방향 모두 청소할 수 없을 때 후진
        int back = (d + 2) % 4;
        int bx = x + dx[back];
        int by = y + dy[back];

        if (bx >= 0 && by >= 0 && bx < N && by < M) {
            if (map[bx][by] == 0) {
                clean(bx, by, d); // 방향 유지한 채 후진
            }
        }
    }
}
