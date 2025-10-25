import java.util.*;

class Solution {
    
    public boolean chk(String s) {

        ArrayDeque<Character> stack = new ArrayDeque<>();
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '{' || c == '(' || c == '[' ) stack.push(c);
            else {
                if(stack.isEmpty()) return false;
                
                if(stack.peek() == '(' && c == ')') {
                    stack.pop();
                } else if(stack.peek() == '{' && c == '}') {
                    stack.pop();
                } else if(stack.peek() == '[' && c == ']'){
                    stack.pop();
                } else return false;
                
            }
        }
        
        return stack.isEmpty();
    }
    
    public int solution(String s) {
        int answer = 0;
        
        int size = s.length();
        for(int i = 0; i < size; i++) {
            String str = s.substring(i, s.length()) + s.substring(0, i);
            if(chk(str)) answer++;
        }
        
        
        return answer;
    }
}