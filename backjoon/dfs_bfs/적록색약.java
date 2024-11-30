package backjoon;

import java.util.*;
import java.io.*;

public class Main_적록색약_10026 {
	static int N;
	static final int[] di = { 1, 0, -1, 0 };
	static final int[] dj = { 0, 1, 0, -1 };
	static char[][] map;
	static boolean[][] v;

	static int bfs_rgb(int i, int j) {
		ArrayDeque<int[]> q = new ArrayDeque<>();

		v[i][j] = true;
		q.offer(new int[] { i, j });
		char prev = map[i][j];

		while (!q.isEmpty()) {
			int[] ij = q.poll();
			i = ij[0];
			j = ij[1];
			for (int d = 0; d < 4; d++) {
				int ni = i + di[d];
				int nj = j + dj[d];
				if (chkIndex(ni, nj) && map[ni][nj] == prev && !v[ni][nj]) {
					q.offer(new int[] { ni, nj });
					v[ni][nj] = true;
				}
			}
		}

		return 1;
	}

	static int bfs_rg_b(int i, int j) {
		ArrayDeque<int[]> q = new ArrayDeque<>();

		v[i][j] = true;
		q.offer(new int[] { i, j });
		char prev = map[i][j];

		while (!q.isEmpty()) {
			int[] ij = q.poll();
			i = ij[0];
			j = ij[1];
			for (int d = 0; d < 4; d++) {
				int ni = i + di[d];
				int nj = j + dj[d];
				if (chkIndex(ni, nj) && !v[ni][nj]) {
					if (prev == 'R' || prev == 'G') {
						if (map[ni][nj] == 'R' || map[ni][nj] == 'G') {
							q.offer(new int[] { ni, nj });
							v[ni][nj] = true;
						}
					} else {
						if (prev == map[ni][nj]) {
							q.offer(new int[] { ni, nj });
							v[ni][nj] = true;
						}
					}
				}
			}
		}

		return 1;
	}

	static boolean chkIndex(int i, int j) {
		if (0 <= i && i < N && 0 <= j && j < N)
			return true;
		return false;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		map = new char[N][N];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		v = new boolean[N][N];
		int answer = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!v[i][j])
					answer += bfs_rgb(i, j);
			}
		}

		v = new boolean[N][N];
		int answer2 = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!v[i][j])
					answer2 += bfs_rg_b(i, j);
			}
		}

		System.out.println(answer + " " + answer2);
	}
}
