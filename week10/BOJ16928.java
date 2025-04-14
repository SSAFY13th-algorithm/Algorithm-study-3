package week10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16928 {

    static int[] arr = new int[101]; // 사다리와 뱀의 정보를 저장하는 배열
    static boolean[] visited = new boolean[101]; // 방문 여부를 체크하는 배열
    static int n, m;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 사다리와 뱀의 정보 입력
        for (int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            arr[from] = to; // 사다리 또는 뱀의 이동 정보를 저장
        }

        // BFS 수행
        System.out.println(bfs(1)); // 시작 지점은 1
    }

    static int bfs(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start] = true; // 시작 위치 방문 처리
        int count = 0; // 이동 횟수 카운트

        while (!queue.isEmpty()) {
            int size = queue.size(); // 현재 레벨의 크기 (한 번의 주사위 던지기 결과)
            count++;

            // 현재 레벨에 있는 모든 노드 처리
            for (int i = 0; i < size; i++) {
                int current = queue.poll();

                // 주사위 던지기 결과 (1부터 6까지)
                for (int dice = 1; dice <= 6; dice++) {
                    int next = current + dice;

                    // 범위를 벗어난 경우는 무시
                    if (next > 100) continue;

                    // 사다리나 뱀에 의한 이동 처리
                    if (arr[next] != 0) {
                        next = arr[next];
                    }

                    // 목표 지점인 100에 도달하면 이동 횟수 리턴
                    if (next == 100) {
                        return count;
                    }

                    // 방문하지 않은 위치라면 큐에 추가
                    if (!visited[next]) {
                        visited[next] = true;
                        queue.add(next);
                    }
                }
            }
        }

        return -1; // 100에 도달할 수 없는 경우는 없으므로 사실상 이 부분은 필요 없음
    }
}

