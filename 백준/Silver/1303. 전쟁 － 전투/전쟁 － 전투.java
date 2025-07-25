import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static char[][] map;
    static boolean[][] visited;
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};
    static int max = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        int myTeam = 0;
        int yourTeam = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    max = 0;
                    char team = map[i][j];
                    int n;
                    if (team == 'W') {
                        n = dfs(i, j, team);
                        myTeam += n * n;
                    } else {
                        n = dfs(i, j, team);
                        yourTeam += n * n;
                    }
                }
            }
        }


        System.out.println(myTeam + " " + yourTeam);

    }

    private static int dfs(int i, int j, char c) {
        visited[i][j] = true;
        int cnt = 1;
        for (int d = 0; d < 4; d++) {
            int ni = i + di[d];
            int nj = j + dj[d];
            if (0 <= ni && ni < N && 0 <= nj && nj < M && !visited[ni][nj] && map[ni][nj] == c) {
                cnt += dfs(ni, nj, c);
            }
        }
        return cnt;
    }
}
