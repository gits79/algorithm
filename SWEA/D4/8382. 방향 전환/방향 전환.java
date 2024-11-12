import java.util.*;
import java.io.*;

public class Solution {

	static int N, map[][];
	static final int[] di = { -1, 0, 1, 0 };
	static final int[] dj = { 0, 1, 0, -1 };
	static boolean[][] v;

	static boolean chkIndex(int i, int j) {
		if (0 <= i && i < N && 0 <= j && j < N)
			return true;
		return false;
	}

	static int bfs(int i, int j, int dir, int end_x, int end_y) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		v[i][j] = true;
		q.offer(new int[] { i, j });
		int cnt = 0;
//		System.out.println("i: " + i + " , j: " + j);
		if(i == end_x && j == end_y) return cnt;
		while (!q.isEmpty()) {

			int size = q.size();

			while (--size >= 0) {
				int[] ij = q.poll();
				i = ij[0];
				j = ij[1];
				// 방향에 따른 이동
				if (dir % 2 == 0) {
					for (int d = 0; d < 3; d += 2) {
						int ni = i + di[d];
						int nj = j + dj[d];
						if (chkIndex(ni, nj) && !v[ni][nj]) {
//							System.out.println("ni: " + ni + " , nj: " + nj);
							if (ni == end_x && nj == end_y) {
								cnt++;
								return cnt;
							}
							q.offer(new int[] { ni, nj });
							v[ni][nj] = true;
						}
					}
				} else {
					for (int d = 1; d < 4; d += 2) {
						int ni = i + di[d];
						int nj = j + dj[d];
						if (chkIndex(ni, nj) && !v[ni][nj]) {
//							System.out.println("ni: " + ni + " , nj: " + nj);
							if (ni == end_x && nj == end_y) {
								cnt++;
								return cnt;
							}
							q.offer(new int[] { ni, nj });
							v[ni][nj] = true;
						}
					}
				}

			}
			cnt++;
			dir = (dir + 1) % 4;

		}
		return cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken()) + 100;
			int y1 = Integer.parseInt(st.nextToken()) + 100;
			int x2 = Integer.parseInt(st.nextToken()) + 100;
			int y2 = Integer.parseInt(st.nextToken()) + 100;
			int n = Math.max(Math.abs(x2 - x1), Math.abs(y2 - y1));
			N = 201;
			map = new int[N][N];
			int answer = Integer.MAX_VALUE;

			v = new boolean[N][N];
			answer = Math.min(answer, bfs(x1, y1, 0, x2, y2));
			v = new boolean[N][N];
			answer = Math.min(answer, bfs(x1, y1, 1, x2, y2));

			System.out.println("#" + tc + " " + answer);
		}

	}
}
