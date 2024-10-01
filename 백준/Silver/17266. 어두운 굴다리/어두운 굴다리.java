import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[] arr = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		int answer = Integer.MAX_VALUE;

		int start = 0;
		int end = 100_001;

		while (start <= end) {
			int mid = (start + end) / 2;
			int left = 0;

			for (int i = 0; i < M; i++) {
				if (arr[i] - mid <= left) {
					left = arr[i] + mid;
				} else
					break;
			}

			if (left >= N) {
				answer = Math.min(answer, mid);
				end = mid - 1;
			} else {
				start = mid + 1;
			}

		}
		System.out.println(answer);

	}
}