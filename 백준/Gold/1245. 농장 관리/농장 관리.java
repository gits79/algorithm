import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, map[][];
    static boolean[][] visited;
    static boolean flag;
    static int[] di = {-1, -1, -1, 0, 1, 0, 1, 1};
    static int[] dj = {-1, 1, 0, 1, 0, -1, -1, 1};

    static void dfs(int i, int j) {
        visited[i][j] = true;
        for (int k = 0; k < 8; k++) {
            int ni = i + di[k];
            int nj = j + dj[k];
            int cur = map[i][j];
            if (chkIndex(ni, nj)) {
                int next = map[ni][nj];
                if (cur < next) {
                    flag = false;
                }
                if (!visited[ni][nj] && cur == next) {
                    dfs(ni, nj);

                }
            }
        }
    }

    static boolean chkIndex(int i, int j) {
        if (0 <= i && i < N && 0 <= j && j < M) return true;
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
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && map[i][j] != 0) {
                    flag = true;
                    dfs(i, j);
                    if (flag) cnt++;

                }
            }
        }

        System.out.println(cnt);

    }
}
