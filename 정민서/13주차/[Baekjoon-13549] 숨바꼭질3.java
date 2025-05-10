import java.util.*;

public class Main {
    static final int MAX = 100001;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 수빈이 위치
        int K = sc.nextInt(); // 동생 위치

        int[] dist = new int[MAX];
        Arrays.fill(dist, -1); // 방문 안 했으면 -1

        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(N);
        dist[N] = 0;

        while (!deque.isEmpty()) {
            int now = deque.poll();

            // 순간이동 (0초)
            if (now * 2 < MAX && dist[now * 2] == -1) {
                dist[now * 2] = dist[now];
                deque.offerFirst(now * 2);
            }

            // -1 이동 (1초)
            if (now - 1 >= 0 && dist[now - 1] == -1) {
                dist[now - 1] = dist[now] + 1;
                deque.offerLast(now - 1);
            }

            // +1 이동 (1초)
            if (now + 1 < MAX && dist[now + 1] == -1) {
                dist[now + 1] = dist[now] + 1;
                deque.offerLast(now + 1);
            }
        }

        System.out.println(dist[K]);
    }
}
