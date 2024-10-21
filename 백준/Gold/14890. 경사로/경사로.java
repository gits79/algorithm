import java.util.*;
import java.io.*;

public class Main {
	static int N, L, cnt;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			if (down(i))
				cnt++;

			if (right(i))
				cnt++;
		}

		System.out.println(cnt);
	}

	public static boolean down(int c) {
		boolean[] visit = new boolean[N]; // 경사로를 넣었는가를 의미

		for (int i = 0; i < N - 1; i++) {
			// 높이차가 1보다 크다면 경사로 설치 불가
			if (Math.abs(map[i][c] - map[i + 1][c]) > 1)
				return false;

			if (map[i + 1][c] - map[i][c] == -1) // 밑이 1단 낮은 경우
			{
				for (int j = i + 1; j <= i + L; j++) {
					if (j >= N || map[i + 1][c] != map[j][c] || visit[j])
						return false;

					visit[j] = true;
				}
			}

			if (map[i + 1][c] - map[i][c] == 1) // 밑이 1단 높은 경우
			{
				for (int j = i; j > i - L; j--) {
					if (j < 0 || map[i][c] != map[j][c] || visit[j])
						return false;

					visit[j] = true;
				}
			}
		}

		return true;
	}

	public static boolean right(int r) {
		boolean[] visit = new boolean[N]; // 경사로를 넣었는가를 의미

		for (int i = 0; i < N - 1; i++) {
			if (Math.abs(map[r][i] - map[r][i + 1]) > 1)
				return false;

			if (map[r][i + 1] - map[r][i] == -1) // 밑이 1단 낮은 경우
			{
				for (int j = i + 1; j <= i + L; j++) {
					if (j >= N || map[r][i + 1] != map[r][j] || visit[j])
						return false;

					visit[j] = true;
				}
			}

			if (map[r][i + 1] - map[r][i] == 1) // 밑이 1단 높은 경우
			{
				for (int j = i; j > i - L; j--) {
					if (j < 0 || map[r][i] != map[r][j] || visit[j])
						return false;

					visit[j] = true;
				}
			}
		}

		return true;
	}
}