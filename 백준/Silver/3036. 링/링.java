import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class Main {
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		int N = Integer.parseInt(br.readLine());
 
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
 		
		int ring1 = Integer.parseInt(st.nextToken());   

        for (int i = 1; i < N; i++) {
			int rings = Integer.parseInt(st.nextToken());
			int gcd = gcd(ring1, rings);
			System.out.println((ring1 / gcd) + "/" + (rings / gcd));
		}
 
	}
	static int gcd(int x, int y) {
		int temp;
		while (y != 0) {
			temp = x % y;
			x = y;
			y = temp;
		}
		return x;
	}
}