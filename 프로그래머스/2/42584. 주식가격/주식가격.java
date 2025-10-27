import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int size = prices.length;
        int[] answer = new int[size];
        
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        
        for(int i = 1; i < size; i++){
            int won = prices[i];
            while(!stack.isEmpty() && prices[stack.peek()] > won) {
                answer[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty()) {
            answer[stack.peek()] = size - stack.peek() - 1;
            stack.pop();
        }
        
        
        return answer;
    }
}