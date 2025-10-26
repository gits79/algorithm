import java.util.*;

class Solution {
    
    static final int[] di = {-1 ,0 ,1 ,0}; // 상 우 하 좌
    static final int[] dj = {0 ,1 ,0 ,-1};
    static final char[] op = {'U', 'R', 'D', 'L'};
    
    static int x, y;
    static int N = 11;
    static boolean[][][] v;
    
    static int cnt;
    
    static int getDir(char c) {
        for(int i = 0; i < 4; i++) 
            if(c == op[i]) return i;
        return -1;
    }
    
    static void move(int dir) {
        int nx = x + di[dir];
        int ny = y + dj[dir];
        if(chkIdx(nx, ny)) {
            if(!v[x][y][dir]) {
            cnt++;
            v[x][y][dir] = true;
            v[nx][ny][(dir + 2) % 4] = true;
                
            }
            x = nx;
            y = ny;
        }
        
    }
    
    static boolean chkIdx(int i, int j){
        return (0 <= i && i < N && 0 <= j && j < N);
    }
    
    public int solution(String dirs) {
        cnt = 0;
        x = 5;
        y = 5;
        v = new boolean[N][N][4];
        
        for(int i = 0; i < dirs.length(); i++) {
            int dir = getDir(dirs.charAt(i));
            move(dir);
        }
        
        return cnt;
    }
}