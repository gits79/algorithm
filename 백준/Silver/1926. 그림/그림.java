import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N, M, map[][];
    static boolean[][] visited;
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};
    static ArrayList<Integer> answer = new ArrayList<>();

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

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    answer.add(bfs(i, j));
                }
            }
        }

        Collections.sort(answer);
        System.out.println(answer.size());
        System.out.println((answer.isEmpty()) ? 0 : answer.get(answer.size() - 1));


    }

    private static int bfs(int i, int j) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{i, j});
        int cnt = 1;
        visited[i][j] = true;

        while (!queue.isEmpty()) {
            int[] ij = queue.poll();
            i = ij[0];
            j = ij[1];

            for (int k = 0; k < 4; k++) {
                int ni = i + di[k];
                int nj = j + dj[k];
                if (0 <= ni && ni < N && 0 <= nj && nj < M && !visited[ni][nj] && map[ni][nj] == 1) {
                    cnt++;
                    visited[ni][nj] = true;
                    queue.add(new int[]{ni, nj});
                }
            }

        }

        return cnt;
    }
}
