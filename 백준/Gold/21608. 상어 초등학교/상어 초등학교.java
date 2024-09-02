import java.io.*;
import java.util.*;

public class Main {

	static class Seat {
		int x, y;

		Seat(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int N;
	static int[][] arr;
	static List<Integer>[] prefer;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		prefer = new ArrayList[N * N + 1];

		for (int i = 1; i <= N * N; i++) {
			prefer[i] = new ArrayList<>();
		}

		for (int i = 0; i < N * N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int student = Integer.parseInt(st.nextToken());

			for (int j = 0; j < 4; j++) {
				prefer[student].add(Integer.parseInt(st.nextToken()));
			}

			Seat seat = setSeat(student);
			arr[seat.x][seat.y] = student;
		}

		System.out.println(cal());
	}

	static Seat setSeat(int student) {
		int maxPref = -1;
		int maxEmpty = -1;
		Seat seat = null;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 0) {
					int prefCount = 0;
					int emptyCount = 0;

					for (int k = 0; k < 4; k++) {
						int nx = i + di[k];
						int ny = j + dj[k];

						if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
							if (arr[nx][ny] == 0) {
								emptyCount++;
							} else if (prefer[student].contains(arr[nx][ny])) {
								prefCount++;
							}
						}
					}

					if (prefCount > maxPref || (prefCount == maxPref && emptyCount > maxEmpty)) {

						maxPref = prefCount;
						maxEmpty = emptyCount;
						seat = new Seat(i, j);
					}
				}
			}
		}

		return seat;
	}

	static int cal() {
		int sum = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int student = arr[i][j];
				int prefCount = 0;

				for (int k = 0; k < 4; k++) {
					int nx = i + di[k];
					int ny = j + dj[k];

					if (nx >= 0 && ny >= 0 && nx < N && ny < N && prefer[student].contains(arr[nx][ny])) {
						prefCount++;
					}
				}

				if (prefCount > 0) {
					sum += Math.pow(10, prefCount - 1);
				}
			}
		}

		return sum;
	}

}
