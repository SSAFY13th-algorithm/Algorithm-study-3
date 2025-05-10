import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ11725 {
    
    static int N;
    static List<Integer>[] graph;
    static int[] res;
    static boolean[] isSelected;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // N개의 숫자
        
        graph = new ArrayList[N+1];  // 인접 리스트로 변경
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        isSelected = new boolean[N+1];
        res = new int[N+1];
        
        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            graph[n1].add(n2);
            graph[n2].add(n1);
        }
        
        bfs(1);// 트리의 루트가 1이라고 가정
        
        for (int i = 2; i <= N; i++) {
            System.out.println(res[i]);
        }
    }
    
    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        isSelected[start] = true;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            for (int neighbor : graph[current]) {
                if (!isSelected[neighbor]) {// 각 노드의 부모를 찾기 때문에 현재 노드로 부모 저장
                    isSelected[neighbor] = true;
                    res[neighbor] = current;
                    queue.add(neighbor);
                }
            }
        }
    }
}
