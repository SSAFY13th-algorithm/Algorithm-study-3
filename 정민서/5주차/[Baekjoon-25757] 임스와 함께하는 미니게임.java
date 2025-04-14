import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int target;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        String s = st.nextToken();

        Set<String> arr = new HashSet<>();

        if (s.equals("Y")) {
            target = 1;
        } else if (s.equals("F")) {
            target = 2;
        } else if (s.equals("O")) {
            target = 3;
        }

        for (int i = 0; i < n; i++) {
            arr.add(br.readLine());
        }

        int arrSize = arr.size();
        int ans = arrSize / target;
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

}
