package week15;

import java.io.*;
import java.util.*;

public class BOJ15683 {

    static class camera { // 카메라 정보 저장 클래스
        int y, x, type;

        public camera(int y, int x, int type) {
            this.y = y;
            this.x = x;
            this.type = type;
        }
    }

    static int n, m, result;
    static int[][] maps;
    static List<camera> cams = new ArrayList<>();
    static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        maps = new int[n][m];
        result = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int a = Integer.parseInt(st.nextToken());
                maps[i][j] = a;
                if (a >= 1 && a <= 5) {
                    cams.add(new camera(i, j, a));
                }
            }
        }

        simulate(0, maps);

        System.out.println(result);
    }

    static void simulate(int idx, int[][] map) {
        if (idx == cams.size()) { // 카메라 다 확인한 경우
            int tmp = 0;
            for (int i = 0; i < n; i++) { // 사각지대 체크
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == 0) {
                        tmp++;
                    }
                }
            }
            result = Math.min(result, tmp); // 최소값으로 갱신
            return;
        }

        camera c = cams.get(idx);
        int[][] backup = copy(map); // 백트래킹위해 현재 상태 따로 저장

        for (int d = 0; d < 4; d++) { // 카메라 1,3,4의 경우에는 4번 시행
            watch(c, map, d);		  // 카메라 2의 경우 2번 시행, 5는 1번 시행
            simulate(idx + 1, map);
            map = copy(backup);
            if (c.type == 2 && d == 1) break;
            if (c.type == 5) break;
        }
    }

    static void watch(camera c, int[][] map, int direction) {
        int type = c.type;
        int y = c.y;
        int x = c.x;

        if (type == 1) { // 1방향
            observe(map, y, x, direction);
        } else if (type == 2) { // 양방향 반대로
            observe(map, y, x, direction);
            observe(map, y, x, (direction + 2) % 4);
        } else if (type == 3) { // 양방향 직각으로
            observe(map, y, x, direction);
            observe(map, y, x, (direction + 1) % 4);
        } else if (type == 4) { // 3방향
            observe(map, y, x, direction);
            observe(map, y, x, (direction + 1) % 4);
            observe(map, y, x, (direction + 2) % 4);
        } else if (type == 5) { // 4방향
            for (int d = 0; d < 4; d++) {
                observe(map, y, x, d);
            }
        }
    }

    static void observe(int[][] map, int y, int x, int d) {
        int ny = y + dir[d][0];
        int nx = x + dir[d][1];

        while (ny >= 0 && ny < n && nx >= 0 && nx < m) { // 맵 끝이나 벽까지 감시
            if (map[ny][nx] == 6) break;
            if (map[ny][nx] == 0) map[ny][nx] = 7;
            ny += dir[d][0];
            nx += dir[d][1];
        }
    }

    static int[][] copy(int[][] origin) { // 맵 복사 메소드
        int[][] tmp = new int[n][m];
        for (int i = 0; i < n; i++) {
            tmp[i] = origin[i].clone();
        }
        return tmp;
    }
}

