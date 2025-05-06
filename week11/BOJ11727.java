package week11;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ11727 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		long[] arr = new long[1001];

		arr[1] = 1; // 첫번째 경우
		arr[2] = 3; // 두번째 경우

		for (int i = 3; i <= n; i++) {
			arr[i] = (arr[i - 1] + 2 * arr[i - 2]) % 10007; // 값이 크기 때문에 모듈러 연산
		}

		System.out.println(arr[n]);
	}

}
