import java.io.*;
import java.util.*;

public class BOJ1459 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long x = Long.parseLong(st.nextToken());
        long y = Long.parseLong(st.nextToken());
        long w = Long.parseLong(st.nextToken());
        long s = Long.parseLong(st.nextToken());

        long minCost = 0;

        // 모두 가로/세로로만 걷는 경우
        long case1 = (x + y) * w;

        // 모두 대각선으로만 걷는 경우
        long max = Math.max(x, y);
        long min = Math.min(x, y);
        long case2 = 0;

        if ((x + y) % 2 == 0) {
            // 짝수라면 전부 대각선 이동 가능
            case2 = Math.max(x, y) * s;
        } else {
            // 아닐 경우 대각선으로 max-1 까지 가고, 남은 1칸은 w
            case2 = (max - 1) * s + w;
        }

        // min만큼 대각선 + 나머지는 직선
        long case3 = min * s + (max - min) * w;

        // 셋 중 최솟값 선택
        minCost = Math.min(case1, Math.min(case2, case3));

        System.out.println(minCost);
    }
}
