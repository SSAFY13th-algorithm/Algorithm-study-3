import java.io.*;
import java.util.*;

public class BOJ11403 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[][] graph = new int[N][N];
		
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] result = new int[N][N];
		
		for (int i=0; i<N; i++) {
			boolean[] visited = new boolean[N];
			Queue<Integer> q = new LinkedList<>();
			q.add(i);
			
			while(!q.isEmpty()) {
				int current = q.poll();
				
				for (int j=0; j<N; j++) {
					if (visited[j] || graph[current][j] == 0) continue;
					
					visited[j] = true;
					q.add(j);
					result[i][j] = 1;
				}
			}
		}
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				System.out.print(result[i][j]+" ");
			}
			System.out.println();
		}
	}
}