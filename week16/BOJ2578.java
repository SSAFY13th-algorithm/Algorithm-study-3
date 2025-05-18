import java.io.*;
import java.util.*;

public class BOJ2578 {
    static int[][] board = new int[5][5];
    static boolean[][] marked = new boolean[5][5];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 빙고판 입력
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 사회자가 부른 숫자 순서대로 처리
        int callCount = 0;
        outer:
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int num = Integer.parseInt(st.nextToken());
                callCount++;
                mark(num);
                if (countBingo() >= 3) {
                    System.out.println(callCount);
                    break outer;
                }
            }
        }
    }

    // 숫자 찾아 체크
    static void mark(int num) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (board[i][j] == num) {
                    marked[i][j] = true;
                    return;
                }
            }
        }
    }

    // 빙고 줄 수 카운트
    static int countBingo() {
        int count = 0;

        // 가로
        for (int i = 0; i < 5; i++) {
            boolean bingo = true;
            for (int j = 0; j < 5; j++) {
                if (!marked[i][j]) bingo = false;
            }
            if (bingo) count++;
        }

        // 세로
        for (int j = 0; j < 5; j++) {
            boolean bingo = true;
            for (int i = 0; i < 5; i++) {
                if (!marked[i][j]) bingo = false;
            }
            if (bingo) count++;
        }

        // 대각선 '\'
        boolean diag1 = true;
        for (int i = 0; i < 5; i++) {
            if (!marked[i][i]) diag1 = false;
        }
        if (diag1) count++;

        // 대각선 '/'
        boolean diag2 = true;
        for (int i = 0; i < 5; i++) {
            if (!marked[i][4 - i]) diag2 = false;
        }
        if (diag2) count++;

        return count;
    }
}
