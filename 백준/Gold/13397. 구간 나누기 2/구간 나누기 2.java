import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int minArr = Integer.MAX_VALUE;
		int maxArr = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			minArr = Math.min(minArr, arr[i]);
			maxArr = Math.max(maxArr, arr[i]);
		}

		int start = 0;
		int end = maxArr - minArr;
		while (start <= end) {
			int mid = (start + end) / 2;
			int cnt = 1;
			int max = 0;
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				int temp = arr[i];
				max = Math.max(max, temp);
				min = Math.min(min, temp);
				if (max - min > mid) {
					max = temp;
					min = temp;
					cnt++;
				}
			}
			if (cnt <= M) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}

		}
		System.out.println(start);

	}
}