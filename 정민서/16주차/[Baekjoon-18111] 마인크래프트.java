import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        int min = 256;
        int max = 0;


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(min, map[i][j]);
                max = Math.max(max, map[i][j]);
            }
        }

        int resultTime = Integer.MAX_VALUE;
        int resultHeight = 0;

        // 모든 가능한 높이(최저~최고) 시도
        for (int h = min; h <= max; h++) {
            int time = 0;
            int block = B;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int diff = map[i][j] - h;
                    if (diff > 0) {
                        // 블록 캐기 (2초씩)
                        time += diff * 2;
                        block += diff;
                    } else if (diff < 0) {
                        // 블록 놓기 (1초씩)
                        time += -diff;
                        block += diff; // diff가 음수
                    }
                }
            }

            if (block < 0) continue; // 블록 부족하면 스킵

            // 시간이 같으면 더 높은 높이 선택
            if (time < resultTime || (time == resultTime && h > resultHeight)) {
                resultTime = time;
                resultHeight = h;
            }
        }

        System.out.println(resultTime + " " + resultHeight);
    }
}
