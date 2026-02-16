import java.util.*;

class Solution {
    
    static final int[] di = {-1, 0, 1, 0};
    static final int[] dj = {0, 1, 0, -1};
    static int x, y;
    static boolean[][] v;
    
    static int bfs(int i, int j, int[][] maps) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{i, j});
        v[i][j] = true;
        
        int cnt = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            while(--size >= 0) {
                int[] ij = q.poll();
                i = ij[0];
                j = ij[1];
                
                if(i == maps.length -1 && j == maps[0].length - 1) return cnt;
                
                for(int d = 0; d < 4; d++) {
                    int ni = i + di[d];
                    int nj = j + dj[d];
                    if(0 <= ni && ni < maps.length && 0 <= nj && nj < maps[0].length && maps[ni][nj] == 1 && !v[ni][nj]) {
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
        v = new boolean[maps.length][maps[0].length];
        
        answer = bfs(0, 0, maps);
        
        return answer;
    }
}