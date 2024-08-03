import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static final int[][] d = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	private static final int size = 101;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[size][size];

		for (int k = 0; k < n; k++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			for (int i = w; i < w + 10; i++) {
				for (int j = h; j < h + 10; j++) {
					if (arr[i][j] == 0)
						arr[i][j] = 1;
				}
			}
		}
		int answer = 0;

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (arr[i][j] == 1) {
					int cnt = 0;
					for (int k = 0; k < 4; k++) {
						int dx = i + d[k][0];
						int dy = j + d[k][1];
						if (dx >= 0 && dx < size && dy >= 0 && dy < size) {
							if (arr[dx][dy] == 0) {
								cnt++;
							}
						}
					}
					if (cnt == 1)
						answer++;
					else if (cnt == 2)
						answer += 2;
				}
			}
		}

		System.out.println(answer);
	}

}
