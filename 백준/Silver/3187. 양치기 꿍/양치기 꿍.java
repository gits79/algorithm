import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    static int N, M, k, v;
    static char[][] map;
    static boolean[][] visited;

    static final int[] di = {-1, 0, 1, 0};
    static final int[] dj = {0, 1, 0, -1};

    static void bfs(int i, int j) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{i, j});
        visited[i][j] = true;
        k = 0;
        v = 0;
        if (map[i][j] == 'v') v++;
        else if (map[i][j] == 'k') k++;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            i = cur[0];
            j = cur[1];
            for (int d = 0; d < 4; d++) {
                int ni = i + di[d];
                int nj = j + dj[d];
                if (chkIndx(ni, nj) && !visited[ni][nj] && map[ni][nj] != '#') {
                    visited[ni][nj] = true;
                    if (map[ni][nj] == 'v') v++;
                    else if (map[ni][nj] == 'k') k++;
                    queue.add(new int[]{ni, nj});
                }
            }

        }

    }

    static boolean chkIndx(int i, int j) {
        if (0 <= i && i < N && 0 <= j && j < M) return true;
        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        int sheep = 0;
        int wolf = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != '#' && !visited[i][j]) {
                    bfs(i, j);
                    if (k > v) sheep += k;
                    else wolf += v;
                }
            }
        }

        System.out.println(sheep + " " + wolf);

    }
}
