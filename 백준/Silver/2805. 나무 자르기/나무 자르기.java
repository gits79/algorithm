import java.util.*;
import java.io.*;

public class Main {

	static int N, M, arr[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		
		long start = 0;
		long end = 1000000000;
		
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			arr[i] = n;
			end = Math.max(end, n);
		}

		while (start <= end) {
			long mid = (start + end) / 2;

			long len = 0;
			for (int i = 0; i < N; i++) {
				long temp = arr[i] - mid;
				if (temp > 0) len += temp;
			}

			if (len >= M) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		System.out.println(end);

	}
}