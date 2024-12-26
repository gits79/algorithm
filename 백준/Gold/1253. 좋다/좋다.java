import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            int num = arr[i];

            int left = 0;
            int right = N - 1;

            while (true) {

                if (left == i) left++;
                else if (right == i) right--;
                
                if (left >= right) break;
                int sum = arr[left] + arr[right];

                if (sum == num) {
                    cnt++;
                    break;
                } else if (sum > num) {
                    right--;
                } else {
                    left++;
                }

            }

        }

        System.out.println(cnt);
    }
}
