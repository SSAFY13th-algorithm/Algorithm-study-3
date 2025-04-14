import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int MAX = 100000;

        // 방문 및 거리 기록 배열, -1은 아직 방문하지 않음을 의미
        int[] dist = new int[MAX + 1];
        Arrays.fill(dist, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        dist[N] = 0;

        while(!queue.isEmpty()){
            int cur = queue.poll();
            if(cur == K){
                System.out.println(dist[cur]);
                return;
            }

            // 가능한 이동: -1, +1, *2
            int[] nextPositions = {cur - 1, cur + 1, cur * 2};
            for (int next : nextPositions) {
                if(next >= 0 && next <= MAX && dist[next] == -1){
                    dist[next] = dist[cur] + 1;
                    queue.add(next);
                }
            }
        }
    }
}
