import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int[] arr = new int[W + 1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < W + 1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int max_height = 0;
		int[] prefix = new int[W + 2];
		int[] suffix = new int[W + 2];
		// 누적합
		// 오른쪽 방향으로 진행하며 높은 위치를 기준으로 평평하게 천막을 씌우는 느낌
		for (int i = 1; i < W + 1; i++) {
			prefix[i] = Math.max(arr[i], prefix[i - 1]);
		}
		// 왼쪽 방향으로 진행하며 높은 위치를 기준으로 평평하게 천막을 씌우는 느낌
		max_height = 0;
		for (int i = W; i >= 0 ; i--) {
			suffix[i] = Math.max(arr[i], suffix[i + 1]);
		}
		// 양쪽 두개 누적합의 최소값이 문제를 기준으로 파란색 천막의 높이
		int sum = 0;
		for (int i = 0; i < W; i++) {
			sum += Math.min(prefix[i], suffix[i]) - arr[i];
		}

		System.out.println(sum);
		
	}
}
