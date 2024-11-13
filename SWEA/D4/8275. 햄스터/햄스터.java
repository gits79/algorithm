import java.util.*;
import java.io.*;

public class Solution {

	static int N, X, M, arr[][], selected[], answer[], max;

	static int sum() {
		int summ = 0;
		for (int i = 0; i < N; i++) {
			summ += selected[i];
		}
		return summ;
	}

	static void perm(int cur) {
		if (cur == N) {
			for (int i = 0; i < M; i++) {
				int start = arr[i][0];
				int end = arr[i][1];
				int cnt = arr[i][2];

				int temp = 0;
				for (int j = start; j <= end; j++) {
					temp += selected[j];
				}
				if (temp != cnt) return;
			}
			int summ = sum();
			if (summ > max) {
				max = summ;
				for (int j = 0; j < N; j++)	answer[j] = selected[j];
			}
			
			return;
		}

		
		for (int i = 0; i <= X; i++) {
			selected[cur] = i;
			perm(cur + 1);
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			max = -1;
			arr = new int[M][3];
			selected = new int[N];
			answer = new int[N];
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken()) - 1;
				arr[i][1] = Integer.parseInt(st.nextToken()) - 1;
				arr[i][2] = Integer.parseInt(st.nextToken());
			}
			perm(0);
			if(max == -1) System.out.println("#"+tc+" " + max);
			else {
				System.out.print("#"+tc+" ");
				for(int a : answer) System.out.print(a + " ");
				System.out.println();
			}

		}

	}
}
