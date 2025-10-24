import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        
        int start = 0;
        int end = 10001;
        
        while (start <= end) {
            int mid = (start + end) / 2;
            
            int a = 0;
            int b = 0;
            
            for(int i = 0; i < citations.length; i++) {
                if(citations[i] >= mid) a++;
                else b++;
            }
            
            if(a >= mid && b <= mid) {
                answer = start;
                start = mid + 1;
            }
            else end = mid - 1;
            
            
        }
        // System.out.println(start);
        // System.out.println(end);
        
        return end;
    }
}