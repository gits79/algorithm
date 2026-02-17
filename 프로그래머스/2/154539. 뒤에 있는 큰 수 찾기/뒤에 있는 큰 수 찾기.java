import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();
        
        stack.push(0);
        for(int i = 1; i < numbers.length; i++) {
            int n = numbers[i];
            
            while(!stack.isEmpty() && numbers[stack.peek()] < n) {
                    answer[stack.pop()] = n;
                }
            
            stack.push(i);
            
        }
        
        while(!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }
        
        return answer;
    }
}