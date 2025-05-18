import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        if (K > R * C) {
            System.out.println(0);
            return;
        }

        boolean[][] visited = new boolean[R][C];
        int[] dx = {1, 0, -1, 0}; // 아래, 오른쪽, 위, 왼쪽
        int[] dy = {0, 1, 0, -1};

        int x = 0, y = 0, dir = 0, cnt = 1;
        visited[x][y] = true;

        while (cnt < K) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx >= 0 && nx < R && ny >= 0 && ny < C && !visited[nx][ny]) {
                x = nx;
                y = ny;
                visited[x][y] = true;
                cnt++;
            } else {
                dir = (dir + 1) % 4; // 방향 전환
            }
        }

        // 결과는 (y+1, x+1) (열, 행) 순서로 출력!
        System.out.println((y + 1) + " " + (x + 1));
    }
}
