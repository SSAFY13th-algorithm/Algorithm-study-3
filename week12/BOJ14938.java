package week12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ14938 {

	public static class Node implements Comparable<Node> { // node 클래스
		int idx, weight;

		public Node(int idx, int weight) {
			super();
			this.idx = idx;
			this.weight = weight;
		}

		@Override
		public int compareTo(BOJ14938.Node o) {
			return this.weight - o.weight;
		}

	}

	static int n, m, r, res;
	static ArrayList<Node>[] graph;
	static int[] item;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

		graph = new ArrayList[n + 1];

		for (int i = 0; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}

		item = new int[n + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			item[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			graph[from].add(new Node(to, w)); // 무방향 그래프이므로 양쪽으로 다 사용
			graph[to].add(new Node(from, w));
		}
		
		for(int i=1;i<=n;i++) {
			dijkstra(i);
		}
		
		System.out.println(res);

	}

	static void dijkstra(int start) { // pq 를 사용한 다익스트라
		Queue<Node> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[n + 1];
		int[] dist = new int[n + 1];
		Arrays.fill(dist, 20);
		dist[start] = 0;
		pq.offer(new Node(start, 0));
		int tmp=0;

		while (!pq.isEmpty()) {
			int curidx = pq.poll().idx;
			if (visited[curidx])
				continue;

			visited[curidx] = true;

			for (Node n : graph[curidx]) {
				if (dist[n.idx] > dist[curidx] + n.weight) {
					dist[n.idx] = dist[curidx] + n.weight;

					pq.offer(new Node(n.idx, dist[n.idx]));
				}
			}
		}
		
		for(int i=1;i<=n;i++) {
			if(dist[i]<=m) {
				tmp+=item[i];
			}
		}

		res = Math.max(res, tmp);
	}
}

