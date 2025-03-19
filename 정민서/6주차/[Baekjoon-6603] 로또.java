import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
1. 입력
    1-1 한줄에 테스트 케이스의 숫자가 주어짐
    1-2 주어진 숫자 만큼 원소를 입력받음
    1-3 입력값이 0이면 종료

2. 조합문제
    2-1 주어진 원소 수 중 중복되지 않는 가능한 모든 수를 출력
        2-1-1 기저조건: 선택된 수가 6과 같으면 종료
        2-1-2 진행 로직: 조합 알고리즘을 사용해 cnt와 start 매개변수로 재귀 호출

 */


public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int k;
    static int n = 6;
    static int[] s, ans;

    public static void main(String[] args) throws IOException {

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            k = Integer.parseInt(st.nextToken());

            //입력 종료 조건
            if (k == 0) {
                break;
            }
            s = new int[k];
            for (int i = 0; i < k; i++) {
                s[i] = Integer.parseInt(st.nextToken());
            }

            ans = new int[n];
            combi(0, 0);
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void combi(int cnt, int start) throws IOException {

        //기저조건
        if (cnt == n) {
            for (int i = 0; i < n; i++) {
                bw.write(String.valueOf(ans[i]) + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = start; i < k; i++) {
            ans[cnt] = s[i];
            combi(cnt + 1, i + 1);
        }
    }

}