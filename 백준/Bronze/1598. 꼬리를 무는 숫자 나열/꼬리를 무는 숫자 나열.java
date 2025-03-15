import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int x1, y1, x2, y2 = 0;
		
		if(A % 4 == 0) {
			x1 = A / 4;
			y1 = 1;
		}else {
			x1 = (A / 4) + 1;
			y1 = 5 - (A % 4);
		}
		
		if(B % 4 == 0) {
			x2 = B / 4;
			y2 = 1;
		}else {
			x2 = (B / 4) + 1;
			y2 = 5 - (B % 4);
		}
		
		System.out.println(Math.abs(x2 - x1) + Math.abs(y2 - y1));
	}

}