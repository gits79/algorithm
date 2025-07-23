import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] twoSomePlaces = new int[N * N];
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                twoSomePlaces[cnt++] = arr[i] + arr[j];
            }
        }

        Arrays.sort(twoSomePlaces);

        int answer = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int sum = arr[i] - arr[j];
                int left = 0, right = cnt - 1;

                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    if (sum == twoSomePlaces[mid]) {
                        answer = Math.max(answer, arr[i]);
                        break;
                    } else if (sum > twoSomePlaces[mid]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }

                }


            }
        }

        System.out.println(answer);


    }


}
