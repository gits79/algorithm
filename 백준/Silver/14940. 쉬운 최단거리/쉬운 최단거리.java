import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, map[][], answer[][];
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
        answer = new int[N][M];

        for (int i = 0; i < N; i++) {
            Arrays.fill(answer[i], -1);
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    if (map[i][j] == 2) {
                        bfs(i, j);
                    } else if (map[i][j] == 0) {
                        answer[i][j] = 0;
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }


    }

    private static int bfs(int i, int j) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{i, j});
        int cnt = 0;
        visited[i][j] = true;
        answer[i][j] = cnt;

        while (!queue.isEmpty()) {
            int size = queue.size();
            cnt++;

            while (--size >= 0) {
                int[] ij = queue.poll();
                i = ij[0];
                j = ij[1];

                for (int k = 0; k < 4; k++) {
                    int ni = i + di[k];
                    int nj = j + dj[k];
                    if (0 <= ni && ni < N && 0 <= nj && nj < M && !visited[ni][nj] && map[ni][nj] == 1) {
                        visited[ni][nj] = true;
                        answer[ni][nj] = cnt;
                        queue.add(new int[]{ni, nj});
                    }
                }

            }

        }


        return cnt;
    }
}
