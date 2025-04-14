import java.util.*;
import java.io.*;
/*
 * 캠프에 사용할 문제는 2문제 이상
 * 문제 난이도 합은 l보다 크거나 같고 r보다 작거나 같아야 한다
 * 가장어려운 문제와 쉬운 문제의 난이도 차이는 x보다 크거나 같아야 한다
 *
 * 1. 입력
 * 	1-1 첫줄에 n,l,r,x
 * 	1-2 두번째 줄에 n개의 난이도가 정수로 주어짐
 *
 * 2. 로직
 * 	2-1 원소의 합을 구해야하기 때문에, 순서의미 없음 -> 조합
 * 	2-2 메서드 구현 시에 위 조건 추가하기
 */

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static final StringBuilder sb = new StringBuilder("");

    static int n,l,r,x;
    static int[] input, res;
    static int count = 0;

    public static void main(String[] args) throws IOException{

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        input = new int[n];
        res = new int[n];
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st1.nextToken());
        }

        Arrays.sort(input);

        combi(0,0);

        bw.write(String.valueOf(count));
        bw.flush();
        br.close();
        bw.close();
    }

    static void combi(int cnt, int start) {

        if (start == n) {
            if (cnt >= 2) {
                int sum = 0;
                int minVal = Integer.MAX_VALUE;
                int maxVal = Integer.MIN_VALUE;

                for (int i = 0; i < cnt; i++) {
                    sum += res[i];
                    minVal = Math.min(minVal, res[i]);
                    maxVal = Math.max(maxVal, res[i]);
                }

                if (sum >= l && sum <=r && (maxVal - minVal) >=x ) {
                    count++;
                }
            }
            return;
        }

        res[cnt] = input[start];
        combi(cnt+1, start +1);
        combi(cnt, start+1);
    }
}
