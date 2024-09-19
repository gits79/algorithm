import java.util.*;
import java.io.*;

public class Main {

	static int n, c;
	static int[][] arr;
	static boolean[][] v;

	static final int[] di = { 1, 2, 2, 1, -1, -2, -2, -1 };
	static final int[] dj = { 2, 1, -1, -2, -2, -1, 1, 2 };

	static int bfs(int i, int j, int end_x, int end_y) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		int cnt = 0;
		v[i][j] = true;
		q.offer(new int[] { i, j });

		while (!q.isEmpty()) {
			int size = q.size();
			cnt++;
			while (--size >= 0) {
				int[] ij = q.poll();
				i = ij[0];
				j = ij[1];

				for (int d = 0; d < 8; d++) {
					int ni = i + di[d];
					int nj = j + dj[d];

					if (ni == end_x && nj == end_y)
						return cnt;

					if (0 <= ni && ni < n && 0 <= nj && nj < n && !v[ni][nj]) {
						q.offer(new int[] { ni, nj });
						v[ni][nj] = true;
					}
				}
			}
		}
		return cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n][n];
			v = new boolean[n][n];
			st = new StringTokenizer(br.readLine());
			int start_x = Integer.parseInt(st.nextToken());
			int start_y = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int end_x = Integer.parseInt(st.nextToken());
			int end_y = Integer.parseInt(st.nextToken());
			
			
			int answer = bfs(start_x, start_y, end_x, end_y);
			if (start_x == end_x && start_y == end_y)
				answer = 0;
			System.out.println(answer);

		}

	}
}
