package week12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2293 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int max = Integer.parseInt(st.nextToken());
            int[] val = new int[max + 1]; // 1원부터 세기 위해서 +1로 배열
            int[] coin = new int[n];

            for (int i = 0; i < n; i++) { // 동전 가격
                coin[i] = Integer.parseInt(br.readLine());
            }


            val[0] = 1;

            for (int i = 0; i < n; i++) {
                for (int j = coin[i]; j <= max; j++) { // 가장 낮은 가격부터
                    val[j] += val[j - coin[i]]; //dp 계산
                }
            }

            System.out.println(val[max]);
        
    }
}

