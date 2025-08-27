import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

class Main {

    static int N, map[][];
    static boolean[][] visited;
    static final int[] di = {-2, -2, 0, 0, 2, 2};
    static final int[] dj = {-1, 1, -2, 2, -1, 1};


    static int bfs(int x1, int y1, int x2, int y2) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x1, y1});
        visited[x1][y1] = true;
        int cnt = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            while (--size >= 0) {
                int[] ij = q.poll();
                x1 = ij[0];
                y1 = ij[1];

                if (x1 == x2 && y1 == y2) {
                    return cnt;
                }

                for (int d = 0; d < 6; d++) {
                    int ni = x1 + di[d];
                    int nj = y1 + dj[d];
                    if (0 <= ni && ni < N && 0 <= nj && nj < N && !visited[ni][nj]) {
                        q.offer(new int[]{ni, nj});
                        visited[ni][nj] = true;
                    }
                }
            }
            cnt++;
        }
        return -1;
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visited = new boolean[N][N];

        st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());

        System.out.println(bfs(x1, y1, x2, y2));
        
    }
}