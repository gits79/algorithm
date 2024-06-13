
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int current = 1;
		
		for(int i = 0; i < n; i ++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			if (a == current) {
				current = b;
			}
			else if (b == current) {
				current = a;
			}
		}
		System.out.println(current);
	}
}
