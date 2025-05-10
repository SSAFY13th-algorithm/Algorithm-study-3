/*
 * 서로다른 l개의 알파벳 소문자들로 구성, 최소 한개의 모음과 최소 두개의 자음으로 구성
 * 알파벳이 암호에서 증가하는 순서
 * 1. 입력
 * 	1-1 첫줄에는 l, c 가 주어짐
 * 	1-2 c개의 문자들이 공백으로 구분되어 주어짐
 *
 * 2. 진행로직
 * 	2-1 순서의미 없음 -> 조합 알고리즘
 * 	2-2 최소 한개의 모음, 두개의 자음으로 구성
 *
 */

import java.util.*;
import java.io.*;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static final StringBuilder sb = new StringBuilder("");

    static int l,c;
    static char[] input, res;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        res = new char[l];
        input = new char[c];

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++) {
            input[i] = st1.nextToken().charAt(0);
        }

        Arrays.sort(input);

        combi(0,0);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();



    }

    static void combi(int cnt, int start) {

        if (cnt == l) {

            int vowelCount = 0;
            int letterCount = 0;

            for (int i = 0; i < l; i++) {

                if (res[i] == 'a' || res[i] == 'e' || res[i] == 'o' || res[i] == 'u' || res[i] == 'i') {
                    vowelCount++;
                } else {
                    letterCount++;
                }
            }

            if ( vowelCount >= 1 && letterCount >= 2) {
                for (int i = 0; i < l; i++) {
                    sb.append(res[i]);
                }
                sb.append("\n");
            }
            return;
        }

        for (int i = start; i < c; i++) {
            res[cnt] = input[i];
            combi(cnt+1, i + 1);
        }

    }

}
