import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < clothes.length; i++) {
            String key = clothes[i][1];
            String value = clothes[i][0];
            map.put(key, map.getOrDefault(key , 0) + 1);
        }
        List<Integer> lst = new ArrayList<>();
        for(String s : map.keySet()) {
            int n = map.get(s);
            answer *= n + 1;
        }
        
        return answer - 1;
    }
}