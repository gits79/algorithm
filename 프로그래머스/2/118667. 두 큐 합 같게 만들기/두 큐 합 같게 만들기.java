import java.util.*;

class Solution {
    
    static long sum(int[] arr){
        long sum = 0;
        for(int n : arr) sum += (long) n;
        return sum;
    }
    
    public int solution(int[] queue1, int[] queue2) {

        ArrayDeque<Long> q1 = new ArrayDeque<>();
        ArrayDeque<Long> q2 = new ArrayDeque<>();
        
        long sum1 = sum(queue1);
        long sum2 = sum(queue2);
        
        for(int n : queue1) q1.offer((long)n);
        for(int n : queue2) q2.offer((long)n);
        
        int cnt = 0;
        boolean flag = false;
        
        for(int i = 0; i < 300000; i++) {
            if(sum1 == sum2) {
                flag = true;   
                break;
            }
            
            if(sum1 < sum2) {
                long l = q2.poll();
                sum2 -= l;
                q1.offer(l);
                sum1 += l;
            }
            else{
                long l = q1.poll();
                sum1 -= l;
                q2.offer(l);
                sum2 += l;
            }
            
            cnt++;
        }
        
        
        
        
        
        return flag ? cnt : -1;
        
    }
}