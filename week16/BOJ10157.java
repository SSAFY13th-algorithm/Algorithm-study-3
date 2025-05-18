import java.io.*;
import java.util.*;

public class BOJ10157 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken()); 
        int K = Integer.parseInt(br.readLine());

        if (K > C * R) {
            System.out.println(0);
            return;
        }

        int[][] map = new int[R][C];
        int[] dx = {-1, 0, 1, 0}; // 상 우 하 좌
        int[] dy = {0, 1, 0, -1};

        int x = R - 1, y = 0, dir = 0;
        map[x][y] = 1;

        for (int i = 2; i <= K; i++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            // 범위 밖이거나 이미 앉은 자리면 방향 전환
            if (nx < 0 || ny < 0 || nx >= R || ny >= C || map[nx][ny] != 0) {
                dir = (dir + 1) % 4;
                nx = x + dx[dir];
                ny = y + dy[dir];
            }

            map[nx][ny] = i;
            x = nx;
            y = ny;
        }

        System.out.println((y + 1) + " " + (R - x));
    }
}
