import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		// 겹치는 수가 몇개인지 확인하는 배열
		int[] num = new int[100_001];
		int answer = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int left = 0;
		int right = 0;
		num[arr[right]]++;

		while (true) {
			// 오른쪽 포인터를 확인했을때 해당 수의 겹치는 개수가 K개를 넘는다면
			// 왼쪽 포인터가 해당하는 수의 개수를 하나 줄이고 포인터 위치를 한칸 오른쪽으로 옮김
			if (num[arr[right]] > K) {
				num[arr[left]]--;
				left++;
			} else {
				// 오른쪽 포인터를 확인했을때 해당 수의 겹치는 개수가 K개를 넘지 않는다면
				// 오른쪽 포인터를 한칸 오른쪽으로 옮기고 해당하는 수의 개수 하나 증가
				answer = Math.max(answer, right - left + 1);
				right++;
				if (right == N) break;
				num[arr[right]]++;
			}
		}

		System.out.println(answer);

	}
}