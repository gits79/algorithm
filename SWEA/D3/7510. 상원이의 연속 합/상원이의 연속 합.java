import java.util.Scanner;
class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
            int n = sc.nextInt();
            int result = 0;
            for(int i = 1 ; i <= n; i++){
            	int sum = 0;
                for(int j = i; j <= n; j++){
                    sum += j;
                    if(sum == n){
                        result++;
                        break;
                    }else if(sum > n){
                        break;
                    }
                }
            }
            System.out.println("#" + tc + " " + result);
		}
	}
}