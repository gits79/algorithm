import java.util.*;
import java.io.*;

public class Main {
	static final int[] di = { -1, 0, 1, 0 };
	static final int[] dj = { 0, 1, 0, -1 };
	static int n, m, c = 0;
	static char[][] arr;
	static boolean[][] v;

	static void dfs(int i, int j) {
		v[i][j] = true;
		if (arr[i][j] == 'P')
			c++;

		for (int d = 0; d < 4; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			if (0 <= ni && ni < n && 0 <= nj && nj < m && !v[ni][nj] && arr[ni][nj] != 'X')
				dfs(ni, nj);
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new char[n][m];
		v = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = str.charAt(j);
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 'I') {
					dfs(i, j);
				}
			}
		}
		System.out.println((c == 0) ? "TT" : c);

	}
}