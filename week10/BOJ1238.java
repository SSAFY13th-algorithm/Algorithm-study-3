package week10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
	int index;
	int weight;

	public Node(int index, int cost) {
		this.index = index;
		this.weight = cost;
	}

	@Override
	public int compareTo(Node o) {
		return Integer.compare(this.weight, o.weight);
	}
}

public class BOJ1238 {

	static int n, m, x;
	static ArrayList<Node>[] graph;
	static ArrayList<Node>[] graph2;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());

		graph = new ArrayList[n + 1]; // 목적지 도착용
		graph2 = new ArrayList[n + 1]; // 목적지에서 귀가용

		for (int i = 0; i <= n; i++) {
			graph[i] = new ArrayList<>();
			graph2[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			graph[v].add(new Node(u, w));
			graph2[u].add(new Node(v, w));
		}

		int[] dist = Dijkstra(x);
		int[] dist2 = Dijkstra2(x);
		int max = 0;
		for (int i = 1; i <= n; i++) {
			max = Math.max(max, dist[i] + dist2[i]);
		}
		System.out.println(max);
	}

	public static int[] Dijkstra(int start) { // 목적지 도착용
		boolean[] check = new boolean[n + 1];
		int[] dist = new int[n + 1];
		int INF = Integer.MAX_VALUE;

		Arrays.fill(dist, INF);
		dist[start] = 0;

		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));

		while (!pq.isEmpty()) {
			int nowVertex = pq.poll().index;

			if (check[nowVertex])
				continue;
			check[nowVertex] = true;

			for (Node next : graph[nowVertex]) {
				if (dist[next.index] > dist[nowVertex] + next.weight) {
					dist[next.index] = dist[nowVertex] + next.weight;

					pq.offer(new Node(next.index, dist[next.index]));
				}
			}
		}

		return dist;
	}

	public static int[] Dijkstra2(int start) { // 목적지 출발용
		boolean[] check = new boolean[n + 1];
		int[] dist = new int[n + 1];
		int INF = Integer.MAX_VALUE;

		Arrays.fill(dist, INF);
		dist[start] = 0;

		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));

		while (!pq.isEmpty()) {
			int nowVertex = pq.poll().index;

			if (check[nowVertex])
				continue;
			check[nowVertex] = true;

			for (Node next : graph2[nowVertex]) {
				if (dist[next.index] > dist[nowVertex] + next.weight) {
					dist[next.index] = dist[nowVertex] + next.weight;

					pq.offer(new Node(next.index, dist[next.index]));
				}
			}
		}
		return dist;
	}
}
