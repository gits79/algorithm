import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[] parent;
    static Set<Integer> truth = new HashSet<>();
    static List<Integer>[] lst;

    static int find(int k) {
        if (parent[k] != k) parent[k] = find(parent[k]);
        return parent[k];
    }

    static void union(int n1, int n2) {
        int a = find(n1);
        int b = find(n2);
        if (a != b) parent[b] = a;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) parent[i] = i;

        lst = new ArrayList[M];

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] truthArr = new int[n];
        for (int i = 0; i < n; i++) truthArr[i] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            List<Integer> temp = new ArrayList<>(k);
            for (int j = 0; j < k; j++) temp.add(Integer.parseInt(st.nextToken()));
            for (int j = 1; j < k; j++) union(temp.get(0), temp.get(j));
            lst[i] = temp;
        }

        for (int t : truthArr) truth.add(find(t));

        int cnt = 0;
        for (int i = 0; i < M; i++) {
            boolean ok = true;
            for (int person : lst[i]) {
                if (truth.contains(find(person))) {
                    ok = false;
                    break;
                }
            }
            if (ok) cnt++;
        }

        System.out.println(cnt);
    }
}
