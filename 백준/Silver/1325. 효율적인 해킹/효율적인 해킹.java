import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M, counts[];
    static boolean[] visited;
    static List<Integer>[] graph;


    static int bfs(int cur, int cnt) {
        visited[cur] = true;
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(cur);

        while (!queue.isEmpty()) {
            cur = queue.poll();
            for (int next : graph[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                    cnt++;
                }
            }
        }
        return cnt;

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new List[N + 1];
        visited = new boolean[N + 1];
        counts = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[b].add(a);
        }

        int max = 0;
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            int cnt = bfs(i, 1);
            counts[i] = cnt;
            if (cnt > max) max = cnt;

        }


        for (int i = 1; i <= N; i++) {
            if (counts[i] == max) System.out.print(i + " ");
        }

    }
}
