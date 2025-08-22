import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

class Main {

    static int N, M, map[][];
    static boolean[][] visited;

    static final int[] di = {-1, -1, -1, 0, 1, 0, 1, 1};
    static final int[] dj = {-1, 1, 0, 1, 0, -1, -1, 1};


    static void bfs(int i, int j) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{i, j});
        visited[i][j] = true;

        while (!q.isEmpty()) {
            int[] ij = q.poll();
            i = ij[0];
            j = ij[1];

            for (int d = 0; d < 8; d++) {
                int ni = i + di[d];
                int nj = j + dj[d];
                if (0 <= ni && ni < N && 0 <= nj && nj < M && map[ni][nj] == 1 && !visited[ni][nj]) {
                    q.offer(new int[]{ni, nj});
                    visited[ni][nj] = true;
                }
            }

        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    answer += 1;
                    bfs(i, j);
                }
            }
        }

        System.out.println(answer);
    }
}