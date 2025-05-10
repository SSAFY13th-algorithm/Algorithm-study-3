import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] blocks = new int[W];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < W; i++) {
            blocks[i] = Integer.parseInt(st.nextToken());
        }

        int total = 0;

        // 각 위치에서 좌우 최대 높이 찾기
        for(int i = 1; i < W - 1; i++) {
            int leftMax = 0;
            int rightMax = 0;

            // 왼쪽에서 최대 높이 찾기
            for(int j = 0; j < i; j++) {
                leftMax = Math.max(leftMax, blocks[j]);
            }

            // 오른쪽에서 최대 높이 찾기
            for(int j = i + 1; j < W; j++) {
                rightMax = Math.max(rightMax, blocks[j]);
            }

            int minHeight = Math.min(leftMax, rightMax);

            if(minHeight > blocks[i]) {
                total += minHeight - blocks[i];
            }
        }

        System.out.println(total);
    }
}
