import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		ArrayDeque<Integer> q = new ArrayDeque<>();
		int[] arr = new int[m];
		int cnt = 0;

		for (int i = 1; i <= n; i++)
			q.offer(i);
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		for (int target : arr) {
			int left = 0, right = 0;

			for (int k : q) {
				if (k == target)
					break;
				left++;
			}

			right = q.size() - left;

			if (left <= right) {

				for (int i = 0; i < left; i++) {
					q.offer(q.poll());
				}
			} else {

				for (int i = 0; i < right; i++) {
					q.offerFirst(q.pollLast());
				}
			}


			q.poll();
			cnt += Math.min(left, right);
		}

		System.out.println(cnt);
	}
}