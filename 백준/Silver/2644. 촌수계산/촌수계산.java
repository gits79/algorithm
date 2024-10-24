import java.io.*;
import java.util.*;

public class Main {
	
	static List<Integer>[] g;
	static int N, A, B, K;
	static boolean[] vistied;
	
	static int bfs() {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.offer(A);
		vistied[A] = true;
		int cnt = 1;
		while(!q.isEmpty()) {
			// 현재 너비에 있는 만큼 bfs
			int size = q.size();
			
			while(--size >= 0) {
				int v = q.poll();
				for(int i : g[v]) {
					// 원하는 사람을 찾으면 리턴
					if(i == B) return cnt;
					
					if(!vistied[i]) {
						q.offer(i);
						vistied[i] = true;
					}
				}
			}
			cnt++;
		}
		return -1;
	}
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        N = Integer.parseInt(br.readLine());
        vistied = new boolean[N + 1];
        g = new List[N + 1];
        for (int i = 1; i < N + 1; i++) {
			g[i] = new ArrayList<>();
		}
        
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine());
        	int x = Integer.parseInt(st.nextToken());
        	int y = Integer.parseInt(st.nextToken());
        	// 자신의 자식을들 리스트에 넣는데
        	g[x].add(y);
        	// 부모가 누구인지도 넣음
        	g[y].add(x);
        }
        
        
        System.out.println(bfs());
    }
}