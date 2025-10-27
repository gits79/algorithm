import java.util.*;

class Solution {
    
    static final int[] di = {-1 , 0, 1, 0};
    static final int[] dj = {0 , 1, 0, -1};
    static boolean[][] v;
    static int N, M;
    
    static boolean chkIdx(int i, int j) {
        return 0 <= i && i < N && 0 <= j && j < M;
    }
    
    static int bfs(int i, int j, int op, String[] maps) {
        int cnt = 1;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        v[i][j] = true;
        q.offer(new int[]{i , j});
        
        while(!q.isEmpty()) {
            int size = q.size();
            
            while(--size >= 0){
                int[] ij = q.poll();
                i = ij[0];
                j = ij[1];
                
                if(op == 0 && maps[i].charAt(j) == 'L') {
                    return cnt;
                } else if(op == 1 && maps[i].charAt(j) == 'E') {
                    return cnt;
                }
                
                for(int d = 0; d < 4; d++) {
                    int ni = i + di[d];
                    int nj = j + dj[d];
                    if(chkIdx(ni, nj) && !v[ni][nj] && maps[ni].charAt(nj) != 'X') {
                        v[ni][nj] = true;
                        q.offer(new int[]{ni, nj});
                    }
                }
            }
            cnt++;
            
        }
        
        
        
        return -1;
    }
    
    public int solution(String[] maps) {
        int answer = 0;
        N = maps.length;
        M = maps[0].length();
        v = new boolean[N][M];
        int cnt = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++){
                if(maps[i].charAt(j) == 'S') {
                    cnt = bfs(i, j, 0, maps);
                    if(cnt == -1) return cnt;
                    answer += cnt;
                }
            }
        }
        v = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++){
                if(maps[i].charAt(j) == 'L') {
                    cnt = bfs(i, j, 1, maps);
                    if(cnt == -1) return cnt;
                    answer += cnt;
                }
            }
        }
        
        return answer - 2;
    }
}