import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, parent[];

    static void init() {
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
    }

    static void union(int n1, int n2) {
        int a = find(n1);
        int b = find(n2);
        if (a > b) parent[b] = a;
        else parent[a] = b;
    }

    private static int find(int k) {
        if (parent[k] != k) parent[k] = find(parent[k]);
        return parent[k];
    }

    static boolean connected(int n1, int n2) {
        return find(n1) == find(n2);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        init();
        for (int i = 0; i < N - 2; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }

        for (int i = 1; i < N; i++) {
            if (!connected(i, i + 1)) {
                System.out.println(i + " " + (i + 1));
                break;
            }
        }


    }
}
