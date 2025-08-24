import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    static int N, M, prev[][], next[][], result[][];
    static boolean[][] visited;
    static final int[] di = {-1, 0, 1, 0};
    static final int[] dj = {0, 1, 0, -1};


    static void bfs(int i, int j, int prevValue, int nextValue) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{i, j});
        visited[i][j] = true;
        prev[i][j] = nextValue;

        while (!q.isEmpty()) {
            int[] ij = q.poll();
            i = ij[0];
            j = ij[1];

            for (int d = 0; d < 4; d++) {
                int ni = i + di[d];
                int nj = j + dj[d];
                if (0 <= ni && ni < N && 0 <= nj && nj < M && prev[ni][nj] == prevValue && !visited[ni][nj]) {
                    q.offer(new int[]{ni, nj});
                    visited[ni][nj] = true;
                    prev[ni][nj] = nextValue;
                }
            }

        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        prev = new int[N][M];
        next = new int[N][M];
        result = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                prev[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                next[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int cnt = 0;
        boolean flag = true;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (prev[i][j] != next[i][j] && !visited[i][j]) {
                    cnt++;
                    bfs(i, j, prev[i][j], next[i][j]);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (prev[i][j] != next[i][j]) {
                    flag = false;
                    i = N;
                    break;
                }
            }
        }

        if (flag)
            System.out.println((cnt > 1) ? "NO" : "YES");
        else System.out.println("NO");
    }
}