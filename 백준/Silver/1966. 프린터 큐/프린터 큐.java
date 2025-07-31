import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Print {
        int index;
        int value;

        public Print(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            ArrayDeque<Print> q = new ArrayDeque<Print>();
            for (int i = 0; i < N; i++) {
                q.offer(new Print(i, Integer.parseInt(st.nextToken())));
            }


            int cnt = 1;
            while (!q.isEmpty()) {
                Print cur = q.poll();
                boolean flag = true;
                for (Print p : q) {
                    if (cur.value < p.value) {
                        flag = false;
                    }
                }

                if (flag) {
                    if (cur.index == M) {
                        System.out.println(cnt);
                        break;
                    }
                    cnt++;
                } else {
                    q.offer(cur);
                }
            }
        }

    }
}
