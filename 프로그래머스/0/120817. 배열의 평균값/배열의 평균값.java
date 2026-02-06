class Solution {
    public double solution(int[] numbers) {
        double answer = 0;
        for(int i : numbers) {
            answer += i;
        }
        double d = numbers.length;
        return answer / d;
    }
}