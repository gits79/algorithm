import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static final int[] di = { -1, 0, 1, 0 };
	static final int[] dj = { 0, 1, 0, -1 };

	static void dfs(int[][] arr, int i, int j) {
		int height = arr.length;
		int width = arr[0].length;
		arr[i][j] = 0;

		for (int k = 0; k < 4; k++) {
			int ni = i + di[k];
			int nj = j + dj[k];
			if (ni >= 0 && ni < height && nj >= 0 && nj < width && arr[ni][nj] == 1)
				dfs(arr, ni, nj);
		}
	}

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < t; tc++) {
			st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			int[][] arr = new int[n][m];

			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				arr[a][b] = 1;
			}

			int count = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (arr[i][j] == 1) {
						count++;
						dfs(arr, i, j);
					}
				}
			}

			System.out.println(count);

		}
	}
}
