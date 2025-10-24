import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        int a = 0, b = 0;
        for(int i = 0; i < 10000; i++) {
            for(int j = 0; j < citations.length; j++) {
                if(citations[j] >= i) a++;
                else b++;
                if(b > i) break;
            }
            if(b <= i && a >= i) answer = i;
            a = 0;
            b = 0;
        }
        
        
        return answer;
    }
}