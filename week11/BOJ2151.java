import java.io.*;
import java.util.*;

public class BOJ2151 {
    static int N;
    static char[][] grid;
    static int[][][] dist;
    
    // 상 우 하 좌
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    static class State implements Comparable<State> {
        int x, y, d, cnt;
        public State(int x, int y, int d, int cnt) {
            this.x = x; this.y = y; this.d = d; this.cnt = cnt;
        }
        public int compareTo(State o) {
            return this.cnt - o.cnt;
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        grid = new char[N][N];
        List<int[]> doorList = new ArrayList<>();
        
        for (int i = 0; i < N; i++){
            String line = br.readLine();
            grid[i] = line.toCharArray();
            for (int j = 0; j < N; j++){
                if (grid[i][j] == '#') {
                    doorList.add(new int[]{i, j});
                }
            }
        }
        
        // doorList의 첫번째: 시작 문, 두번째: 도착 문
        int startX = doorList.get(0)[0];
        int startY = doorList.get(0)[1];
        int endX = doorList.get(1)[0];
        int endY = doorList.get(1)[1];
        
        dist = new int[N][N][4];
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                Arrays.fill(dist[i][j], Integer.MAX_VALUE);
            }
        }
        
        PriorityQueue<State> pq = new PriorityQueue<>();
        
        // 시작 문에서는 어떤 방향으로도 진행 가능하므로 4방향 초기화
        for (int d = 0; d < 4; d++){
            dist[startX][startY][d] = 0;
            pq.offer(new State(startX, startY, d, 0));
        }
        
        while (!pq.isEmpty()){
            State cur = pq.poll();
            int x = cur.x, y = cur.y, d = cur.d, cnt = cur.cnt;
            if (cnt > dist[x][y][d]) continue;

            // 도착 문에 도달하면 정답 출력
            if (x == endX && y == endY) {
                System.out.println(cnt);
                return;
            }

            // 현재 방향 그대로 전진
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (isOK(nx, ny) && grid[nx][ny] != '*') {
                if (cnt < dist[nx][ny][d]){
                    dist[nx][ny][d] = cnt;
                    pq.offer(new State(nx, ny, d, cnt));
                }
            }

            // 현재 위치가 거울을 설치할 수 있는 곳이라면, 좌우로 방향 전환 가능
            if (grid[x][y] == '!') {
                int left = (d + 3) % 4;
                int right = (d + 1) % 4;
                if (isOK(x + dx[left], y + dy[left]) && grid[x + dx[left]][y + dy[left]] != '*') {
                    if (cnt + 1 < dist[x][y][left]) {
                        dist[x][y][left] = cnt + 1;
                        pq.offer(new State(x, y, left, cnt + 1));
                    }
                }
                if (isOK(x + dx[right], y + dy[right]) && grid[x + dx[right]][y + dy[right]] != '*') {
                    if (cnt + 1 < dist[x][y][right]) {
                        dist[x][y][right] = cnt + 1;
                        pq.offer(new State(x, y, right, cnt + 1));
                    }
                }
            }
        }
    }
    
    static boolean isOK(int x, int y){
        return x >= 0 && y >= 0 && x < N && y < N;
    }
}