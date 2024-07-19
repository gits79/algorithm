

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int size = 1002;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[size];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			arr[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
		}

		int[] prefix = new int[size + 1];
		int[] suffix = new int[size + 1];


		for (int i = 1; i < size; i++) {
			prefix[i] = Math.max(arr[i], prefix[i - 1]);
		}

		for (int i = size - 1; i > 0; i--) {
			suffix[i] = Math.max(arr[i], suffix[i + 1]);
		}

		int answer = 0;

		for (int i = 1; i < size; i++)
			answer += Math.min(suffix[i], prefix[i]);

		System.out.println(answer);

	}
}
