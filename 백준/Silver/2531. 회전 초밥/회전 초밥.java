import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		// 회전 고려 배열 두배로
		int[] arr = new int[N * 2];
		int[] num = new int[d + 1];

		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());
			arr[i] = n;
			arr[i + N] = n;
		}

		int left = 0;
		int right = 0;
		int cnt = 1;
		num[arr[right]]++;
		int max = 0;

		while (right < N + k - 1) {
			// 연속해서 먹는 개수가 k개보다 적은 경우
			if (right - left + 1 < k) {
				right++;
				// 오른쪽 초밥이 가지수에 포함되지 않는다면 가짓수 증가
				// arr[right]는 오른쪽 초밥의 번호가 가짓수에 포함되는지 확인하는 것(num배열의 인덱스로 이용)
				if (num[arr[right]] == 0)
					cnt++;
				num[arr[right]]++;
			}
			// 연속해서 먹는 개수가 k개보다 많은 경우
			else {
				// 쿠폰 초밥이 포함되지 않은 경우 가짓수 더하기
				if (num[c] == 0) {
					max = Math.max(max, cnt + 1);
				} else {
					max = Math.max(max, cnt);
				}
				// 왼쪽 초밥의 수 줄이고
				num[arr[left]]--;
				if (num[arr[left]] == 0)
					cnt--;
				left++;
			}
		}

		System.out.println(max);
	}
}
