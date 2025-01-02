import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1;tc<=T; tc++) {
			int N = sc.nextInt();
			N = N*2; 
			int H = N/60;
			int M = N%60;
			System.out.println("#"+tc+" "+H+" "+M);
		}
	}
}
