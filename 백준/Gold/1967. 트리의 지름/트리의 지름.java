import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        int vertex;
        int weight;
        Node link;

        Node(int vertex, int weight, Node link) {
            this.vertex = vertex;
            this.weight = weight;
            this.link = link;
        }
    }

    static int N, answer;
    static Node[] g;
    static boolean[] v;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        g = new Node[N + 1];
        v = new boolean[N + 1];


        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            g[from] = new Node(to, weight, g[from]);
            g[to] = new Node(from, weight, g[to]);

        }


        answer = 0;
        for (int i = 1; i <= N; i++) {
            v = new boolean[N + 1];
            dfs(i, 0, 0);
        }
        System.out.println(answer);


    }

    static void dfs(int start, int weight, int depth) {
        v[start] = true;
        answer = Math.max(answer, weight);
        
        for (Node j = g[start]; j != null; j = j.link) {
            if (!v[j.vertex]) {
                dfs(j.vertex, weight + j.weight, depth + 1);
            }
        }
    }

}
