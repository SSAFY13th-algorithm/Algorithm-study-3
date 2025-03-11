import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int switches, students;
    static int[] switchStatus;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        switches = Integer.parseInt(br.readLine());
        switchStatus = new int[switches + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= switches; i++) {
            switchStatus[i] = Integer.parseInt(st.nextToken());
        }
        //학생 수
        students = Integer.parseInt(br.readLine());

        for (int i = 0; i < students; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st1.nextToken());
            int num = Integer.parseInt(st1.nextToken());

            if (gender == 1) { //남자일 경우
                for (int j = num; j <= switches; j += num) {
                    switchStatus[j] = (switchStatus[j] == 0) ? 1 : 0;
                }
            } else if (gender == 2) {
                //좌우 대칭 확인
                int pos = num;
                switchStatus[pos] = (switchStatus[pos] == 0) ? 1 : 0;
                int k = 1;

                //좌우 범위 체크
                while (pos - k >= 1 && pos + k <= switches && switchStatus[pos - k] == switchStatus[pos + k]) {

                    switchStatus[pos - k] = (switchStatus[pos - k] == 0) ? 1 : 0;
                    switchStatus[pos + k] = (switchStatus[pos + k] == 0) ? 1 : 0;
                    k++;
                }
            }
        }
        for (int i = 1; i <= switches; i++) {
            bw.write(switchStatus[i] + " ");
            if (i % 20 == 0) {
                bw.newLine();
            }
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
