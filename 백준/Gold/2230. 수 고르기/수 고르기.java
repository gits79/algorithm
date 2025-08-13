import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M, arr[];

    static int abs(int a, int b) {
        return Math.abs(a - b);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int left = 0;
        int right = 0;
        int answer = Integer.MAX_VALUE;

        while (right < N) {
            int num = abs(arr[left], arr[right]);

            if (num == M) {
                answer = M;
                break;
            } else if (num > M) {
                answer = Math.min(answer, num);
                left++;
            } else {
                right++;
            }

        }

        System.out.println(answer);

    }
}
