import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		int answer = 0;
		
		
		int start = 1;
		int end = Integer.MAX_VALUE;
		
		while(start <= end) {
			int mid = (start + end) / 2;
			int cnt = 0; // mid 높이 보다 커서 가능한 열의 개수
			int maxCnt = 0; // 가능한 열의 연속된 길이 중 가장 긴 길이
			
			for(int i = 0; i < N; i++) {
				if(arr[i] >= mid) { // mid보다 크다면 열의 개수 카운트
					cnt++;
				}
				else { 
					maxCnt = Math.max(maxCnt, cnt); // 가장 긴 길이인지 판단
					cnt = 0; // mid 보다 작다면 연속되지 않으므로 cnt 초기화
				}
			}
			// arr의 마지막 인덱스는 mid 높이보다 크다면 계산되지 않으므로 한번 더 계산
			maxCnt = Math.max(maxCnt, cnt);

			
			if(maxCnt >= mid) { // 가장 긴 길이가 mid 보다 길다면 mid * mid 사이즈의 정사각형은 무조건 나옴
				answer = Math.max(answer, mid);
				start = mid + 1;
			}
			
			else end = mid - 1;
			
		}
		System.out.println(answer);
	}
}
