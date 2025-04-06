import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static char[][] grid;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        grid = new char[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            grid[i] = line.toCharArray();
        }

        // 일반인의 영역 수 계산 (정확한 색 구분)
        visited = new boolean[N][N];
        int normalCount = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    normalCount++;
                    dfs(i, j, grid[i][j]);
                }
            }
        }

        // 적록색약인의 영역 수 계산
        // 먼저 원본 격자를 복사한 후, 'G'를 'R'로 변경하여 R과 G를 동일하게 처리
        char[][] gridForColorblind = new char[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 'G'는 'R'로 변경
                gridForColorblind[i][j] = (grid[i][j] == 'G') ? 'R' : grid[i][j];
            }
        }

        // gridForColorblind를 새로운 탐색 대상 격자로 사용
        grid = gridForColorblind;
        visited = new boolean[N][N];
        int colorblindCount = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    colorblindCount++;
                    dfs(i, j, grid[i][j]);
                }
            }
        }

        // 일반인 영역 수와 적록색약인 영역 수
        System.out.println(normalCount + " " + colorblindCount);
    }

    // (x, y) 위치에서 시작하여 color와 같은 영역을 탐색
    static void dfs(int x, int y, char color) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            // 격자 범위 내에 있는지 확인
            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                // 아직 방문하지 않았고, 색이 동일하면 DFS 진행
                if (!visited[nx][ny] && grid[nx][ny] == color) {
                    dfs(nx, ny, color);
                }
            }
        }
    }
}
