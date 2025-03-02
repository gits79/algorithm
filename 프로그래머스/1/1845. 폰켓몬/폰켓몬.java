import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        Map<Integer, Integer> resultMap = new HashMap<>();

        for (int num : nums) {
            resultMap.put(num, resultMap.containsKey(num) ? resultMap.get(num) + 1 : 1);
        }

        answer = resultMap.size();

        int obtainCnt = Math.abs(nums.length / 2);

        return answer < obtainCnt ? answer : obtainCnt;
    }
}