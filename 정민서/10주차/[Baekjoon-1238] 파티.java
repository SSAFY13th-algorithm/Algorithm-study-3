import java.io.*;
import java.util.*;

public class Main {
    // 간선 정보를 저장하는 클래스
    static class Edge implements Comparable<Edge> {
        int to, weight;
        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    // 다익스트라 알고리즘 구현
    public static int[] dijkstra(int start, List<Edge>[] graph, int n) {
        int INF = Integer.MAX_VALUE;
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int currentNode = current.to;
            int currentWeight = current.weight;

            if (currentWeight > dist[currentNode]) continue;

            for (Edge edge : graph[currentNode]) {
                int next = edge.to;
                int nextCost = currentWeight + edge.weight;
                if (nextCost < dist[next]) {
                    dist[next] = nextCost;
                    pq.offer(new Edge(next, nextCost));
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        // 그래프와 역방향 그래프 초기화
        List<Edge>[] graph = new ArrayList[n + 1];
        List<Edge>[] reverseGraph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            // 정방향 그래프
            graph[u].add(new Edge(v, w));
            // 역방향 그래프 (각 간선의 방향을 반대로)
            reverseGraph[v].add(new Edge(u, w));
        }

        // X에서 각 노드로 가는 최단 경로 (X → i)
        int[] distFromX = dijkstra(x, graph, n);
        // 각 노드에서 X로 가는 최단 경로 (i → X)
        int[] distToX = dijkstra(x, reverseGraph, n);

        // 각 노드별 왕복 시간 중 최댓값 계산
        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            maxTime = Math.max(maxTime, distToX[i] + distFromX[i]);
        }

        System.out.println(maxTime);
    }
}
