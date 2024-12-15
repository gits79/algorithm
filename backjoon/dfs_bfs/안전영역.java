import java.io.*;
import java.util.*;

public class Main {
	
	static int N, max, map[][];
	static boolean[][] v;
	static final int[] di = {-1, 0, 1, 0};
	static final int[] dj = {0, 1, 0, -1};
	
	static boolean chkIndex(int i, int j) {
		if(0 <= i && i < N && 0 <= j && j < N) return true;
		return false;
	}
	
	static int bfs(int i, int j, int h) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {i, j});
		v[i][j] = true;
		
		while(!q.isEmpty()) {
			int[] ij = q.poll();
			i = ij[0];
			j = ij[1];
			for(int d = 0; d < 4; d++) {
				int ni = i + di[d];
				int nj = j + dj[d];
				// 인덱스 범위 체크 후, 잠기는 높이보다 높고 방문여부 체크
				if(chkIndex(ni, nj) && map[ni][nj] > h && !v[ni][nj]) {
					q.offer(new int[] {ni, nj});
					v[ni][nj] = true;
				}
			}
		}
		
		return 0;
	}
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for(int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0; j < N; j++) {
        		int n = Integer.parseInt(st.nextToken());
        		map[i][j] = n;
        		max = Math.max(max, n);
        	}
        }
        
        int answer = 0;
        // 높이 1부터 최대 높이까지의 안전영역 개수 구함
        for(int h = 0; h <= max; h++) {
        	v = new boolean[N][N];
        	int cnt = 0;
        	for (int i = 0; i < N; i++) {
        		for (int j = 0; j < N; j++) {
        			if(map[i][j] > h && !v[i][j]) {
        				cnt++;
        				bfs(i, j, h);
        			}
        		}
        	}
        	answer = Math.max(answer, cnt);
        }
        System.out.println(answer);
    }
}
