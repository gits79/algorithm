import java.io.*;
import java.util.*;
public class Main{
	
	static int N, M;
	static int[][] board;
	static int area;
	static int[] dr = {-1, 0, 1, 0}; // 상우하좌
	static int[] dc = {0, 1, 0, -1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		
		board = new int[N][M];
		
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j < M; j++) {				
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 윗면넓이 + 밑면넓이 시작
		area = 2 * N * M;
		
		for(int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int h = board[i][j];
				for(int k = 1; k <= h; k++) { // 해당칸의 높이
					int curh = k;
					for(int d = 0; d < 4; d++) {
						int rr = i + dr[d];
						int cc = j + dc[d];
						if(0 > rr || rr >= N || 0 > cc || cc >= M) {
							area++;	
						}
						if(0 <= rr && rr < N && 0 <= cc && cc < M && curh > board[rr][cc]) {
							area++;
						}
					}
				}
			}
		}

		System.out.println(area);

		br.close();
	}
}
