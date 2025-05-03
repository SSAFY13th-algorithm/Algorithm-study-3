package week6;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ1094 {
    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int X = Integer.parseInt(br.readLine());
		int count = 0;
		for (int i = 0; i <= 6; i++) { // 최대 64까지 비트연산
			if ((X & 1 << i) != 0)
				count++;
		}

		System.out.println(count);
	}
}
