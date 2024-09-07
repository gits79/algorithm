import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M, X;
    static final int INF = Integer.MAX_VALUE;

    static class Node {
        int vertex, weight;
        Node next;

        public Node(int vertex, int weight, Node next) {
            this.vertex = vertex;
            this.weight = weight;
            this.next = next;
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Node[] adjList = new Node[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            int weight = Integer.parseInt(st.nextToken());
            adjList[from] = new Node(to, weight, adjList[from]);
        }
        int answer = 0;
        for (int i = 0; i < N; i++) {
            // start에서 end까지의 최단 경로 + end에서 start까지의 최단 경로
            int result = getMinDistance(adjList, X - 1, i) + getMinDistance(adjList, i, X - 1);
            answer = Math.max(answer, result);
        }

        System.out.println(answer);
    }

    static int getMinDistance(Node[] adjList, int start, int end) {
        final int V = adjList.length;
        int[] minDistance = new int[V];
        boolean[] visited = new boolean[V];
        Arrays.fill(minDistance, INF);
        minDistance[start] = 0;

        for (int i = 0; i < V; i++) {
            // step1 미방문 정점 중 시작정점에서 가장 가까운 정점stopOVer 선택
            int min = INF;
            int stopOVer = -1;
            for (int j = 0; j < V; j++) {
                if (!visited[j] && min > minDistance[j]) {
                    min = minDistance[j];
                    stopOVer = j;
                }
            }

            if (stopOVer == -1) break;
            visited[stopOVer] = true;

            // step 2 : 선택된 정점을 경유해서 미방문 인접한 정점으로의 최소비용
            for (Node temp = adjList[stopOVer]; temp != null; temp = temp.next) {
                if (minDistance[temp.vertex] > min + temp.weight)
                    minDistance[temp.vertex] = min + temp.weight;
            }
        }

        return minDistance[end] != INF ? minDistance[end] : -1;


    }

}
