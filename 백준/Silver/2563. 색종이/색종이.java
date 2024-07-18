

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][2];
		StringTokenizer st;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] area = new int[100][100];

		for (int i = 0; i < n; i++) {
			int x = arr[i][0];
			int y = arr[i][1];
			for (int j = x; j < x + 10; j++) {
				for (int k = y; k < y + 10; k++) {
					area[j][k] = 1;
				}
			}
		}

		int cnt = 0;
		for (int i = 0; i < 100; i++)
			for (int j = 0; j < 100; j++)
				cnt += area[i][j];

		System.out.println(cnt);

	}
}
