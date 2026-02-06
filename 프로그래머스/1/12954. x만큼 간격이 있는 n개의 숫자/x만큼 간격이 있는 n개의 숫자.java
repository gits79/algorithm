import java.util.*;

class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        ArrayList<Long> lst = new ArrayList<>();
        
        for(int i = 1; i <= n; i++) {
            lst.add((long)x * i);
        }
        
        for (int i = 0; i < lst.size(); i++) {
            answer[i] = lst.get(i);
        }
        return answer;
    }
}