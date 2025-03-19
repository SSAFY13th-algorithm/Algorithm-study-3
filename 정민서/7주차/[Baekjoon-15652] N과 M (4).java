import java.util.*;
import java.io.*;

/*
 * 순서가 상관 있음 => 조합 알고리즘
 * 같은 수를 골라도 괜찮음
 */

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static final StringBuilder sb = new StringBuilder("");

    static int n,m;
    static int[] input,res;

    public static void main(String[] args) throws IOException{

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        input = new int[n];
        res = new int[m];

        for (int i = 0; i < input.length; i++) {
            input[i] = i + 1;
        }

        combi(0,0);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

    static void combi(int cnt, int start) {

        if (cnt == m) {
            for (int i = 0; i < res.length; i++) {
                sb.append(res[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < input.length; i++) {
            res[cnt] = input[i];
            combi(cnt +1, i);
        }
    }

}
