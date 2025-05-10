package week9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11404 {

	static int[][] arr;
	static int n, m;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		arr = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j)
					arr[i][j] = 0; // 자기 자신으로 갈 수는 없으니 0
				else
					arr[i][j] = 9900001;// 갈 수 없는 경우 최대 비용 +1 로 설정
			}
		}

		for (int i = 0; i < m; i++) { // 입력받아서 저장
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			arr[from][to] = Math.min(arr[from][to], cost);
		}

		for (int k = 1; k <= n; k++) { // 플로이드 워셜 알고리즘 사용하여 비용 계산
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (arr[i][j] > 9900000 || arr[i][j] == 0) { // 0이거나 최대비용보다 비싸면 0으로 출력
					System.out.print("0 ");
				} else { // 갈 수 있는 경우 비용 출력
					System.out.print(arr[i][j] + " ");
				}
			}
			System.out.println();
		}

	}

}

