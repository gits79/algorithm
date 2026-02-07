import java.util.*;

class Solution {
    public long solution(long n) {
        String[] s = Long.toString(n).split("");
        
        Arrays.sort(s, Collections.reverseOrder());
        
        StringBuilder sb = new StringBuilder();
        for(String str : s) sb.append(str);
        
        return Long.parseLong(sb.toString());
    }
}