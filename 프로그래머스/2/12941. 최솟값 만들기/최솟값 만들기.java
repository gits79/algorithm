import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;

        Integer[] arr = new Integer[A.length];
        for(int i = 0; i < A.length; i++)
            arr[i] = A[i];
        
        Arrays.sort(arr, Collections.reverseOrder());
        Arrays.sort(B);
        
        for(int i = 0; i < A.length; i++)
            answer += arr[i] * B[i];
        
        return answer;
    }
}