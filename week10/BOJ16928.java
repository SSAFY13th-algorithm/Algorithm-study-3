import java.io.*;
import java.util.*;

public class BOJ16928 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] move = new int[101];
		boolean[] visited = new boolean[101];
		
		for (int i=0; i<N+M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			move[x] = y;
		}
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {1, 0});
		visited[1] = true;
		
		while (!q.isEmpty()) {
			int[] current = q.poll();
			
			if (current[0] == 100) { // 100까지 도달!
				System.out.println(current[1]);
				return;
			}
			
			for (int i=1; i<7; i++) {
				int next = current[0] + i;
				
				// 100 넘어가거나 방문한 곳이면 continue
				if (next > 100 || visited[next]) continue;
				
				if (move[next] != 0) { // 뱀, 사다리 중 하나이면
					next = move[next]; // 해당 값으로 이동
				}
				
				q.add(new int[] {next, current[1]+1});
				visited[next] = true;
			}
		}		
		
        System.out.println();
    }
}