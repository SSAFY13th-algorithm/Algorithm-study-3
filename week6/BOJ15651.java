package week6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15651 {
    static int N,M;
	static int[] numbers;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N =Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		numbers = new int[M];
		
		permutation(0);
		
		System.out.println(sb);
	}
	
	public static void permutation(int cnt) {
		if (cnt == M) {
			for(int a : numbers) {
				sb.append(a+" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 1; i <= N; i++) { // 중복 조합이므로 start 설정 필요 X
			numbers[cnt] = i;
			permutation(cnt + 1);
		}
	}
}
