import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M, arr[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        int max = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        int start = max;
        int end = Arrays.stream(arr).sum();

        while (start <= end) {
            int mid = (start + end) / 2;
            int cnt = 1;
            int sum = 0;

            for (int i = 0; i < N; i++) {
                int len = arr[i];
                if (len + sum <= mid) {
                    sum += len;
                } else {
                    cnt++;
                    sum = len;
                }
            }

            if (cnt <= M) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }

        }

        System.out.println(start);
    }
}
