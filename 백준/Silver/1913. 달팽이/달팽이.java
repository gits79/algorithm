import java.util.*;
import java.io.*;

public class Main {

	static int n, m, c;
	static final int[] di = { 1, 0, -1, 0 };
	static final int[] dj = { 0, 1, 0, -1 };
	static int[][] arr;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		c = n * n;

		int i = 0, j = 0, d = 0;
		int x = 0, y = 0;

		while (true) {
			arr[i][j] = c--;
			if (arr[i][j] == m) {
				x = i + 1;
				y = j + 1;
			}
			int ni = i + di[d];
			int nj = j + dj[d];
			if (0 <= ni && ni < n && 0 <= nj && nj < n && arr[ni][nj] == 0) {
				i = ni;
				j = nj;
			} else {
				d = (d + 1) % 4;
				i = i + di[d];
				j = j + dj[d];
			}

			if (c == 0)
				break;
		}

		for (int k = 0; k < n; k++) {
			for (int l = 0; l < n; l++) {
				System.out.print(arr[k][l] + " ");
			}
			System.out.println();
		}
		System.out.println(x + " " + y);
	}
}