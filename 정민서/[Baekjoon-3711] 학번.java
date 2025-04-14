import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //테스트 케이스
        int test = Integer.parseInt(br.readLine());

        for (int caseN = 0; caseN < test; caseN++) {

            //가장 작은 양의 정수
            int m = 1;

            // 학생 수
            int g = Integer.parseInt(br.readLine());

            //학번 배열 입력받기
            int[] studentNum = new int[g];
            for (int student = 0; student < g; student++) {
                studentNum[student] = Integer.parseInt(br.readLine());
            }

            //나머지 배열에서 set 사용해서 중복검증
            HashSet<Integer> leftover = new HashSet<>();

            while (true) {

                boolean valid = true;

                //배열을 새로 할당하지 않고 재사용해 메모리 사용량 줄이기
                leftover.clear();

                for (int i = 0; i < g; i++) {
                    int temp = studentNum[i] % m;
                    if (leftover.contains(temp)) {
                        valid = false;
                        break;
                    } else {
                        leftover.add(temp);
                    }
                }
                //중복이 없다면 반복문 종료
                if (valid) {
                    break;
                } else {
                    m++;
                }

            }
            bw.write(String.valueOf(m) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}