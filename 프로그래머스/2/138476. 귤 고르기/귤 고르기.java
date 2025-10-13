import java.util.*;



class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
    
        Map<Integer, Integer> map = new TreeMap<>();
        
        for(int i : tangerine){
            if(map.containsKey(i)) map.replace(i, map.get(i) + 1);
            else map.put(i , 1);
        }
        

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int cnt : map.values()) pq.offer(cnt);
        
        while(k > 0) {
            k -= pq.poll();
            answer++;
        }
        
        
        return answer;
    }
}