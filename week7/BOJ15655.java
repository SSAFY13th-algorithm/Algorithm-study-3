package week7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ15655 {

	static int N,M;
	static int[] numbers, res;
	static boolean[] isSelected;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		numbers = new int[N]; // N개의 수
		res = new int[M]; // M개를 뽑은 조합
		isSelected = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(numbers);
		
		combination(0,0);
	}

	
	public static void combination(int cnt, int start) {
		if(cnt==M) {
			for(int a:res) {
				System.out.print(a+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=start;i<N;i++) { // 탐색 인덱스를 start 부터 하여 조합 구함
			if(isSelected[i])
				continue;
			
			isSelected[i] = true;
			res[cnt] = numbers[i];
			combination(cnt + 1, i+1); // start 를 1 증가 시켜 중복을 막음
			isSelected[i] = false;
		}
	}
}