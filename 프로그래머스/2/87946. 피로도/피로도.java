import java.util.*;



class Solution {
    static int N, answer;
    static boolean[] v;
    static int[] selected;
    
    static void recur(int cur, int[][] dungeons, int k) {
        if(cur == N) {
            answer = Math.max(calc(selected, dungeons, k), answer);
            return;
        }
        
        for(int i = 0; i < N; i++) {
            if(v[i]) continue;
            selected[cur] = i;
            v[i] = true;
            recur(cur + 1, dungeons, k);
            v[i] = false;
        }
        
    }
    
    static int calc(int[] arr, int[][] dungeons, int k) {
        int cnt = 0;
        for(int i = 0; i < N; i++){
            int n = arr[i];
            if(dungeons[n][0] <= k) {
                k -= dungeons[n][1];
                cnt++;
            }
        }
        return cnt;
    }
    
    public int solution(int k, int[][] dungeons) {
        answer = -1;
        N = dungeons.length;
        v = new boolean[N + 1];
        selected = new int[N];

        
        recur(0, dungeons, k);
        
        
        return answer;
    }
}