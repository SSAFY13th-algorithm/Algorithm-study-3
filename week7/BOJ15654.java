package week7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ15654 {

	static int N,M;
	static int[] numbers, res;
	static boolean[] isSelected;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // N개의 숫자
		M = Integer.parseInt(st.nextToken()); // M개를 뽑은 수열
		numbers = new int[N];
		res = new int[M];
		isSelected = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(numbers); // 오름차순을 위한 정렬
		
		permutation(0);
	}

	
	public static void permutation(int cnt) {
		if(cnt==M) {
			for(int a:res) {
				System.out.print(a+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=0;i<N;i++) { // 항상 0부터 시작하여 순열뽑음
			if(isSelected[i])
				continue;
			
			isSelected[i] = true; // 중복을 막기 위한 선택 처리
			res[cnt] = numbers[i];
			permutation(cnt + 1);
			isSelected[i] = false; // 원상복구
		}
	}
}