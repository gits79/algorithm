import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        
        int left = 0;
        int right = 0;
        int sum = sequence[right];
        int len = Integer.MAX_VALUE;
        
        while (left <= right) {
            if(sum == k) {
                if(right - left + 1 < len) {
                    answer[0] = left;
                    answer[1] = right;
                    len = right - left + 1;
                }
            }
            
            if(sum < k) {
                right++;
                if(right == sequence.length) break;
                sum += sequence[right];
            }
            else{
                sum -= sequence[left];
                left++;
            }
            
        }

        return answer;
    }
}