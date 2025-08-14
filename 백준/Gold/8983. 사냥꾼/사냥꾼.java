import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M, L, shooter[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        shooter = new int[N];
        st = new StringTokenizer(br.readLine());
        int max = 0;
        for (int i = 0; i < N; i++) {
            shooter[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, shooter[i]);
        }

        Arrays.sort(shooter);
        int cnt = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int start = 0;
            int end = N;

            while (start <= end) {
                int mid = (start + end) / 2;

                int range = shooter[mid];
                int length = Math.abs(range - x) + y;

                if (length <= L) {
                    cnt++;
                    break;
                }
                if (range - x > 0) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }

            }

        }

        System.out.println(cnt);

    }
}
