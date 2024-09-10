import java.util.*;
import java.io.*;

public class Main {

	static int N, M, arr[][];
	static int[][] answer;

	static int[] di = { -1, 0, 1, 0, 1, 1, -1, -1 };
	static int[] dj = { 0, 1, 0, -1, 1, -1, 1, -1 };

	static void dfs(int i, int j) {
		int cnt = 0;
		answer[i][j] = -1;
		for (int d = 0; d < 8; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			if (0 <= ni && ni < N && 0 <= nj && nj < M && arr[ni][nj] != -1) {
				answer[ni][nj] += 1;
			}
		}

	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			if (N == M && N == 0)
				break;
			arr = new int[N][M];
			answer = new int[N][M];
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < M; j++) {
					char c = str.charAt(j);
					if (c == '*')
						arr[i][j] = -1;
					else
						arr[i][j] = 0;
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (arr[i][j] == -1)
						dfs(i, j);
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (answer[i][j] == -1)
						System.out.print("*");
					else
						System.out.print(answer[i][j]);
				}
				System.out.println();
			}

		}

	}
}