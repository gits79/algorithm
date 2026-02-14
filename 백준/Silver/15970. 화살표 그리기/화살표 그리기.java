import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, arr[][], SIZE = 5001;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        List<Integer>[] lst = new List[SIZE];
        for (int i = 0; i < SIZE; i++) lst[i] = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lst[b].add(a);
        }

        for (int i = 0; i < SIZE; i++) {
            Collections.sort(lst[i]);
        }
        int sum = 0;

        for (int i = 0; i < SIZE; i++) {
            int len = lst[i].size();
            for (int j = 0; j < len; j++) {
                int cur = lst[i].get(j);
                int dist = Integer.MAX_VALUE;

                if (j - 1 >= 0)
                    dist = Math.min(dist, cur - lst[i].get(j - 1));

                if (j + 1 < len)
                    dist = Math.min(dist, lst[i].get(j + 1) - cur);

                sum += dist;
            }
        }
        System.out.println(sum);
    }
}
