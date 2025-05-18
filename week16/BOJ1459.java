package week16;

import java.io.*;
import java.util.*;

public class BOJ1459 {

	static long x, y, w, s, res; // 수가 크기 때문에 long 사용

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());

		long height = Math.min(x, y); // 세로 거리

		if (s <= 2 * w) { // 대각선이 이득인 경우
			res += s * height;
		} else {
			res += w * 2 * height;
		}

		long width = Math.max(x, y) - Math.min(x, y); // 가로 거리
		if (width % 2 == 0) { // 남은 거리가 짝수일 때
			if (2 * s <= 2 * w) { // 지그재그가 이득인 경우
				res += 2 * s * (width / 2);
			} else { // 직선 이동이 이득인 경우
				res += w * width;
			}
		} else { // 남은 거리가 홀수일 때
			if (2 * s <= 2 * w) { 
				res += 2 * s * (width / 2);
				res += w;
			} else {
				res += w * width;
			}
		}

		System.out.println(res);
	}

}
