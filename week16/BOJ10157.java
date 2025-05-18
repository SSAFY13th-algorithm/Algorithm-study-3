package week16;

import java.io.*;
import java.util.*;

public class BOJ10157 {

	static boolean[][] map;
	static int n, m, num;
	static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new boolean[m][n];
		
		int count = n*m;
		int cnt = 1;
		num = Integer.parseInt(br.readLine());
		
		int y = m-1; // 배열로 했을 때 왼쪽 하단에서 시작하기 때문에 좌표 맞춰줌
		int x = 0;
		map[y][x] = true;
		int dnum = 0;
		while(cnt<=count) {
			if(cnt==num) { // 번호 도착한 경우 출력하고 종료
				System.out.println((x+1) + " " + (m-y));
				return;
			}
			if(cnt==count)
				break;
			int dy = y + dir[dnum][0];
			int dx = x + dir[dnum][1];
			
            // 달팽이 모양으로 돌기 위한 조건들
			if(dy<0||dy>=m||dx<0||dx>=n) { // 임계점이거나
				dnum++;
				dnum = dnum%4;
				continue;
			}
			if(map[dy][dx]) { // 이미 방문한 곳을 만나면 방향 전환
				dnum++;
				dnum = dnum%4;
				continue;
			}
			map[dy][dx]=true;
			y=dy;
			x=dx;
			
			cnt++;
		}
		
		System.out.println("0"); // 못 앉는 경우
	}

}

