import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    //가로 세로 크기 100인 도화지
    public static boolean[][] blank = new boolean[100][100];

    //총 면적
    public static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //색종이의 갯수
        int n = Integer.parseInt(br.readLine());

        for (int paper = 0; paper < n; paper++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            //각 색종이의 좌표
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            //주어진 좌표부터 +10까지 배열 true 처리
            for (int i = x; i < x + 10; i++) {
                for (int j = y; j < y + 10; j++) {
                    blank[i][j] = true;
                }
            }
        }

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (blank[i][j]) {
                    count++;
                }
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();


    }
}