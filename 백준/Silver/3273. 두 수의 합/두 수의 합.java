import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int m = Integer.parseInt(br.readLine());

		
		int left = 0;
		int right = n - 1;
		int cnt = 0;
		int sum = 0;

		
		while (left < right) {
			sum = arr[left] + arr[right];

			if (sum == m) {
				cnt++;
				left++;
			} else if (sum < m) {
				left++;
			} else {
				right--;
			}
		}

		System.out.println(cnt);

	}

}
