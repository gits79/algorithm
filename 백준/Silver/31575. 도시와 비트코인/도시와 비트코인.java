import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M, map[][];
    static int[] di = {0, 1}; 
    static int[] dj = {1, 0};

    static boolean[][] v;

    static boolean bfs() {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});
        v[0][0] = true;

        while (!q.isEmpty()) {
            int[] ij = q.poll();
            int i = ij[0];
            int j = ij[1];
            if (i == M - 1 && j == N - 1) return true;

            for (int d = 0; d < 2; d++) {
                int ni = i + di[d];
                int nj = j + dj[d];
                if (0 <= ni && ni < M && 0 <= nj && nj < N && map[ni][nj] == 1 && !v[ni][nj]) {
                    v[ni][nj] = true;
                    q.offer(new int[]{ni, nj});
                }
            }

        }
        return false;
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        v = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean result = bfs();

        if (result) System.out.println("Yes");
        else System.out.println("No");

    }
}
