import java.io.*;
import java.util.*;

public class BOJ1261 {
    static int N, M;
    static int[][] map;
    static int[][] wallCnt;

    // 상 하 좌 우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        wallCnt = new int[N][M];
        
        for (int i=0; i<N; i++) {
            String string = br.readLine();
            for (int j=0; j<M; j++) {
                map[i][j] = string.charAt(j)-'0';
                wallCnt[i][j] = Integer.MAX_VALUE;
            }
        }   
        bfs();
        System.out.println(wallCnt[N-1][M-1]);
    }

    static void bfs(){
        Deque<int[]> d = new LinkedList<>();
        d.add(new int[]{0, 0});
        wallCnt[0][0] = 0;

        while (!d.isEmpty()){
            int[] current = d.poll();
            int x = current[0];
            int y = current[1];

            for (int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (!isOK(nx, ny)) continue;

                // 이번 경로로 (nx, ny)까지 도달했을 때의 벽의 개수
                int wall = wallCnt[x][y] + map[nx][ny];

                // 그 개수가 기존 (nx, ny)까지의 벽의 개수보다 작다면
                if (wall < wallCnt[nx][ny]){
                    wallCnt[nx][ny] = wall; // 최솟값이므로 갱신
                    if (map[nx][ny] == 0){
                        d.addFirst(new int[]{nx, ny});
                    } else {
                        d.addLast(new int[]{nx, ny});
                    } // map[nx][ny]가 0이면 deque의 앞에, 1이면 뒤에 삽입하여 55~59 Line 연산 횟수 줄임
                }
            }
        }
    }

    static boolean isOK(int x, int y){
        if (x<0 || y<0 || x>=N || y>=M) return false;
        return true;
    }
}