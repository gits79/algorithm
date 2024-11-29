import java.io.*;
import java.util.*;

public class Main {
	static final int[] di = { -1, 0, 1, 0 };
	static final int[] dj = { 0, 1, 0, -1 };
	static char[][] map;

	static int answer = 0;
	static ArrayDeque<Integer> lst = new ArrayDeque<>();

	// 조합의 번호에 맞는 인덱스 위치 찾기
	static int[] searchIndex(int n) {
		int[][] arr = create();
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (n == arr[i][j])
					return new int[] { i, j };
			}
		}
		return null;
	}

	static int[][] create() {
		int[][] temp = new int[5][5];
		int c = 1;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				temp[i][j] = c++;
			}
		}
		return temp;
	}

	static void recur(int cur, int start) {
		
		if (cur == 7) {
			// bfs 시작할 x, y 좌표 찾기
			int[] ij = searchIndex(lst.peek());
			// bfs 시작
			answer += bfs(ij[0], ij[1]);
			return;
		}

		for (int i = start; i <= 25; i++) {
			lst.push(i);
			recur(cur + 1, i + 1);
			lst.pop();
		}

	}

	static boolean chkIndex(int i, int j) {
		if (0 <= i && i < 5 && 0 <= j && j < 5)
			return true;
		return false;
	}

	static int bfs(int i, int j) {
		int[][] arr = create();
		ArrayDeque<int[]> q = new ArrayDeque<>();
		// cnt는 이다솜파의 수 , len은 7명이 맞는지 사람 수
		int cnt = 0;
		int len = 1;
		if (map[i][j] == 'S') cnt++;
		q.offer(new int[] { i, j });
		// -1은 방문처리
		arr[i][j] = -1;

		while (!q.isEmpty()) {
			int[] ij = q.poll();
			i = ij[0];
			j = ij[1];
			for (int d = 0; d < 4; d++) {
				int ni = i + di[d];
				int nj = j + dj[d];
				// 인덱스를 벗어나거나 인접하지 않는 경우 리턴
				if (chkIndex(ni, nj) && lst.contains(arr[ni][nj])) {
					q.offer(new int[] { ni, nj });
					arr[ni][nj] = -1;
					len++;
					if (map[ni][nj] == 'S')	cnt++;
				}
			}
		}
		// 사람이 7명이고 이다솜파가 4명 이상인 경우
		if (cnt >= 4 && len == 7) return 1;
		return 0;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		map = new char[5][5];
		for (int i = 0; i < 5; i++) {
			String str = br.readLine();
			for (int j = 0; j < 5; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		recur(0, 1);
		System.out.println(answer);

	}
}
