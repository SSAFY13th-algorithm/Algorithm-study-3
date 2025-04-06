import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

/*
1. 입력
    1-1 정점의 개수 n, 간선의 개수 m, 탐색을 시작할 정점의 번호 v
    1-2 m 번 간선이 연결하는 두 정점의 번호가 주어짐
2. 로직
    2-1 첫줄에 dfs 수행한 결과
    2-2 둘째 줄에 bfs 수행한 결과
 */

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb;

    static boolean[] visited;
    static int[] res;
    static ArrayList<Integer>[] tree;

    static int n, m, v;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        tree = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(tree[i]);
        }

        sb = new StringBuilder("");
        visited = new boolean[n + 1];
        dfs(v);
        bw.write(sb.toString() + "\n");

        sb = new StringBuilder("");
        bfs(v);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

    static void dfs(int v) {

        visited[v] = true;

        sb.append(v).append(" ");

        for (int next : tree[v]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    static void bfs(int current) {
        boolean[] visitedbfs = new boolean[n + 1];
        Queue<Integer> q = new ArrayDeque<>();

        q.add(current);
        visitedbfs[current] = true;
        while (!q.isEmpty()) {
            int cur = q.poll();
            sb.append(cur).append(" ");

            for (int next : tree[cur]) {
                if (!visitedbfs[next]) {
                    visitedbfs[next] = true;
                    q.add(next);
                }
            }
        }
    }
}
