import java.io.*;
import java.util.*;

public class BOJ14940 {
	static int N, M, startX, startY;
	static boolean[][] visited;
	static int[][] map;
	static int[][] result;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		result = new int[N][M];
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				// 2이면 start 좌표 저장
				if (map[i][j] == 2) {
					startX = i;
					startY = j;
				}
				
				// 0이면 미리 방문 처리
				if (map[i][j] == 0) visited[i][j] = true;
			}
		}
		
		bfs(); // bfs로 거리 구하기
		
		for (int i=0; i<N; i++) { // 원래 갈 수 있는 땅인 부분 중 도달할 수 없는 위치는 -1
			for (int j=0; j<M; j++) {
				if (map[i][j] == 1 && result[i][j]==0) {
					result[i][j] = -1;
				}
			}
		}
		
		for (int i=0; i<N; i++) { // 출력
			for (int j=0; j<M; j++) {
				sb.append(result[i][j]).append(' ');
			}
			sb.append('\n');
		}		
		System.out.println(sb);
	}

	
	static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {startX, startY});
		result[startX][startY] = 0;
		visited[startX][startY] = true;
		
		while(!q.isEmpty()) {
			int[] current = q.poll();
			for (int i=0; i<4; i++) {
				int x = current[0]+dx[i];
				int y = current[1]+dy[i];
				
				// 범위 벗어나거나, 이미 방문했을 경우
				if (!isOk(x, y) || visited[x][y]) continue;
				
				visited[x][y] = true;
				result[x][y] = result[current[0]][current[1]]+1;
				q.offer(new int[] {x, y});
			}		
		}
	}


	static boolean isOk(int x, int y) { // 범위 체크
		if (x<0 || y<0 || x>=N || y >=M) return false;
		return true;
	}
}