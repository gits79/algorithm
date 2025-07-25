import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int N = 5;
    static int[][] map;
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};
    static Set<String> set = new HashSet<>();


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dfs(i, j, map[i][j] + "", 0);

            }
        }
        System.out.println(set.size());

    }

    private static void dfs(int i, int j, String route, int cur) {
        if (cur == N) {
            set.add(route);
            return;
        }
        for (int d = 0; d < 4; d++) {
            int ni = i + di[d];
            int nj = j + dj[d];
            if (chkIdx(ni, nj)) {
                dfs(ni, nj, route + map[ni][nj], cur + 1);
            }
        }
    }

    private static boolean chkIdx(int i, int j) {
        if (0 <= i && i < N && 0 <= j && j < N) return true;
        return false;
    }
}
