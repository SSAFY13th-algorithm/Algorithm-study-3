import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int n;
    static boolean[][] visited;
    static boolean canReach = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        System.out.println(canReach ? "HaruHaru" : "Hing");
    }

    static void dfs(int x, int y) {
        if (x < 0 || y < 0 || x >= n || y >= n || visited[x][y] || canReach) {
            return;
        }

        if (map[x][y] == -1) {
            canReach = true;
            return;
        }

        visited[x][y] = true;
        int jump = map[x][y];

        dfs(x + jump, y); // 아래로 점프
        dfs(x, y + jump); // 오른쪽으로 점프
    }
}
