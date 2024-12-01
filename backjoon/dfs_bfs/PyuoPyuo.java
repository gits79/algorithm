import java.io.*;
import java.util.*;

/*
1. 완탐으로 뿌요를 찾는 메서드
1-1. 뿌요가 있는 지점을 기준으로 사방탐색 bfs로 4개 이상인지 확인
1-2. 맞다면 bfs로 해당뿌요를 . 으로 바꿈
2. 뿌요밑에 .이라면 중력 떨어지는 메서드 
 */

public class Main {
	
	static int N = 12, M = 6;
	static char[][] map;
	static final int[] di = {-1, 0, 1, 0};
	static final int[] dj = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		map = new char[N][M];
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		int cnt = 0;
		while(true) {
			// 전체를 돌며 뿌요를 탐색
			if(!search()) break;
			// 중력 메서드
			gravity();
			cnt++;
		}
		System.out.println(cnt);
	}
	

	private static void gravity() {
		for (int i = 0; i < N - 1; i++) {
			for (int j = 0; j < M; j++) {
				int p = i;
				while(0 <= p && map[p][j] != '.' && map[p + 1][j] == '.') {
					char temp = map[p][j];
					map[p][j] = map[p + 1][j];
					map[p + 1][j] = temp;
					p--;
				}
			}
		}
	}

	private static boolean search() {
		boolean flag = false;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				// 뿌요가 있는지 탐색
				if(map[i][j] != '.') {
					// 뿌요가 4개 이상인지 찾음
					if(puyo4(i, j, new boolean[N][M])) {
						// 뿌요가 4개라면 터뜨림
						bomb(i, j, new boolean[N][M]);
						flag = true;
					}
				}
			}
		}
		return flag;
	}

	private static void bomb(int i, int j, boolean[][] v) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {i, j});
		char c = map[i][j];
		map[i][j] = '.';
		v[i][j] = true;
		
		while(!q.isEmpty()) {
			int[] ij = q.poll();
			i = ij[0];
			j = ij[1];
			for(int d = 0; d < 4; d++) {
				int ni = i + di[d];
				int nj = j + dj[d];
				if(chkIndex(ni, nj) && !v[ni][nj] && map[ni][nj] == c) {
					q.offer(new int[] {ni, nj});
					v[ni][nj] = true;
					map[ni][nj] = '.';
				}
			}
		}
	}

	private static boolean puyo4(int i, int j, boolean[][] v) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {i, j});
		char c = map[i][j];
		v[i][j] = true;
		int cnt = 1;
		
		while(!q.isEmpty()) {
			int[] ij = q.poll();
			i = ij[0];
			j = ij[1];
			for(int d = 0; d < 4; d++) {
				int ni = i + di[d];
				int nj = j + dj[d];
				if(chkIndex(ni, nj) && !v[ni][nj] && map[ni][nj] == c) {
					q.offer(new int[] {ni, nj});
					v[ni][nj] = true;
					cnt++;
				}
			}
		}
		if(cnt >= 4) return true;
		return false;
	}

	private static boolean chkIndex(int ni, int nj) {
		if(0 <= ni && ni < N && 0 <= nj && nj < M) return true;
		return false;
	}
}
