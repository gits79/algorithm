import java.util.*;

class Solution {
    public String solution(String s) {
        String[] answer = s.split(" ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i < answer.length; i++){
            max = Math.max(max, Integer.valueOf(answer[i]));
            min = Math.min(min, Integer.valueOf(answer[i]));
        }
        
        
        return min + " " + max;
    }
}