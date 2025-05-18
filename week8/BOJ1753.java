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

public class BOJ1753 {
	
	static ArrayList<Node>[] graph;
	static int N,M;

	public static void main(String[] args) throws Exception {

		// 그래프 입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 정점의 개수, 간선의 개수
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());

		graph = new ArrayList[N + 1]; // 인접 리스트 사용
		for (int i = 0; i <= N; i++)
			graph[i] = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			graph[u].add(new Node(v, w));
		}

		// 다익스트라 알고리즘 수행
		Dijkstra(N, start);

	}

	// 노드의 크기, 출발지
	public static void Dijkstra(int n, int start) { //다익스트라
		boolean[] check = new boolean[n + 1];
		int[] dist = new int[n + 1];
		int INF = Integer.MAX_VALUE;

		Arrays.fill(dist, INF);
		dist[start] = 0;

		PriorityQueue<Node> pq = new PriorityQueue<>(); // priorityqueue를 사용한 다익스트라
		pq.offer(new Node(start, 0));

		while (!pq.isEmpty()) {
			int curr = pq.poll().index;

			if (check[curr]) // 이미 방문했다면 패스
				continue;
			check[curr] = true;

			// index의 연결된 정점 비교
			for (Node next : graph[curr]) {
				if (dist[next.index] > dist[curr] + next.weight) { // 기존에 가는 비용이 새로 파악한 루트보다 큰 경우 최신화
					dist[next.index] = dist[curr] + next.weight;

					pq.offer(new Node(next.index, dist[next.index]));
				}
			}
		}

		// 최소거리 출력
		for (int i=1;i<=N;i++) {
			if (dist[i] == INF)
				System.out.println("INF");
			else
				System.out.println(dist[i]);
		}
	}
}