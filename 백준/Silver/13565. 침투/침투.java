import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

class Main {

    static int N, M, map[][];
    static boolean[][] visited;

    static final int[] di = {-1, 0, 1, 0};
    static final int[] dj = {0, 1, 0, -1};


    static boolean bfs(int i, int j) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{i, j});
        visited[i][j] = true;

        while (!q.isEmpty()) {
            int[] ij = q.poll();
            i = ij[0];
            j = ij[1];

            if (i == N - 1) return true;

            for (int d = 0; d < 4; d++) {
                int ni = i + di[d];
                int nj = j + dj[d];
                if (0 <= ni && ni < N && 0 <= nj && nj < M && map[ni][nj] == 0 && !visited[ni][nj]) {
                    q.offer(new int[]{ni, nj});
                    visited[ni][nj] = true;
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
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        boolean flag = false;

        for (int i = 0; i < M; i++) {
            if (map[0][i] == 0 && !visited[0][i]) {
                flag = bfs(0, i);
                if (flag) break;
            }
        }

        System.out.println((flag) ? "YES" : "NO");
    }
}