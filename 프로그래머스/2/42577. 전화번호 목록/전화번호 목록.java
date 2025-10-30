import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Map<String, String> map = new HashMap<>();
        for(String s : phone_book) map.put(s, s);
        
        for(int i = 0; i < phone_book.length; i++) {
            String str = phone_book[i];
            for(int j = 0; j < str.length(); j++){
                String temp = str.substring(0, j);
                if(map.containsKey(temp)) {
                    answer = false;
                    i = phone_book.length;
                    break;
                }
                
            }
        }
        
        
        return answer;
    }
}