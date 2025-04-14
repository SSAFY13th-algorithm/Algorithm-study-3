import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static final StringBuilder sb = new StringBuilder("");

    static int n,m;
    static Edge[] edgelist;
    static int[] parents;

    static class Edge implements Comparable<Edge>{
        int from, to, w;

        public Edge(int from, int to, int w) {
            super();
            this.from = from;
            this.to = to;
            this.w = w;
        }

        @Override
        public int compareTo(Edge e) {
            return Integer.compare(this.w, e.w);
        }
    }

    public static void main(String[] args)throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        edgelist = new Edge[m];
        for (int i = 0; i < m; i++) {

            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            edgelist[i] = new Edge(a,b,c);
        }

        Arrays.sort(edgelist);

        parents = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }

        int result = 0, count = 0;
        for (Edge e : edgelist) {

            if (union(e.from, e.to)) {
                result += e.w;
                if (++count == n-1) {
                    break;
                }
            }
        }

        System.out.println(result);
    }

    static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        if (aRoot == bRoot) {
            return false;
        }

        if (aRoot>bRoot) {
            parents[bRoot] = aRoot;
        } else {
            parents[aRoot] = bRoot;
        }
        return true;
    }

    static int find(int a) {

        if (a == parents[a]) {
            return a;
        }
        return parents[a] = find(parents[a]);
    }

}
