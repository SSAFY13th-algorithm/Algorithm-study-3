import java.io.*;
import java.util.*;

public class BOJ1238 {
    static class Edge implements Comparable<Edge> {
        int to, weight;
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }
    
    static int INF = Integer.MAX_VALUE;
    
    public static int[] dijkstra(int start, ArrayList<Edge>[] graph, int n) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));
        
        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int cur = current.to;
            int curDist = current.weight;
            
            // 현재 저장된 거리보다 큰 경우 스킵
            if (curDist > dist[cur]) continue;
            
            for (Edge edge : graph[cur]) {
                int next = edge.to;
                int nextDist = curDist + edge.weight;
                if (nextDist < dist[next]) {
                    dist[next] = nextDist;
                    pq.add(new Edge(next, nextDist));
                }
            }
        }
        return dist;
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 정점 개수
        int M = Integer.parseInt(st.nextToken()); // 간선 개수
        int X = Integer.parseInt(st.nextToken()); // 파티가 열리는 정점
        
        // 원래 그래프와 간선을 뒤집은 역방향 그래프 생성
        ArrayList<Edge>[] graph = new ArrayList[N + 1];
        ArrayList<Edge>[] revGraph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            revGraph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[from].add(new Edge(to, weight));
            // 역방향 그래프: 도착지를 from으로, from을 to로 저장
            revGraph[to].add(new Edge(from, weight));
        }
        
        // X에서 각 정점까지 최단 경로
        int[] distFromX = dijkstra(X, graph, N);
        // 각 정점에서 x로 가는 최단 경로
        int[] distToX = dijkstra(X, revGraph, N);
        
        // 모든 정점에 대해 왕복 시간의 최댓값 계산
        int maxTime = 0;
        for (int i = 1; i <= N; i++) {
            maxTime = Math.max(maxTime, distFromX[i] + distToX[i]);
        }
        
        System.out.println(maxTime);
    }
}