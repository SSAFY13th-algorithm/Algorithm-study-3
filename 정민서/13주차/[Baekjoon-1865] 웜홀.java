import java.util.*;

public class Main {
    static class Edge {
        int from, to, weight;
        Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    static final int INF = 100000000;
    static int N, M, W;
    static List<Edge> edges;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();

        while (TC-- > 0) {
            N = sc.nextInt(); // 지점 수
            M = sc.nextInt(); // 도로 수
            W = sc.nextInt(); // 웜홀 수

            edges = new ArrayList<>();

            for (int i = 0; i < M; i++) {
                int s = sc.nextInt();
                int e = sc.nextInt();
                int t = sc.nextInt();
                // 도로는 양방향
                edges.add(new Edge(s, e, t));
                edges.add(new Edge(e, s, t));
            }

            for (int i = 0; i < W; i++) {
                int s = sc.nextInt();
                int e = sc.nextInt();
                int t = sc.nextInt();
                // 웜홀은 단방향 & 음수
                edges.add(new Edge(s, e, -t));
            }

            if (hasNegativeCycle()) {
                System.out.println("YES");
            } else {
                System.out.println("NO
