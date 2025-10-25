import java.util.*;

class Solution {
    
    static final int[] di = {-1, 0, 1, 0};
    static final int[] dj = {0, 1, 0, -1};
    
    static int N, M;
    static boolean[][] v;
    
    static boolean chkIdx(int n, int m){
        return (0 <= n && n < N && 0 <= m && m < M);
    }
    
    static int bfs(int[][] maps) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        v[0][0] = true;
        q.offer(new int[]{0 , 0});
        
        int cnt = 1;
        
        while(!q.isEmpty()) {
            int size = q.size();
            
            while(--size >= 0) {
                int[] ij = q.poll();
                int i = ij[0];
                int j = ij[1];
                
                if(i == N - 1 && j == M - 1) return cnt;
                
                for(int d = 0; d < 4; d++) {
                    int ni = i + di[d];
                    int nj = j + dj[d];
                    if(chkIdx(ni, nj) && !v[ni][nj] && maps[ni][nj] == 1) {
                        v[ni][nj] = true;
                        q.offer(new int[]{ni, nj});
                        
                    }
                }
                
            }
            cnt++;
        }
        
        return -1;
    }
    
    
    public int solution(int[][] maps) {
        int answer = 0;
        N = maps.length;
        M = maps[0].length;
        v = new boolean[N][M];
        
        answer = bfs(maps);
        
        return answer;
    }
}