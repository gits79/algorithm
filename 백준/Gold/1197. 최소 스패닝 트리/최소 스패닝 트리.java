import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int V, E, parent[];

    static class Edge {
        int u, v, w;

        public Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    static void init() {
        parent = new int[V + 1];
        for (int i = 1; i <= V; i++) parent[i] = i;
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static boolean union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return false;
        parent[b] = a;
        return true;
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        init();
        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges.add(new Edge(u, v, w));
        }

        Collections.sort(edges, (e1, e2) -> e1.w - e2.w);
        int count = 0;
        int mstWeight = 0;

        for (Edge edge : edges) {
            if (union(edge.u, edge.v)) {
                count++;
                mstWeight += edge.w;
                if (count == V - 1) break;
            }
        }

        System.out.println(mstWeight);
    }
}
