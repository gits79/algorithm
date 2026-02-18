class Solution {
    
    static int[] getNum(int n, int brown) {
        int[] arr = new int[2];
        
        for(int i = 3; i <= n/2 + 1; i++) {
            if(n % i == 0) {
                int x = n / i;
                int y = i;
                if(x * y == n && (x - 2) * (y - 2) + brown == n){
                    arr[0] = x;
                    arr[1] = y;
                    break;
                }
            }
        }
        return arr;
    }
    
    public int[] solution(int brown, int yellow) {
        int[] answer = getNum(brown + yellow, brown);
        return answer;
    }
}