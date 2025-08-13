import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, arr[];

    static int abs(int a, int b) {
        return Math.abs(a + b);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int left = 0;
        int right = N - 1;
        int answer = Integer.MAX_VALUE;
        int ans1 = 0;
        int ans2 = 0;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum == 0) {
                ans1 = left;
                ans2 = right;
                break;
            } else if (Math.abs(sum) <= answer) {
                answer = Math.abs(sum);
                ans1 = left;
                ans2 = right;

            }

            if (sum > 0)
                right--;
            else
                left++;
            
        }

        System.out.println(arr[ans1] + " " + arr[ans2]);

    }
}
