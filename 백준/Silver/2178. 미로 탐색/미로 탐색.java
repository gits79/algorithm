import java.util.*;
import java.io.*;

public class Main {

	static int[] di = { -1, 0, 1, 0 }; 
	static int[] dj = { 0, 1, 0, -1 };

	static int n, m;
	static int[][] arr;
	static boolean[][] v;

	static void bfs(int i, int j) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		v[i][j] = true;
		q.offer(new int[] { i, j });


		while (!q.isEmpty()) {
			int[] ij = q.poll();
			i = ij[0];
			j = ij[1];

			for (int d = 0; d < 4; d++) {
				int ni = i + di[d];
				int nj = j + dj[d];

				if (0 <= ni && ni < n && 0 <= nj && nj < m && arr[ni][nj] == 1 && !v[ni][nj]) {
					v[ni][nj] = true;
					q.offer(new int[] { ni, nj });
					arr[ni][nj] = arr[i][j] + 1;

				}
			}
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n][m];
		v = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++)
				arr[i][j] = str.charAt(j) - '0';
		}

		bfs(n - 1, m - 1);
		System.out.println(arr[0][0]);
	}
}