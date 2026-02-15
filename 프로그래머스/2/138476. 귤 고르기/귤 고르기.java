import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new TreeMap<>();
        for(int i : tangerine) {
            map.put(i , map.getOrDefault(i, 0) + 1);
        }
        
        List<Integer> lst = new ArrayList<>();
        for(int i : map.keySet()) {
            lst.add(map.get(i));
        }
        
        Collections.sort(lst, Collections.reverseOrder());
        int sum = 0;
        for(int i = 0; i < lst.size(); i++) {
            sum += lst.get(i);
            if(sum >= k) return i + 1;
        }
        
        
        return answer;
    }
}