import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people); 
        int left = 0;         
        int right = people.length - 1;  

        while (left <= right) {
            int temp = people[left] + people[right];

            if (temp <= limit) {
                left++;  
            }
            right--;  
            answer++;  
        }

        return answer;
    }

   
}
