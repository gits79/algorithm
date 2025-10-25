import java.util.*;

class Solution {
    
    static int N = 5;
    static char[] c = {'A', 'E', 'I', 'O', 'U'};
    static boolean[] v = new boolean[N];
    static int[] selected = new int[N];
    static List<String> lst = new ArrayList<>();
    
    static void dfs(String word) {
        lst.add(word);
        
        if(word.length() == N) {
            return;
        }
        
        for(int i = 0; i < N; i++){
            dfs(word + c[i]);
        }
        
    }
    
    
    public int solution(String word) {
        int answer = 0;
        dfs("");
        for(int i = 1; i < lst.size(); i++){
            if(word.equals(lst.get(i))) answer = i;
        }
        
        return answer;
    }
}