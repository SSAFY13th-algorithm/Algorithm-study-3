import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static char[][] map;

    static int heartRow, heartCol;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        map = new char[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j);
            }
        }
        //심장위치
        heartRow = 0;
        heartCol = 0;
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (map[i][j] == '*') {
                    if (map[i - 1][j] == '*' && map[i + 1][j] == '*' && map[i][j - 1] == '*' && map[i][j + 1] == '*') {
                        heartRow = i;
                        heartCol = j;
                        break;
                    }
                }
            }
        }
        //왼팔
        int leftarm = 0;
        for (int i = heartCol - 1; i >= 0; i--) {
            if (map[heartRow][i] == '*') {
                leftarm++;
            }
        }
        //오른팔
        int rightarm = 0;
        for (int i = heartCol + 1; i < n; i++) {
            if (map[heartRow][i] == '*') {
                rightarm++;
            }
        }

        //허리
        int back = 0;
        for (int i = heartRow + 1; i < n; i++) {
            if (map[i][heartCol] == '*') {
                back++;
            }
        }

        int leftleg = 0;
        for (int i = heartRow + back; i < n; i++) {
            if (map[i][heartCol - 1] == '*') {
                leftleg++;
            }
        }

        int rightleg = 0;
        for (int i = heartRow + back; i < n; i++) {
            if (map[i][heartCol + 1] == '*') {
                rightleg++;
            }
        }

        bw.write((heartRow + 1) + " " + (heartCol + 1) + "\n");
        bw.write(leftarm + " " + rightarm + " " + back + " " + leftleg + " " + rightleg + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
