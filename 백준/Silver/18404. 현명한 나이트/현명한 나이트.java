import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int sx, sy;
    static int[][] dist;
    static final int[] di = {-2, -2, -1, -1, 1, 1, 2, 2};
    static final int[] dj = {-1,  1, -2,  2,-2, 2,-1, 1};

    static boolean in(int x, int y){ return 0 <= x && x < N && 0 <= y && y < N; }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        sx = Integer.parseInt(st.nextToken()) - 1; 
        sy = Integer.parseInt(st.nextToken()) - 1; 

        dist = new int[N][N];
        for (int i = 0; i < N; i++) Arrays.fill(dist[i], -1);

        ArrayDeque<int[]> q = new ArrayDeque<>();
        dist[sx][sy] = 0;
        q.offer(new int[]{sx, sy});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            for (int k = 0; k < 8; k++) {
                int nx = x + di[k], ny = y + dj[k];
                if (in(nx, ny) && dist[nx][ny] == -1) {
                    dist[nx][ny] = dist[x][y] + 1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int tx = Integer.parseInt(st.nextToken()) - 1;
            int ty = Integer.parseInt(st.nextToken()) - 1;
            sb.append(dist[tx][ty]).append(' ');
        }
        System.out.println(sb.toString().trim());
    }
}
