package week6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11053 {
     public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int[] dp = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            dp[i] = 1;  // 각 자리부터 증가하는 부분수열은 최소 1부터 시작
        }

        for (int i = 1; i < N; i++) { // 현재 자리
            for (int j = 0; j < i; j++) { // 0인덱스 부터 현재 직전 까지
                if (arr[i] > arr[j]) { // 작은 것이 있으면
                    dp[i] = Math.max(dp[i], dp[j] + 1); // 증가하는 부분수열의 길이 증가
                }
            }
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, dp[i]); // 최대치 뽑음
        }

        System.out.println(max);
    }
}
