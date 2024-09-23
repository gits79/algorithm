import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] arr = new int[M];
        int[] cnt = new int[N];
        for (int i = 0; i < M; i++)
            arr[i] = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++)
            cnt[i] = Integer.parseInt(br.readLine());

        for (int t = 0; t < N; t++) {
            int c = cnt[t];
            int start = 1;
            int end = 2_000_000;
            int answer = 0;

            while (start <= end) {
                int mid = (start + end) / 2;
                int count = 0;
                int left = 0; // 빵의 시작부분


                for (int i = 0; i < M; i++) {
                    // 커팅지점과 빵의 시작부분의 길이가 mid보다 길고
                    // 끝부분과 자른지점의 길이가 mid보다 길다면
                    if (arr[i] - left >= mid && L - arr[i] >= mid) {
                        count++; // 커팅 횟수를 늘리고
                        left = arr[i]; // 빵의 시작부분은 커팅지점으로

                    }
                }
                // 자른 최소 길이가 커팅 횟수보다 많다면 가능하기 때문에 더 큰 값으로 가능한지 확인
                if (count >= c) {
                    answer = Math.max(answer, mid);
                    start = mid + 1;
                } else end = mid - 1;

            }
            System.out.println(answer);
        }

    }
}
