import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, M, map[][], dist[], answer = Integer.MAX_VALUE;
    static boolean[] visited;
    static List<int[]> home = new ArrayList<>();
    static List<int[]> chicken = new ArrayList<>();


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int n = Integer.parseInt(st.nextToken());
                if (n == 1) home.add(new int[]{i, j});
                else if (n == 2) chicken.add(new int[]{i, j});
                map[i][j] = n;
            }
        }

        visited = new boolean[chicken.size()];
        dist = new int[home.size()];
        recur(0, 0);
        System.out.println(answer);


    }

    private static int distance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    private static void recur(int start, int cur) {
        if (cur == M) {
            Arrays.fill(dist, Integer.MAX_VALUE);
            for (int i = 0; i < chicken.size(); i++) {
                if (visited[i]) {
                    int x1 = chicken.get(i)[0], y1 = chicken.get(i)[1];

                    for (int j = 0; j < home.size(); j++) {
                        int x2 = home.get(j)[0], y2 = home.get(j)[1];
                        dist[j] = Math.min(dist[j], distance(x1, y1, x2, y2));
                    }
                }
            }
            answer = Math.min(answer, Arrays.stream(dist).sum());
            return;
        }

        for (int i = start; i < chicken.size(); i++) {
            visited[i] = true;
            recur(i + 1, cur + 1);
            visited[i] = false;
        }

    }
}
