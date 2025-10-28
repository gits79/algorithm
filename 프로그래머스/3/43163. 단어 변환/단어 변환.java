class Solution {
    
    static int answer = Integer.MAX_VALUE;
    static boolean[] v;
    
    static void dfs(String begin, String target, String[] words, int cnt) {
        // if(begin == target) return cnt;
        if(begin.equals(target)) answer = Math.min(answer, cnt);
        
        for(int i = 0; i < words.length; i++) {
            String next = words[i];
            int n = 0;
            if(v[i]) continue;
            for(int j = 0; j < next.length(); j++) {
                if(begin.charAt(j) == next.charAt(j)) n++;
            }
            if(n == begin.length() - 1) {
                v[i] = true;
                dfs(next, target, words, cnt + 1);
                v[i] = false;
                // dfs(next, target, words, cnt + 1);
                
            }
        }
        
    }
    
    public int solution(String begin, String target, String[] words) {
        v = new boolean[words.length];
        
        dfs(begin, target, words, 0);
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
}