import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    //상하좌우 대각선 방향 포함
    public static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    public static int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            //종료조건
            if (r == 0 && c == 0) {
                break;
            }

            //지뢰 위치 입력받기
            char[][] map = new char[r][c];
            for (int i = 0; i < r; i++) {
                String line = br.readLine();
                for (int j = 0; j < c; j++) {
                    map[i][j] = line.charAt(j);
                }
            }

            //결과 배열
            char[][] result = new char[r][c];

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (map[i][j] == '.') {

                        int count = 0;
                        for (int k = 0; k < dx.length; k++) {
                            int newX = i + dx[k];
                            int newY = j + dy[k];

                            if (inRange(newX, newY, r, c)) {
                                if (map[newX][newY] == '*') {
                                    count++;
                                }
                            }
                        }
                        char digit = (char) ('0' + count);
                        result[i][j] = digit;
                    } else {
                        result[i][j] = map[i][j];
                    }
                }
            }
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    bw.write(result[i][j]);
                }
                bw.newLine();
            }
        }
        bw.flush();
        bw.close();
        br.close();


    }

    public static boolean inRange(int x, int y, int r, int c) {
        if (x >= 0 && y >= 0 && x < r && y < c) {
            return true;
        }
        return false;
    }
}