import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long X = Long.parseLong(st.nextToken());
        long Y = Long.parseLong(st.nextToken());
        long W = Long.parseLong(st.nextToken());
        long S = Long.parseLong(st.nextToken());

        long min = Math.min(X, Y);
        long max = Math.max(X, Y);

        long ans = 0;


        if (S < 2 * W) {

            if ((max - min) % 2 == 0) {
                ans = min * S + (max - min) * S;
            } else {
                ans = min * S + (max - min - 1) * S + W;
            }
            ans = Math.min(ans, (X + Y) * W);
        } else {

            ans = (X + Y) * W;
        }

        System.out.println(ans);
    }
}
