import java.io.*;
import java.util.*;


public class Main {
	
	static int M, N, K, cnt;
	static int[][] arr;
	static boolean[][] v;
	static ArrayList<Integer> lst = new ArrayList<>();
	
	static final int[] di = {-1, 0, 1, 0};
	static final int[] dj = {0, 1, 0, -1};
	
	
	static void dfs(int i, int j) {
		v[i][j] = true;
		cnt++;
		
		for(int d = 0; d < 4; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			if(0 <= ni && ni < M && 0 <= nj && nj < N && !v[ni][nj] && arr[ni][nj] == 0) {
				dfs(ni, nj);
			}
		}
		
		
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		cnt = 0;
		arr = new int[M][N];
		v = new boolean[M][N];
		
		for(int l = 0; l < K; l++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			for(int i = x1; i < x2; i++) {
				for(int j = y1; j < y2; j++) {
					arr[i][j] = 1;
				}
			}			
		}
		
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				cnt = 0;
				if(!v[i][j] && arr[i][j] == 0)
					dfs(i,j);
				if(cnt != 0) {
					lst.add(cnt);
				}
			}
		}
		
		Collections.sort(lst);
		System.out.println(lst.size());
		for(Integer n : lst) System.out.print(n + " ");
		

	}
}
