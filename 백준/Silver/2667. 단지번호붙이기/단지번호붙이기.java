import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static final int[] di = { -1, 0, 1, 0 };
	static final int[] dj = { 0, 1, 0, -1 };
	static int count = 0;

	static void dfs(int[][] arr, int i, int j) {
		int size = arr[0].length;
		arr[i][j] = 0;

		for (int d = 0; d < 4; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			if (ni >= 0 && ni < size && nj >= 0 && nj < size && arr[ni][nj] == 1) {
				count++;
				dfs(arr, ni, nj);
			}
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		ArrayList<Integer> answer = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			String temp = br.readLine();
			for (int j = 0; j < temp.length(); j++) {
				arr[i][j] = temp.charAt(j) - '0';
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == 1) {
					count = 1;
					dfs(arr, i, j);
					answer.add(count);
				}
			}
		}

		System.out.println(answer.size());
		Collections.sort(answer);
		for (int i : answer)
			System.out.println(i);

	}

}
