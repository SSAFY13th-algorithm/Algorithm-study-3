import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static class Node {
        int x, y, breakWall;

        public Node(int y, int x, int breakWall) {
            this.x = x;
            this.y = y;
            this.breakWall = breakWall;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();

        map = new int[N][M];
        visited = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0, 0));
        visited[0][0][0] = true;

        int distance = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int s = 0; s < size; s++) {
                Node now = queue.poll();

                if (now.y == N - 1 && now.x == M - 1) {
                    return distance;
                }

                for (int d = 0; d < 4; d++) {
                    int ny = now.y + dy[d];
                    int nx = now.x + dx[d];

                    if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;

                    // 다음 칸이 벽이고 아직 벽 안 부쉈으면
                    if (map[ny][nx] == 1 && now.breakWall == 0 && !visited[ny][nx][1]) {
                        visited[ny][nx][1] = true;
                        queue.offer(new Node(ny, nx, 1));
                    }

                    // 다음 칸이 빈 칸이고 아직 안 간 경우
                    if (map[ny][nx] == 0 && !visited[ny][nx][now.breakWall]) {
                        visited[ny][nx][now.breakWall] = true;
                        queue.offer(new Node(ny, nx, now.breakWall));
                    }
                }
            }

            distance++;
        }

        return -1;
    }
}
