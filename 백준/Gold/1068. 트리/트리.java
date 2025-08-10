import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, answer;
    static boolean[] visited;
    static List<Integer>[] graph;

    static void dfs(int cur) {
        visited[cur] = true;
        if (graph[cur].size() == 0) answer++;
        for (int next : graph[cur]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    private static void deleteNode(int delete) {
        for (int i = 0; i < N; i++) {
            if (graph[i].contains(delete)) graph[i].remove(Integer.valueOf(delete));
        }
        graph[delete].clear();
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        graph = new List[N];
        answer = 0;


        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        int root = 0;
        for (int i = 0; i < N; i++) {
            int parent = Integer.parseInt(st.nextToken());
            int child = i;
            if (parent != -1) {
                graph[parent].add(child);
            } else root = i;

        }

        int delete = Integer.parseInt(br.readLine());
        deleteNode(delete);


        dfs(root);
        System.out.println((delete == root) ? 0 : answer);
    }


}
