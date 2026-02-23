import java.util.*;
import java.io.*;

public class Main {

    static int N, M, V;
    static boolean[] v;
    static List<Integer>[] lst;
    static List<Integer> answer;

    static void bfs(int vertex) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        v[vertex] = true;
        q.offer(vertex);

        while(!q.isEmpty()) {
            vertex = q.poll();
            answer.add(vertex);
            for(int nextVertex : lst[vertex]) {
                if(!v[nextVertex]) {
                    v[nextVertex] = true;
                    q.offer(nextVertex);
                }
            }
        }
    }

    static void dfs(int vertex) {
        answer.add(vertex);
        v[vertex] = true;

        for(int nextVertex : lst[vertex]) {
            if(!v[nextVertex]) dfs(nextVertex);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        lst = new List[N  + 1];
        for(int i = 1; i <= N; i++) lst[i] = new ArrayList<>();

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lst[a].add(b);
            lst[b].add(a);
        }
        
        for(int i = 1; i <= N; i++) Collections.sort(lst[i]);

        answer = new ArrayList<>();
        v = new boolean[N + 1];
        dfs(V);
        for(int i = 0; i < answer.size(); i++) {
            sb.append(answer.get(i) + " ");
        }
        sb.append("\n");
        answer = new ArrayList<>();
        v = new boolean[N + 1];
        bfs(V);
        for(int i = 0; i < answer.size(); i++) {
            sb.append(answer.get(i) + " ");
        }

        System.out.println(sb.toString());

    }
}
