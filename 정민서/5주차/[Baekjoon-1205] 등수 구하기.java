import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int newScore = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        if (n == 0) {
            bw.write("1");
            bw.flush();
            bw.close();
            br.close();
            return;
        }

        arr = new int[n];
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st1.nextToken());
        }

        if (n == p && newScore <= arr[n - 1]) {
            bw.write("-1");
            bw.flush();
            bw.close();
            br.close();
            return;
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (newScore < arr[i]) {
                count++;
            }
        }

        if (count + 1 > p) {
            bw.write("-1");
        } else {
            bw.write(String.valueOf(count + 1));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
