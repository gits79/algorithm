import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N;
    static List<Node> list;
    static List<List<Integer>> graph;

    static boolean isConnect(Node n1, Node n2) {
        return Math.abs(n1.x - n2.x) + Math.abs(n1.y - n2.y) <= 1000;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < TC; tc++) {
            N = Integer.parseInt(br.readLine());
            list = new ArrayList<>();
            graph = new ArrayList<>();

            for (int i = 0; i < N + 2; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                list.add(new Node(x, y));
                graph.add(new ArrayList<>());
            }


            for (int i = 0; i < N + 2; i++) {
                for (int j = 0; j < N + 2; j++) {
                    if (i == j) continue;
                    if (isConnect(list.get(i), list.get(j))) {
                        graph.get(i).add(j);
                    }
                }
            }


            boolean[] visited = new boolean[N + 2];
            ArrayDeque<Integer> queue = new ArrayDeque<>();
            queue.offer(0);
            visited[0] = true;

            boolean flag = false;

            while (!queue.isEmpty()) {
                int cur = queue.poll();
                if (cur == N + 1) {
                    flag = true;
                    break;
                }

                for (int next : graph.get(cur)) {
                    if (!visited[next]) {
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
            }

            System.out.println(flag ? "happy" : "sad");
        }
    }
}
