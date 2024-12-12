import java.io.*;
import java.util.*;

public class Main {

	static final int[] di = { 0, 0, -1, 1 };
	static final int[] dj = { 1, -1, 0, 0 };

	static void swap(int i, int j, int x, int y, int[][] arr) {
		int temp = arr[i][j];
		arr[i][j] = arr[x][y];
		arr[x][y] = temp;
	}

	static void Up(int[][] arr) {
		for (int i = 3; i >= 1; i--) {
			int temp = arr[i - 1][1];
			arr[i - 1][1] = arr[i][1];
			arr[i][1] = temp;
		}
	}

	static void Down(int[][] arr) {
		for (int i = 1; i < 4; i++) {
			int temp = arr[i][1];
			arr[i][1] = arr[i - 1][1];
			arr[i - 1][1] = temp;
		}
	}

	static void Right(int[][] arr) {
		swap(1, 0, 3, 1, arr);
		swap(1, 0, 1, 2, arr);
		swap(1, 0, 1, 1, arr);
	}

	static void Left(int[][] arr) {
		swap(1, 0, 3, 1, arr);
		swap(1, 1, 3, 1, arr);
		swap(3, 1, 1, 2, arr);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		int[][] die = new int[4][3];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		for (int k = 0; k < K; k++) {
			int dir = Integer.parseInt(st.nextToken()) - 1;
			int nx = x + di[dir];
			int ny = y + dj[dir];

			if (0 <= nx && nx < N && 0 <= ny && ny < M) {
				int next = map[nx][ny];
				

				switch (dir) {
				case 0:
					Right(die);
					break;
				case 1:
					Left(die);
					break;
				case 2:
					Up(die);
					break;
				case 3:
					Down(die);
					break;
				}
                if (next == 0)
					map[nx][ny] = die[3][1];
				else  {
					die[3][1] = next;
					map[nx][ny] = 0;
				}
				x = nx;
				y = ny;
				System.out.println(die[1][1]);
			}
		}

	}
}
