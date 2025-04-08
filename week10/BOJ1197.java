import java.io.*;
import java.util.*;

public class BOJ1197 {
    static int[] parent;
   
    static class Edge implements Comparable<Edge> {
        int u, v, w;
        
        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
        
        @Override
        public int compareTo(Edge other) {
            return this.w - other.w;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        
        // 간선 정보를 저장할 리스트
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges.add(new Edge(u, v, w));
        }
        
        // 간선을 가중치 기준으로 오름차순 정렬
        Collections.sort(edges);
        
        // 각 정점의 부모를 자기 자신으로 초기화
        parent = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }
        
        long result = 0; // MST의 총 가중치를 저장할 변수
        int count = 0;  // 선택된 간선의 수
        
        for (Edge edge : edges) {
            // 두 정점을 연결했을 때 사이클이 생기지 않으면 union 수행
            if (union(edge.u, edge.v)) {
                result += edge.w;
                count++;
                // 간선 V-1개 선택되면 MST 완성됨
                if (count == V - 1) break;
            }
        }
        
        System.out.println(result);
    }
    
    public static int find(int a) {
        if (parent[a] != a) {
            parent[a] = find(parent[a]);
        }
        return parent[a];
    }
    
    // 두 정점을 합칠 수 있으면 true, 사이클 형성 시 false 반환
    public static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB) return false;
        parent[rootB] = rootA;
        return true;
    }
}