import java.util.*;



class Solution {
    
    static int N = 11;
static int[][] map = new int[N][N];
static boolean[][][] v = new boolean[N][N][4];
static final int[] di = {-1 , 0, 1, 0};
static final int[] dj = {0 , 1, 0, -1};

static boolean chkIdx(int i, int j) {
    if(0 <= i && i < N && 0 <= j && j < N) return true;
    return false;
}

static int dir(char c) {
    if(c == 'U') return 0;
    else if(c == 'R') return 1;
    else if(c == 'D') return 2;
    return 3;
}
    
    
    public int solution(String dirs) {
        int answer = 0;
        int x = 5, y = 5;
        
        for(int i = 0; i < dirs.length(); i++) {
            char c = dirs.charAt(i);
            int dir = dir(c);
            int nx = x + di[dir]; 
            int ny = y + dj[dir]; 
            
            if(chkIdx(nx, ny)) {
                if(!v[x][y][dir]) {
                    answer++;
                    v[x][y][dir] = true;
                    v[nx][ny][(dir + 2) % 4] = true;
                }
                x = nx;
                y = ny;
            }
            
        }
        
        return answer;
    }
}