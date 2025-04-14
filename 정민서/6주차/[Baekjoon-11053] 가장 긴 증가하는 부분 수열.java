/*
수열 a 가 주어졌을 때, 가장 긴 증가하는 부분 수열
1. 입력
    1-1 첫째 줄에 수열 a의 크기 n
    1-2 둘째 줄에는 수열 a를 이루고 있는 n만큼의 원소가 주어짐

2. 반복문을 돌면서 현재 선택된 원소를 마지막으로 하는 부분 수열의 최대 길이를 구하고
가장 큰 값을 갱신해가며 답 구하기

 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n, count;
    static int[] arr, dp;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[n];
        count = 0;

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            count = Math.max(count, dp[i]);
        }

        bw.write(count + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
