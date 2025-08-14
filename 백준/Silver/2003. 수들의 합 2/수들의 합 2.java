import java.io.BufferedReader;
import java.io.InputStreamReader;
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
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0, right = 0;
        int sum = 0, answer = 0;


        while (true) {

            if (sum == M) {
                answer++;
                sum -= arr[left++];
            } else if (sum > M) {
                sum -= arr[left++];
            } else {
                if (right == N) break;
                sum += arr[right++];
            }

        }

        System.out.println(answer);


    }
}
