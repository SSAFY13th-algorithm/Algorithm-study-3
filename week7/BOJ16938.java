package week7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ16938 {

	static int N, L, R, X, M, res, sum, max, min;
	static int[] numbers;
	static boolean[] isSelected;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 총 문제 개수
		L = Integer.parseInt(st.nextToken()); // 문제 난이도의 합 최소 범위
		R = Integer.parseInt(st.nextToken()); // 문제 난이도의 합 최대 범위
		X = Integer.parseInt(st.nextToken()); // 최고난이도 문제와 최저난이도 문제의 차의 최소범위
		numbers = new int[N]; // N개의 문제 난이도 배열
		isSelected = new boolean[N]; // 선택처리를 위한 배열
		res = 0;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(numbers);

		subset(0,0);
		
		System.out.println(res);
	}

	public static void subset(int cnt, int pick) {
		if (cnt == N) {
			sum = 0;
			max = Integer.MIN_VALUE; // 고른 문제 중 최고난이도
			min = Integer.MAX_VALUE; // 고른 문제 중 최저난이도
			if (pick >= 2) { // 최소 2개 이상 고른 경우에 조건 판단
				for (int i = 0; i < N; i++) {
					if (isSelected[i]) {
						sum += numbers[i]; // 난이도 합 계산
						if (max < numbers[i]) // 최대값 갱신
							max = numbers[i];
						if (min > numbers[i]) // 최소값 갱신
							min = numbers[i];
					}
				}

				if (sum >= L && sum <= R && (max - min) >= X) // 조건 확인
					res++;
			}

			return;
		}

		isSelected[cnt] = true; // 고른 경우
		subset(cnt + 1, pick + 1);

		isSelected[cnt] = false; // 안고른 경우
		subset(cnt + 1, pick);

	}

}
