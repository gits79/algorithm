class Solution {
    
    static int answer, N;
    
    static void dfs(int target, int[] numbers, int sum, int cur){
        if(cur == N) {
            if(sum == target) answer++;
            return;
        }
        dfs(target, numbers, sum + numbers[cur], cur + 1);
        dfs(target, numbers, sum - numbers[cur], cur + 1);
    }
    
    public int solution(int[] numbers, int target) {
        N = numbers.length;
        answer = 0;
        
        dfs(target, numbers, 0, 0);
        
        return answer;
    }
}