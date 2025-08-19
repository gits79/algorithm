import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, arr[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        long sum = 0;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
            sum += num;
        }

        long[] prefix = new long[2 * N + 1];
        for (int i = 0; i < 2 * N; i++) {
            prefix[i + 1] = prefix[i] + arr[i % N];
        }

        long half = sum / 2;
        long answer = 0;
        int right = 1;

        for (int left = 0; left < N; left++) {
            while (right <= left + N && prefix[right] - prefix[left] <= half) {
                answer = Math.max(answer, prefix[right] - prefix[left]);
                right++;
            }
        }

        System.out.println(answer);
    }
}
