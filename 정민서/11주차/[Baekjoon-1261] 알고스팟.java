import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 미로는 n x m 의 크기
 * 벽으로는 이동할 수 없음
 *
 * 운영진은 모두 같은 방에 있어야 함
 *
 * (1,1) 에 있는 운영진이 (n,m) 으로 이동하기 위해 벽을 부수는 최소 횟수
 *
 * 0은 빈방, 1은 벽
 */

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int[][] map;

    static class Node implements Comparable<Node> {
        int x,y,w;
        Node(int x, int y, int w) {
            this.x = x;
            this.y = y;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }

    }

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};

    public static void main(String[] args) throws IOException{

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        int[][] distance = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }

        distance[0][0] = map[0][0];

        PriorityQueue<Node> pQueue = new PriorityQueue<>();
        pQueue.add(new Node(0, 0, map[0][0]));

        while (!pQueue.isEmpty()) {

            Node next = pQueue.poll();

            if (distance[next.x][next.y] < next.w) continue;

            for (int i = 0; i < 4; i++) {
                int nx = next.x + dx[i];
                int ny = next.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                if (distance[nx][ny] > distance[next.x][next.y] + map[nx][ny] ) {


                    distance[nx][ny] = distance[next.x][next.y] + map[nx][ny];
                    pQueue.add(new Node(nx, ny, distance[nx][ny]));


                }
            }
        }
        System.out.println(distance[n-1][m-1]);
    }

}
