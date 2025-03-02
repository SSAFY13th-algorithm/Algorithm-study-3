import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * 1. 64cm 길이의 막대를 가지고 있음
 *
 * 2. 길이가 x인 막대가 가지고 싶어 자르고 붙여서 길이가 x 인 막대를 가지고 싶음
 *
 * 3. 막대를 자르기 가장 쉬운 방법은 절반으로 자르는 것
 *
 * 		3-1 막대의 길이를 모두 더하기 이 때 합이 x 보다 크거나 같으면, 아래 과정 반복
 *
 * 			3-1-1 가지고 있는 막대 중 길이가 가장 짧은 것을 절반으로 자르기
 *
 * 			3-1-2 위에서 자른 막대의 절반 중 하나를 버리고 남아있는 막대의 길이의 합이 >= x -> 자른 막대의 절반 중 하나 버림
 *
 * 		3-2 남아있는 모든 막대를 풀로 붙여서 x를 만들기
 *
 * 4. x가 주어졌을 때, 몇 개의 막대를 풀로 붙여서 x cm를 만들 수 있는지 구하는 프로그램
 *
 *
 * x <= 64 자연수
 */

public class Main {

    static int x, ans;

    static int stick = 64;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //원하는 막대기 길이
        x = Integer.parseInt(br.readLine());

        String str = Integer.toBinaryString(x);

        ans = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                ans++;
            }
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        br.close();
        bw.close();

    }

}
