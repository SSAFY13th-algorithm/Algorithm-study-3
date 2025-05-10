import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 사다리 개수
        int m = Integer.parseInt(st.nextToken()); // 뱀 개수

        // 1부터 100까지의 보드 매핑 (기본적으로 자기 자신으로 매핑)
        int[] board = new int[101];
        for (int i = 1; i <= 100; i++) {
            board[i] = i;
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            board[start] = end;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            board[start] = end;
        }

        // 최소 주사위 굴림 횟수를 저장할 배열 (-1은 아직 방문하지 않았음을 의미)
        int[] moves = new int[101];
        Arrays.fill(moves, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        moves[1] = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            if (cur == 100) {
                System.out.println(moves[cur]);
                return;
            }

            for (int dice = 1; dice <= 6; dice++) {
                int next = cur + dice;
                if (next > 100) continue; // 100번을 넘어가면 무시

                // 사다리나 뱀이 있는 경우 해당 위치로 이동
                next = board[next];

                // 아직 방문하지 않은 칸이라면
                if (moves[next] == -1) {
                    moves[next] = moves[cur] + 1;
                    queue.add(next);
                }
            }
        }

        System.out.println(-1);
    }
}
