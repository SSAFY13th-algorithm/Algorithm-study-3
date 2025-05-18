package week10;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1197 {

	static class Edge implements Comparable<Edge> {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}

	}

	static int V, E;
	static int[] parents;
	static Edge[] edgeList;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		parents = new int[V + 1];
		edgeList = new Edge[2*E];
		for (int i = 1; i <= V; i++) {
			parents[i] = i;
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			edgeList[i] = new Edge(from, to, w); // 무향 그래프이므로 from to 번갈아 저장
            edgeList[E+i] = new Edge(to, from, w);
		}
		
		Arrays.sort(edgeList);
		long result = 0, count = 0;

		for (Edge edge : edgeList) { // edge 마다 탐색
			if (union(edge.from, edge.to)) {
				result += edge.weight;
				if (++count == V - 1) {
					break;
				}
			}
		}
		
		System.out.println(result);
	}
	
	static int find(int a) {
		if (a == parents[a])
			return a;
		return parents[a] = find(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);

		if (aRoot == bRoot)
			return false;

		parents[bRoot] = aRoot;
		return true;
	}

}

