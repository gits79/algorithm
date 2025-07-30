import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int N, M, answer = 0;
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};
    static char[][] map;
    static Set<Character> set;

    static void dfs(int i, int j) {
        answer = Math.max(answer, set.size());

        for (int k = 0; k < 4; k++) {
            int ni = i + di[k];
            int nj = j + dj[k];
            if (0 <= ni && ni < N && 0 <= nj && nj < M && !set.contains(map[ni][nj])) {
                set.add(map[ni][nj]);
                dfs(ni, nj);
                set.remove(map[ni][nj]);
            }
        }


    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        set.add(map[0][0]);
        dfs(0, 0);
        System.out.println(answer);


    }
}
