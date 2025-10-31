import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        boolean[] v = new boolean[n + 1];
        List<Integer> remain = new ArrayList<>();
        List<Integer> lose = new ArrayList<>();
        for(int k : reserve) remain.add(k);
        for(int k : lost) {
            if(remain.contains(k)){
              remain.remove(Integer.valueOf(k));  
            } 
            else {
                lose.add(k);
            }
        }
        Collections.sort(lose);
        for(int k : lose) {
            if(remain.contains(k - 1)) remain.remove(Integer.valueOf(k - 1));
            else if(remain.contains(k + 1)) remain.remove(Integer.valueOf(k + 1));
            else answer--;
        }
        
        
        return answer;
    }
}