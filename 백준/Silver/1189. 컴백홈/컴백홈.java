import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    static int R, C, K, cnt;
    static char[][] map;
    static boolean[][] visited;
    static final int[] di = {-1, 0, 1, 0};
    static final int[] dj = {0, 1, 0, -1};
    

    static void dfs(int i, int j, int dist) {
        if (i == 0 && j == C - 1) {
            if (dist == K) cnt++;
            return;
        }
        visited[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int ni = i + di[k];
            int nj = j + dj[k];
            if (chkIdx(ni, nj) && !visited[ni][nj] && map[ni][nj] != 'T') {
                dfs(ni, nj, dist + 1);
            }
        }
        visited[i][j] = false;
    }

    static boolean chkIdx(int i, int j) {
        if (0 <= i && i < R && 0 <= j && j < C) return true;
        return false;
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);
            }
        }
        cnt = 0;
        dfs(R - 1, 0, 1);
        System.out.println(cnt);
        
    }
}
