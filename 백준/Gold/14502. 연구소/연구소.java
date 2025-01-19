import java.io.*;
import java.util.*;

public class Main {

    static int N, M, map[][], answer = 0;
    static int[] selected = new int[3];
    static boolean[][] v;

    static final int[] di = {-1, 0, 1, 0};
    static final int[] dj = {0, 1, 0, -1};


    static int bfs(int i, int j) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{i, j});
        v[i][j] = true;
        int cnt = 1;

        while (!q.isEmpty()) {
            int[] ij = q.poll();
            i = ij[0];
            j = ij[1];

            for (int d = 0; d < 4; d++) {
                int ni = i + di[d];
                int nj = j + dj[d];
                if (0 <= ni && ni < N && 0 <= nj && nj < M && map[ni][nj] == 0 && !v[ni][nj]) {
                    q.offer(new int[]{ni, nj});
                    v[ni][nj] = true;
                    cnt++;
                }
            }
        }
        return cnt;
    }


    static int sum() {
        int total = N * M;
        v = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) total--;
                if (map[i][j] == 2 && !v[i][j]) total -= bfs(i, j);
            }
        }
        return total;
    }


    static void comb(int cur, int start) {
        if (cur == 3) {
            if (canWall(selected)) {
                int[][] newMap = copyMap();
                for (int n : selected) {
                    int[] ij = changeIdx(n);
                    int i = ij[0];
                    int j = ij[1];
                    map[i][j] = 1;
                }
                int total = sum();
                answer = Math.max(answer, total);
                map = newMap;
            }
            return;
        }


        for (int i = start; i < N * M; i++) {
            selected[cur] = i;
            comb(cur + 1, i + 1);
        }

    }


    static int[] changeIdx(int n) {
        int[] temp = new int[2];
        temp[0] = n / M;
        temp[1] = n % M;

        return temp;
    }

    static boolean canWall(int[] arr) {
        for (int n : arr) {
            int[] ij = changeIdx(n);
            int i = ij[0];
            int j = ij[1];
            if (map[i][j] != 0) return false;
        }
        return true;
    }

    static int[][] copyMap() {
        int[][] temp = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                temp[i][j] = map[i][j];
            }
        }
        return temp;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        v = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        comb(0, 0);
        System.out.println(answer);

    }
}
