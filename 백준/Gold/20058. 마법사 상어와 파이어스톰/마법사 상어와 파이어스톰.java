import java.io.*;
import java.util.*;

/*
부분 격자로 나누기 위한 함수
이중포문을 돌면서 i 와 j 의 크기는 2 ** L 만큼 증가
2 ** L 사이즈의 이중 배열에 대해 90도 회전한 임시 배열 생성
임시 배열을 본 배열에 대입
 */
public class Main {
	static int N, L, Q, N_SIZE, L_SIZE, sum;
	static int[][] arr;
	static boolean[][] visited;
	static final int[] di = { -1, 0, 1, 0 };
	static final int[] dj = { 0, 1, 0, -1 };

	static void div() {
		for (int i = 0; i < N_SIZE; i += L_SIZE) {
			for (int j = 0; j < N_SIZE; j += L_SIZE) {
				// rotate 함수대입
				int[][] temp = rotate(i, j);
				// rotate 한 배열을 다시 원 배열에 업데이트
				update(i, j, temp);
			}
		}
	}

	static int[][] rotate(int sr, int sc) {
		int[][] temp = new int[L_SIZE][L_SIZE];
		for (int i = 0; i < L_SIZE; i++) {
			for (int j = 0; j < L_SIZE; j++) {
				temp[j][L_SIZE - i - 1] = arr[sr + i][sc + j];
			}
		}
		return temp;
	}

	static void update(int sr, int sc, int[][] temp) {
		for (int i = sr; i < sr + L_SIZE; i++) {
			for (int j = sc; j < sc + L_SIZE; j++) {
				arr[i][j] = temp[i - sr][j - sc];
			}
		}
	}

	static int checkIce(int i, int j) {
		int cnt = 0;
		for (int d = 0; d < 4; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			if (0 <= ni && ni < N_SIZE && 0 <= nj && nj < N_SIZE && arr[ni][nj] > 0) {
				cnt++;
			}
		}

		return cnt;
	}

	static int countIce(int i, int j) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		visited[i][j] = true;
		int cnt = 1;
		q.offer(new int[] { i, j });
		while (!q.isEmpty()) {
			int[] ij = q.poll();
			i = ij[0];
			j = ij[1];
			for (int d = 0; d < 4; d++) {
				int ni = i + di[d];
				int nj = j + dj[d];
				if (0 <= ni && ni < N_SIZE && 0 <= nj && nj < N_SIZE && !visited[ni][nj] && arr[ni][nj] > 0) {
					cnt++;
					visited[ni][nj] = true;
					q.offer(new int[] { ni, nj });
				}
			}
		}
		sum += cnt;
		return cnt;
	}

	static int total() {
		int sum = 0;
		for (int i = 0; i < N_SIZE; i++) {
			for (int j = 0; j < N_SIZE; j++) {
				if (arr[i][j] > 0)
					sum += arr[i][j];
			}
		}
		return sum;
	}

	static int iceSize() {
		int answer = 0;
		visited = new boolean[N_SIZE][N_SIZE];
		for (int i = 0; i < N_SIZE; i++) {
			for (int j = 0; j < N_SIZE; j++) {
				if (!visited[i][j] && arr[i][j] > 0) {
					int count = countIce(i, j);
					answer = Math.max(answer, count);
				}
			}
		}
		return answer;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		N_SIZE = (int) Math.pow(2, N);
		arr = new int[N_SIZE][N_SIZE];
		sum = 0;
		for (int i = 0; i < N_SIZE; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N_SIZE; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ArrayList<Integer> level = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		while (st.hasMoreTokens()) {
			int l = Integer.parseInt(st.nextToken());
			level.add(l);
		}

		// 입력 끝
		for (int l = 0; l < level.size(); l++) {
			L = level.get(l);
			L_SIZE = (int) Math.pow(2, L);
			div();
			boolean[][] chk = new boolean[N_SIZE][N_SIZE];
			for (int i = 0; i < N_SIZE; i++) {
				for (int j = 0; j < N_SIZE; j++) {
					if (checkIce(i, j) < 3)
						chk[i][j] = true;

				}
			}
			// 모두 체크후 얼음 하나씩 감소시키기
			for (int i = 0; i < N_SIZE; i++) {
				for (int j = 0; j < N_SIZE; j++) {
					if (chk[i][j])
						arr[i][j] -= 1;
				}
			}

		}
		System.out.println(total());
		System.out.println(iceSize());

	}
}
