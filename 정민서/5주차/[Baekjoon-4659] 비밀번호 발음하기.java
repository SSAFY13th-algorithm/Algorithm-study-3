
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//모음(a,e,i,o,u) 하나를 반드시 포함하여야 한다.
//모음이 3개 혹은 자음이 3개 연속으로 오면 안 된다.
//같은 글자가 연속적으로 두번 오면 안되나, ee 와 oo는 허용한다.

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String input = br.readLine(); //입력받기

            if (input.equals("end")) {
                break; //종료조건
            }

            boolean isAcceptable = true;
            boolean firstOption = false;

            char prev = ' ';

            int vowelCount = 0;
            int consonantCount = 0;
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if ("aeiou".indexOf(c) != -1) {
                    firstOption = true;
                    vowelCount++;
                    consonantCount = 0;
                } else {
                    consonantCount++;
                    vowelCount = 0;
                }

                if (vowelCount >= 3 || consonantCount >= 3) {
                    isAcceptable = false;
                    break;
                }

                //첫문자가 아닌 다음 문자부터 중복 검사 시작
                if (i >= 1) {
                    if (prev == c && prev != 'e' && prev != 'o') {
                        isAcceptable = false;
                        break;
                    }
                }
                prev = c; //prev 갱신
            }

            if (!firstOption) {
                isAcceptable = false;
            }

            if (isAcceptable) {
                bw.write("<" + input + "> " + "is acceptable." + "\n");
            } else {
                bw.write("<" + input + "> " + "is not acceptable." + "\n");
            }

        }
        bw.flush();
        bw.close();
        br.close();
    }
}
