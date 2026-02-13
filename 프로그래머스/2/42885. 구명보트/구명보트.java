import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int sum = 0;
        Arrays.sort(people);
        int left = 0, right = people.length - 1;

        while(left <= right) {
            if(people[left] + people[right] <= limit)
                left++;
            right--;
            answer++;
        }
        
        return answer;
    }
}