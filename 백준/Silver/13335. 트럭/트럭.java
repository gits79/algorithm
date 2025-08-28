import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    static int N, W, L, arr[];
    static ArrayDeque<Integer> queue;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        queue = new ArrayDeque<>();
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < W; i++) {
            queue.offer(0);
        }

        int cnt = 0;
        int idx = 0;
        int weight = 0;


        while (idx < N) {
            cnt++;
            weight -= queue.poll();

            if (weight + arr[idx] <= L) {
                queue.offer(arr[idx]);
                weight += arr[idx];
                idx++;
            } else queue.offer(0);
        }

        cnt += W;
        System.out.println(cnt);


    }
}
