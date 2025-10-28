import java.util.*;

class Solution {
    static final int[] one = {1, 2, 3, 4, 5};
    static final int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
    static final int[] thr = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    
    public List<Integer> solution(int[] answers) {
        
        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;
        
        for(int i = 0; i < answers.length; i++) {
            int n = answers[i];
            if(n == one[i % one.length]) sum1++;
            if(n == two[i % two.length]) sum2++;
            if(n == thr[i % thr.length]) sum3++;
        }
        
        List<Integer> lst = new ArrayList<>();
        lst.add(sum1);
        lst.add(sum2);
        lst.add(sum3); 
        Collections.sort(lst, Collections.reverseOrder());
        List<Integer> answer = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            if(lst.get(0) == sum1) {
                answer.add(1);
                sum1++;
            } else if(lst.get(0) == sum2) {
                answer.add(2);
                sum2++;
            } else if(lst.get(0) == sum3) {
                answer.add(3);
                sum3++;
            }
        }
        
        return answer;
    }
}