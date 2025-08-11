import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int T, N;
    static List<Integer>[] graph;
    static List<Integer> lst1;
    static List<Integer> lst2;
    static boolean[] visited;

    static void dfs(int cur, int n) {
        visited[cur] = true;
        if (n == 1) lst1.add(cur);
        else lst2.add(cur);

        for (int next : graph[cur]) {
            if (!visited[next]) {
                dfs(next, n);
            }
        }

    }

    static int result() {
        int answer = 0;
        for (int i = 0; i < lst1.size(); i++) {
            for (int j = 0; j < lst2.size(); j++) {
                if (lst1.get(i).equals(lst2.get(j))) {
                    return lst1.get(i);

                }
            }
        }
        return answer;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {

            lst1 = new ArrayList<>();
            lst2 = new ArrayList<>();
            N = Integer.parseInt(br.readLine());
            graph = new List[N + 2];
            for (int i = 0; i <= N + 1; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < N - 1; i++) {
                st = new StringTokenizer(br.readLine());
                int child = Integer.parseInt(st.nextToken());
                int parent = Integer.parseInt(st.nextToken());
                graph[parent].add(child);
            }

            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            visited = new boolean[N + 1];
            dfs(a, 1);
            visited = new boolean[N + 1];
            dfs(b, 2);

            System.out.println(result());


        }


    }
}
