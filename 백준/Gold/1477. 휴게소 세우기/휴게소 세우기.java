import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		// N + 1개인 이유 마지막 끝도 휴게소라 치고 넣어버림
		int[] arr = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		arr[N] = L;
		Arrays.sort(arr);
		int answer = Integer.MAX_VALUE;

		int start = 1;
		int end = 1000;

		while (start <= end) {
			int mid = (start + end) / 2;
			int left = 0;
			int cnt = 0;
			int idx = 0;

			while (idx <= N) {
				if (arr[idx] - left > mid) { // 왼쪽시작점부터 휴게소까지의 거리가 미드보다 길다면
					cnt++; // 휴게소 설치
					left += mid; // 휴게소는 시작점 + mid 길이
					// idx는 증가시키지 않기때문에 다시 그대로 돌아옴
					// while문 안의 while문과 동일
				} else {
					left = arr[idx]; // mid길이안에 휴게소가 있다면 시작점을 휴게소 위치로 초기화
					idx++;
				}
			}

			if (cnt > M) {
				start = mid + 1;
			}
			else {
				answer = Math.min(answer, mid);
				end = mid - 1;
			}
		}
		System.out.println(answer);

	}
}