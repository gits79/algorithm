import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Main {

    static class Node {
        int x;
        int y;
        int virus;
        int time;

        public Node(int x, int y, int virus, int time) {
            this.x = x;
            this.y = y;
            this.virus = virus;
            this.time = time;
        }
    }

    static int N, K, S, X, Y, map[][];
    static ArrayDeque<Node> q = new ArrayDeque<>();

    static final int[] di = {-1, 0, 1, 0};
    static final int[] dj = {0, 1, 0, -1};


    static void bfs() {

        while (!q.isEmpty()) {
            Node now = q.poll();
            int i = now.x;
            int j = now.y;

            if (now.time == S) return;

            for (int d = 0; d < 4; d++) {
                int ni = i + di[d];
                int nj = j + dj[d];
                if (0 <= ni && ni < N && 0 <= nj && nj < N && map[ni][nj] == 0 && map[i][j] == now.virus) {
                    map[ni][nj] = now.virus;
                    q.offer(new Node(ni, nj, now.virus, now.time + 1));
                }
            }

        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        ArrayList<Node> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0) list.add(new Node(i, j, map[i][j], 0));
            }
        }

        Collections.sort(list, (o1, o2) -> o1.virus - o2.virus);
        for (Node node : list) q.offer(node);
        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());


        bfs();


        System.out.println(map[X - 1][Y - 1]);

    }
}