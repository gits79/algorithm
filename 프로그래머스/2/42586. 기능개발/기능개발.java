import java.util.*;

class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        
        
        
        Queue<Integer> q = new ArrayDeque<>();
        
        for(int i = 0; i < progresses.length; i++){
            int remain = 100 - progresses[i];
            int days = (remain + speeds[i] - 1) / speeds[i];
            q.offer(days);
        }
        
        List<Integer> answer = new ArrayList<>();
        
        int cur = q.poll();
        int cnt = 1;
        
        while(!q.isEmpty()) {
            int next = q.poll();
            if(next <= cur) cnt++;
            else{
                answer.add(cnt);
                cnt = 1;
                cur = next;
            }
        }
        
        answer.add(cnt);
        
        return answer;
    }
}