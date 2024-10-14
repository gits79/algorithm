import java.io.*;
import java.util.*;

public class Solution {

	static int N, M, K, map[][], time[][], n, m;
	static boolean[][] active;

	static final int[] di = { -1, 0, 1, 0 };
	static final int[] dj = { 0, 1, 0, -1 };

	private static void timeGo() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				active[i][j] = false;
				time[i][j] -= 1;
			}
		}
	}

	private static boolean indexChk(int i, int j) {
		if (0 <= i && i < n && 0 <= j && j < m)
			return true;
		return false;
	}

	private static void spread() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (time[i][j] == -1) {
					int size = map[i][j];
					for (int d = 0; d < 4; d++) {
						int ni = i + di[d];
						int nj = j + dj[d];
						if (indexChk(ni, nj)) {
							if (map[ni][nj] == 0) {
								map[ni][nj] = size;
								time[ni][nj] = size;
								active[ni][nj] = true;
							} else if (map[ni][nj] != 0 && active[ni][nj]) {
								if (size > map[ni][nj]) {
									map[ni][nj] = size;
									time[ni][nj] = size;
									active[ni][nj] = true;
								}
							}
						}
					}
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N + K][M + K];
			time = new int[N + K][M + K];
			active = new boolean[N + K][M + K];
			n = N + K;
			m = M + K;
			for (int i = K / 2; i < K / 2 + N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = K / 2; j < K / 2 + M; j++) {
					int n = Integer.parseInt(st.nextToken());
					map[i][j] = n;
					time[i][j] = n;
					active[i][j] = true;
				}
			}

			int t = 1;
			while (t <= K) {
				timeGo();
				spread();
				t++;
			}

			int sum = 0;
			for (int i = 0; i < N + K; i++) {
				for (int j = 0; j < M + K; j++) {
					if (map[i][j] > 0 && map[i][j] + time[i][j] > 0)
						sum += 1;
				}
			}
			System.out.println("#" + tc + " " + sum);
		}
	}
}
