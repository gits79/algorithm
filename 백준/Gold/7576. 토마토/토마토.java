import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int M, N, map[][];
    static boolean[][] v;
    static final int di[] = {-1, 0, 1, 0};
    static final int dj[] = {0, 1, 0, -1};
    static ArrayDeque<int[]> q = new ArrayDeque<>();

    static boolean chkIndex(int i, int j) {
        if (0 <= i && i < N && 0 <= j && j < M) {
            return true;
        }
        return false;
    }

    static void bfs() {
        int cnt = 0;
        while (!q.isEmpty()) {

            int size = q.size();
            while (--size >= 0) {

                int[] ij = q.poll();
                int i = ij[0];
                int j = ij[1];

                for (int d = 0; d < 4; d++) {
                    int ni = i + di[d];
                    int nj = j + dj[d];
                    if (chkIndex(ni, nj) && map[ni][nj] == 0) {
                        map[ni][nj] = 1;
                        q.offer(new int[]{ni, nj});
                    }
                }
            }
            cnt++;
        }
        if (complete()) System.out.println(--cnt);
        else System.out.println(-1);

    }

    static boolean complete() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0)
                    return false;
            }
        }
        return true;
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        v = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    q.offer(new int[]{i, j});
                }
            }
        }
        bfs();

    }
}
