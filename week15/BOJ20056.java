package week15;

import java.io.*;
import java.util.*;

public class BOJ20056 {
    static class Fireball {
        int r, c, m, s, d;

        public Fireball(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }

    static int N, M, K;
    static List<Fireball>[][] map;
    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());  // 격자 크기
        M = Integer.parseInt(st.nextToken());  // 파이어볼 개수
        K = Integer.parseInt(st.nextToken());  // 명령 횟수

        map = new ArrayList[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                map[i][j] = new ArrayList<>();

        List<Fireball> fireballs = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            fireballs.add(new Fireball(r, c, m, s, d));
        }

        while (K-- > 0) {
            // 파이어볼 이동
            for (Fireball fb : fireballs) {
                int nr = (fb.r + dr[fb.d] * fb.s % N + N) % N;
                int nc = (fb.c + dc[fb.d] * fb.s % N + N) % N;
                map[nr][nc].add(new Fireball(nr, nc, fb.m, fb.s, fb.d));
            }

            // 처리
            fireballs.clear();
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (map[r][c].size() == 0) continue;

                    if (map[r][c].size() == 1) {
                        fireballs.add(map[r][c].get(0));
                    } else {
                        int sumM = 0, sumS = 0;
                        boolean allEven = true, allOdd = true;

                        for (Fireball fb : map[r][c]) {
                            sumM += fb.m;
                            sumS += fb.s;
                            if (fb.d % 2 == 0) allOdd = false;
                            else allEven = false;
                        }

                        int newM = sumM / 5;
                        if (newM == 0) {
                            map[r][c].clear();
                            continue;
                        }

                        int newS = sumS / map[r][c].size();
                        int[] newDirs = (allEven || allOdd) ? new int[]{0, 2, 4, 6} : new int[]{1, 3, 5, 7};
                        for (int d : newDirs) {
                            fireballs.add(new Fireball(r, c, newM, newS, d));
                        }
                    }
                    map[r][c].clear();
                }
            }
        }

        int answer = 0;
        for (Fireball fb : fireballs) {
            answer += fb.m;
        }
        System.out.println(answer);
    }
}

