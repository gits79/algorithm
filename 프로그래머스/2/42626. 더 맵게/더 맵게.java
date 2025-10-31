import java.util.*;

class Solution {
    
    public static boolean check(PriorityQueue<Integer> q, int k){
        for(int n : q) if(n < k) return false;
        return true;
    }
    
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i : scoville) q.offer(i);
        
        while(!check(q, K)) {
            int min1 = q.poll();
            if(q.isEmpty()) return -1;
            int min2 = q.poll();
            q.offer(min1 + (min2 * 2));
            answer++;
            // if(q.size() == 2) {
            //     if(check(q, K)) {
            //         break;
            //     }
            //     else return -1;
            // }
        }
        return answer;
    }
}