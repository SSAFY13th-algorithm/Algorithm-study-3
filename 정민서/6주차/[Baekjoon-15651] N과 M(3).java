/*
1. 입력
    1-1 첫째 줄에 공백으로 구분해서 n과 m 주어짐
2. 같은 수를 여러 번 골라도 되는 중복 허용
    2-1 기저조건: 수를 뽑은 배열이 m이 되는 순간 종료
    2-2 진행로직: 기존 순열 알고리즘에서 선택된 수를 제외한 boolean 배열을
    제거하고 문제 풀기

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

    static int n, m;

    static int[] arr, ans;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        //1-1 첫째 줄에 공백으로 구분해서 n과 m 주어짐
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        ans = new int[m];

        perm(0);

        bw.flush();
        bw.close();
        br.close();

    }

    static void perm(int cnt) throws IOException {

        //기저조건
        if (cnt == m) {
            for (int i = 0; i < m; i++) {
                bw.write(String.valueOf(ans[i]) + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            ans[cnt] = arr[i];
            perm(cnt + 1);
        }
    }
}
