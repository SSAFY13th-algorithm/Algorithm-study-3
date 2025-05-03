package week13;

import java.io.*;
import java.util.*;

public class BOJ13549 {

	static class Node implements Comparable<Node> {
		int x, time;

		public Node(int x, int time) {
			super();
			this.x = x;
			this.time = time;
		}

		@Override
		public int compareTo(BOJ13549.Node o) {
			return this.time - o.time;
		}

	}

	static int n, k;
	static Queue<Node> list = new PriorityQueue<>();
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		visited = new boolean[1000001];
		list.add(new Node(n, 0));

		bfs();
	}

	static void bfs() { // bfs처럼 탐색하면서 찾기
		while (!list.isEmpty()) {
			Node cur = list.poll();
			if (visited[cur.x])
				continue;
			visited[cur.x] = true;

			if (cur.x == k) {
				System.out.println(cur.time);
				return;
			}
			int dx = cur.x * 2;
			if (dx <= 100000 && !visited[dx]) {
				list.add(new Node(dx, cur.time));
			}
			dx = cur.x - 1;
			if (dx >= 0 && !visited[dx]) {
				list.add(new Node(dx, cur.time + 1));
			}
			dx = cur.x + 1;
			if (dx <= 100000 && !visited[dx]) {
				list.add(new Node(dx, cur.time + 1));
			}
		}
	}

}