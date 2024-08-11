import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static final int size = 10_000_001;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int[] arr1 = new int[size];
		int[] arr2 = new int[size];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			if (num < 0)
				arr2[num * -1] += 1;
			else
				arr1[num] += 1;
		}

		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			if (num < 0) {
				sb.append(arr2[num * -1] + " ");
			} else
				sb.append(arr1[num] + " ");
		}
		
		System.out.println(sb.toString().trim());

		
	}
}
