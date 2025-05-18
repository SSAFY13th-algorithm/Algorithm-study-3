package week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1697 {

	static int[] line;
	static boolean[] visited;
	static int N, K, count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		visited = new boolean[100001];
		line = new int[100001];
		bfs(N);
		
		System.out.println(line[K]);
	}

	public static void bfs(int start) {
		Queue<Integer> list = new ArrayDeque<>();
		visited[start] = true;
		list.offer(start);

		while (!list.isEmpty()) {
			int n = list.size(); // 같은 시간에 확인해야 하는 위치 수수
			for(int k=0;k<n;k++) {
				int cur = list.poll();
				line[cur]=count;
				if (cur == K)
					return;
				for (int i = 0; i < 3; i++) {
					int dx = cur;
					if (i == 0) { // 한 칸 앞으로
						dx += 1;
					} else if (i == 1) { // 한 칸 뒤로
						dx -= 1;
					} else { // 현재 좌표에서 2배로로
						dx *= 2;
					}
					if(dx>=0&&dx<100001&&!visited[dx]) { // 조건에 맞으면 큐에 추가가
						list.offer(dx);
						visited[dx]=true;
					}
				}
			}
			count++; // 1초 추가
		}
	}

}

