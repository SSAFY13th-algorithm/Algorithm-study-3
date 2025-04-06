import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        //문자열 배열
        String[] input = new String[n];

        //문자열 입력받기
        for (int i = 0; i < n; i++) {
            input[i] = br.readLine();
        }

        Arrays.sort(input, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                //두 단어 길이가 다르면 길이 차이 반환
                if (o1.length() != o2.length()) {
                    return o1.length() - o2.length();
                }
                //길이가 같다면 사전순
                return o1.compareTo(o2);
            }
        });

        for (int i = 0; i < n; i++) {
            //정렬되어 있으므로 첫번쨰거나 연속되는 문자와 다를경우에만 출력
            if (i == 0 || !input[i].equals(input[i - 1])) {
                bw.write(input[i] + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();

    }
}