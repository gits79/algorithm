import java.util.*;

class Solution {
    
    static int N, M;
    static boolean[] v;
    
    
    
    static void dfs(int i, int[][] computers) {
        v[i] = true;
        
        for(int j = 0; j < M; j++) {
            if(!v[j] && computers[i][j] == 1)
                dfs(j, computers);
        }
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        N = computers.length;
        M = computers[0].length;
        v = new boolean[N];
        
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(computers[i][j] == 1 && !v[i]) {
                    dfs(i , computers);
                    answer++;
                }
            }
        }
        
        
        
        return answer;
    }
}