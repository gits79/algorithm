import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M, x, y, dir, cnt, map[][];

    static final int[] di = {-1, 0, 1, 0};
    static final int[] dj = {0, 1, 0, -1};

    static boolean indexChk(int i, int j) {
        if (0 <= i && i < N && 0 <= j && j < M) return true;
        return false;
    }

    static boolean search4(int i, int j) {
        for (int d = 0; d < 4; d++) {
            int ni = i + di[d];
            int nj = j + dj[d];
            if (indexChk(ni, nj) && map[ni][nj] == 0) {
                return true;
            }
        }
        return false;
    }

    private static void clean() {
        if (map[x][y] == 0) cnt++;
        map[x][y] = 2;
    }

    static void go() {
        int ni = x + di[dir];
        int nj = y + dj[dir];
        if (indexChk(ni, nj) && map[ni][nj] == 0) {
            x = ni;
            y = nj;
        }
    }

    static boolean goBack() {
        int d = (dir + 2) % 4;
        int nx = x + di[d];
        int ny = y + dj[d];
        if (indexChk(nx, ny) && map[nx][ny] != 1) {
            x = nx;
            y = ny;
            return true;
        }
        return false;
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        cnt = 0;
        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        dir = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            clean();
            // 주변 4개 중 빈칸이 있는 경우
            if (search4(x, y)) {
                // 반시계 회전
                dir = (dir - 1 == -1) ? 3 : dir - 1;
                go();


            }
            // 주변 4개 중 빈칸이 없는 경우
            else {
                if (goBack()) {
                }
                else break;
            }
        }
        System.out.println(cnt);
    }
}
