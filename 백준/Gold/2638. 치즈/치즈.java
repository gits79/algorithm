import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M, map[][];
    static boolean[][] visited;
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};


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


        int cnt = 1;

        while (true) {
            visited = new boolean[N][M];
            init();
            search();
            remove();
            if (count() == 0) break;
            cnt++;
        }

        System.out.println(cnt);


    }

    private static int count() {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) cnt++;
            }
        }
        return cnt;
    }

    private static void remove() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j]) {
                    map[i][j] = 0;
                }
            }
        }
    }

    private static void search() {
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    int cnt = 0;
                    for (int k = 0; k < 4; k++) {
                        int ni = i + di[k];
                        int nj = j + dj[k];
                        if (checkIdx(ni, nj) && map[ni][nj] == -1) cnt++;
                    }
                    if (cnt >= 2) visited[i][j] = true;
                }
            }
        }
    }

    private static void dfs(int i, int j) {
        visited[i][j] = true;
        map[i][j] = -1;

        for (int k = 0; k < 4; k++) {
            int ni = i + di[k];
            int nj = j + dj[k];
            if (checkIdx(ni, nj) && !visited[ni][nj] && map[ni][nj] == 0) {
                dfs(ni, nj);
            }
        }

    }


    private static boolean checkIdx(int i, int j) {
        if (0 <= i && i < N && 0 <= j && j < M) return true;
        return false;
    }

    private static void init() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 1) map[i][j] = 0;
            }
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i == 0 || j == 0) {
                    if (!visited[i][j] && map[i][j] == 0) {
                        dfs(i, j);
                    }
                }
            }
        }
    }
}
