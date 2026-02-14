import java.util.*;
import java.io.*;

public class Main {
    public static final int size = 1002;
    static int N;
    static int[] arr = new int[size];
    static int[] prefix = new int[size + 1];
    static int[] suffix = new int[size + 1];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a] = b;
        }

        for (int i = 1; i < size; i++) {
            prefix[i] = Math.max(arr[i], prefix[i - 1]);
        }

        for (int i = size - 1; i > 0; i--) {
            suffix[i] = Math.max(suffix[i + 1], arr[i]);
        }

        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += Math.min(prefix[i], suffix[i]);
        }

        System.out.println(sum);

    }
}
