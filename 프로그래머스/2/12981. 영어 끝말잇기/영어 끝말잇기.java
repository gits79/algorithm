import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {};

        int size = words.length;
        String str = words[0];
        Map<String, String> map = new HashMap<>();
        map.put(str, str);
        map.containsKey(str);
        int idx = 0;
        for(int i = 1; i < size; i++) {
            String temp = words[i];
            if(map.containsKey(temp)) {
                idx = i + 1;
                break;
            }
            else {
                if(temp.charAt(0) == (str.charAt(str.length() - 1)) 
                   && temp.length() > 1) {
                    map.put(temp, temp);
                    str = temp;
                }
                else {
                    idx = i + 1;
                    break;
                }
            }
        }
        
        answer = new int[2];
        if(idx == 0) {
            answer[0] = 0;
            answer[1] = 0;
        }
        else{
            answer[0] = (idx % n == 0 ? n : idx % n);
            answer[1] = (idx % n == 0 ? idx / n : idx / n + 1);
        }
        
        return answer;
    }
}