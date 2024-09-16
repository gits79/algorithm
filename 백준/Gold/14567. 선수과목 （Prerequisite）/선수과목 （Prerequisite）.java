import java.io.*;
import java.util.*;

public class Main {
    static int N, M, g[][], indegree[];
    static int[] answer;

    static void bfs() {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) q.offer(i);
        }
        int cnt = 1;
        while (!q.isEmpty()) {
            int size = q.size();

            while (--size >= 0) {
                int i = q.poll();
                answer[i] = cnt;
//                System.out.print(cnt + "일때 " + i + ", ");

                for (int j = 1; j <= N; j++) {
                    if (g[i][j] != 0) {
                        if (--indegree[j] == 0) {
                            q.offer(j);
                        }
                    }
                }
            }
            cnt++;
//            System.out.println();
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        g = new int[N + 1][N + 1];
        indegree = new int[N + 1];
        answer = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            g[a][b] = 1;
            indegree[b]++;
        }
        bfs();

        for (int i = 1; i <= N; i++) {
            System.out.print(answer[i] + " ");
        }


    }
}
