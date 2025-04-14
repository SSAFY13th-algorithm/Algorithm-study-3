package week7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15652 {

	static int N,M;
	static int[] numbers;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken()); // M개를 고른 수열
		numbers = new int[M];
		
		permutation(0,1); // start를 1로 하여 1 ~ N 까지의 수 중 순열
	}

	
	public static void permutation(int cnt, int start) {
		if(cnt==M) {
			for(int a:numbers) {
				System.out.print(a+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=start;i<=N;i++) {
			numbers[cnt]=i;
			permutation(cnt+1,i); // 중복을 허용하기 때문에 start 파라미터는 유지
		}
	}
}