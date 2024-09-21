import java.util.*;
import java.io.*;

/*
 * 투 포인터
 */

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] answer = new int[2];
		

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		int left = 0; // 왼쪽 끝 시작
		int right = n - 1; // 오른쪽 끝 시작
		int init = Math.abs(arr[left] + arr[right]);

		while (left < right) {
			int sum = arr[left] + arr[right];

            // 현재의 절댓값을 계산
            int abs = Math.abs(sum);

            // 용액의 합이 초기값보다 작다면 초기화
            if (abs <= init) {
                answer[0] = arr[left];
                answer[1] = arr[right];
                if(sum == 0) break;
                init = abs;
            }

            // 합이 0보다 큰지 작은지 확인
            if (sum < 0) {
                left++; // 왼쪽을 늘려 더 큰값으로 확인
            } else {
                right--; // 오른쪽을 줄으면 더 작은 값이 나오기때문에 더 작은값으로 가능한지 확인
            }
        }

		for (int a : answer) System.out.print(a + " ");

	}
}