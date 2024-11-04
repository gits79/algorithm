import java.io.*;
import java.util.*;

public class Main {

	private static int[] di = { -1, 0, 1, 0 };
	private static int[] dj = { 0, -1, 0, 1 };

	static int N, M, map[][];

	private static boolean chkIndex(int i, int j) {
		if (0 <= i && i < N && 0 <= j && j < M)
			return true;
		return false;
	}

	private static int temp(int i, int j) {
		int cnt = 0;
		int height = map[i][j];
		for (int d = 0; d < 4; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			// 인덱스안에 있으면 내 높이를 기준으로 사방탐색 나보다 높이가 낮아야만 겉넓이를 가질 수 있음
			if (chkIndex(ni, nj)) {
				int n = height - map[ni][nj];
				if (n > 0)
					cnt += n;
			}
			// 인덱스 벗어난 경우
			else {
				cnt += height;
			}

		}

		return cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int answer = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				answer += temp(i, j);
			}
		}

		answer += N * M * 2;

		System.out.println(answer);

	}

}
