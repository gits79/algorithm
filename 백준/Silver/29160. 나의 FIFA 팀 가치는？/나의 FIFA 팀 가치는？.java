import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer>[] pq = new PriorityQueue[12];
        for (int i = 1; i <= 11; i++) {
            pq[i] = new PriorityQueue<>(Comparator.reverseOrder());
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            pq[num].offer(value);
        }

        for (int i = 0; i < K; i++) {
            for (int j = 1; j <= 11; j++) {
                if (!pq[j].isEmpty() && pq[j].peek() > 1) {
                    pq[j].offer( pq[j].poll() - 1);
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= 11; i++) {
            if (!pq[i].isEmpty()) {
                answer += pq[i].poll();
            }
        }

        System.out.println(answer);
    }
}
