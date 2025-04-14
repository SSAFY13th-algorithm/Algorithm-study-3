import java.util.*;
import java.io.*;

/*
 * 순서의미 없음 -> 조합 알고리즘
 */

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static final StringBuilder sb = new StringBuilder("");

    static int n,m;
    static int[] res, input;

    public static void main(String[] args) throws IOException{

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        input = new int[n];
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st1.nextToken());
        }

        Arrays.sort(input);
        res = new int[m];

        combi(0,0);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

    static void combi(int cnt, int start) {

        if (cnt == m) {
            for (int i = 0; i < m; i++) {
                sb.append(res[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < n; i++) {

            res[cnt] = input[i];
            combi(cnt + 1, i + 1);
        }
    }

}
