package week9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1260 {

	static int[][] arr;
	static int n, m, s;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		arr = new int[n + 1][n + 1]; // 인접행렬 사용 (N이 1000개이기 때문에 무방)
		visited = new boolean[n + 1];

		for (int i = 0; i < m; i++) { // 무향 그래프로 입력받기
			st = new StringTokenizer(br.readLine());
			int to = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());

			arr[to][from] = 1;
			arr[from][to] = 1;
		}

		dfs(s);
		System.out.println();
		visited = new boolean[n + 1];
		bfs(s);
	}

	static void dfs(int start) { // dfs

		visited[start] = true;
		System.out.print(start + " ");

		for (int i = 1; i <= n; i++) {
			if (arr[start][i] == 1 && !visited[i]) {
				dfs(i);
			}
		}

	}

	static void bfs(int start) { // bfs

		Queue<Integer> list = new ArrayDeque<>();
		list.add(start);
		visited[start] = true;

		while (list.size() != 0) {
			int idx = list.poll();
			System.out.print(idx + " ");
			for (int i = 1; i <= n; i++) {
				if (arr[idx][i] == 1 && !visited[i]) {
					visited[i] = true;
					list.add(i);
				}
			}
		}

	}

}

