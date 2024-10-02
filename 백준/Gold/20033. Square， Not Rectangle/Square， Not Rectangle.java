import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(solution());
	}

	static int solution() {
		int start = 1;
		int end = N;
		int res = 0;

		while (start <= end) {
			int mid = (start + end) / 2;
			int cnt = 0;
			boolean isBreak = false;
			for (int i = 0; i < N; i++) {
				if (arr[i] >= mid) {
					if (++cnt >= mid) {
						isBreak = true;
						break;
					}
				} else {
					cnt = 0;
				}
			}
			if (isBreak) {
				res = Math.max(res, mid);
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return res;
	}
}