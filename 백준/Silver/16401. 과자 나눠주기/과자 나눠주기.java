import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		long end = 0;
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			arr[i] = n;
			end = Math.max(end, n);
		}

		long start = 1;

		while (start <= end) {
			long mid = (start + end) / 2;
			int cnt = 0;
			// 막대 과자는 여러 조각으로 나눌 수 있기에 미드 크기로 나누면 몫 만큼
			// 조카들에게 나눠줄 수 있음
			for (int len : arr) cnt += len / mid;
			

			if (cnt >= M) start = mid + 1;
			
			else end = mid - 1;

		}

		System.out.println(end);

	}
}